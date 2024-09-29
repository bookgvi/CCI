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
//        AhoCorasick trie = new AhoCorasick(new String[]{"!indexesStack.isEmpty()"});
        Map<String, List<Integer>> textToIndexesMap = trie.searchWords(text);

        List<TextInfo> textInfoList = new ArrayList<>();
        List<TextInfo> blockInfoList = new ArrayList<>();
        for (List<Integer> indexes : textToIndexesMap.values()) {
            for (int index : indexes) {
                TextInfo lineDto = textUtils.getLineByIndex(textDto, index);
                textInfoList.add(lineDto);
                TextInfo blockInfo = textUtils.getBlockStartedAtIndex(textDto, index);
                blockInfoList.add(blockInfo);
            }
        }
        Assert.assertFalse(textInfoList.isEmpty());
        Assert.assertFalse(blockInfoList.isEmpty());
    }
}