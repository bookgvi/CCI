package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

final class TextUtils {

    /**
     * Reads text content from a file specified by the given path.
     *
     * @param path the path to the file from which text is to be read
     * @return an instance of TextInfo containing the text content read from the file
     */
    public TextInfo getTextFromFile(String path) {
        TextInfo res = new TextInfo();
        res.setPath(path);
        Path filePath = Paths.get(path);
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            StringBuilder sb = new StringBuilder();
            final int[] index = {0};
            final int[] lineNum = {1};
            Map<Integer, String> indexToTextMap = res.getIndexToTextMap();
            Map<Integer, Integer> indexToLineMap = res.getIndexToLineMap();
            bufferedReader.lines().forEach(line -> {
                if (!line.isEmpty()) {
                    sb.append(line);
                    indexToTextMap.put(index[0], line);
                    indexToLineMap.put(index[0], lineNum[0]);
                    index[0] = index[0] + line.length();
                }
                lineNum[0] += 1;
            });
            res.setText(sb.toString());
        } catch (IOException ignored) {
            // ignore
        }
        return res;
    }

    /**
     * Retrieves a specific line from the given TextInfo object based on the provided index.
     *
     * @param textInfo the TextInfo object containing the lines of text
     * @param index the index of the line to retrieve
     * @return the TextInfo object for text corresponding to the given index
     */
    public TextInfo getLineByIndex(TextInfo textInfo, int index) {
        TextInfo res = new TextInfo();
        int resultIndex = -1;
        res.setPath(textInfo.getPath());
        Map<Integer, String> indexToTextMap = textInfo.getIndexToTextMap();
        List<Integer> indexes = List.copyOf(indexToTextMap.keySet());
        int l = 0, r = indexes.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (indexes.get(mid) < index) {
                l = mid + 1;
            } else if (indexes.get(mid) > index) {
                r = mid - 1;
            } else {
                resultIndex = indexes.get(mid);
            }
        }
        if (resultIndex == -1) {
            resultIndex = indexes.get(r);
        }
        String resultText = indexToTextMap.getOrDefault(resultIndex, "");
        int lineNum = textInfo.getIndexToLineMap().getOrDefault(resultIndex, -1);
        res.setText(resultText);
        res.getIndexToTextMap().put(resultIndex, resultText);
        res.getIndexToLineMap().put(resultIndex, lineNum);
        return res;
    }
}
