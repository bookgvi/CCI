package trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextUtilsTest {

    @Test
    public void getTextFromFile() {
        String path = "/Users/bookgvi/IdeaProjects/CCI/src/main/java/trie/TextUtils.java";
        TextUtils textUtils = new TextUtils();
        TextInfo textDto = textUtils.getTextFromFile(path);

        String text = textDto.getText();
        AhoCorasick trie = new AhoCorasick(new String[]{"class"});
        Map<String, List<Integer>> textToIndexesMap = trie.searchWords(text);

        List<TextInfo> textInfoList = new ArrayList<>();
        for (List<Integer> indexes : textToIndexesMap.values()) {
            for (int index : indexes) {
                TextInfo lineDto = textUtils.getLineByIndex(textDto, index);
                textInfoList.add(lineDto);
            }
        }
        Assert.assertFalse(textInfoList.isEmpty());
    }
}