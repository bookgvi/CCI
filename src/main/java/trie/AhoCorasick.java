package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.LinkedList;

public class AhoCorasick {
    private final int ABC = 2000;
    private final int MAX_STATE;
    private final int[][] g;
    private final int[] suffixLinks;
    private final int[] out;
    private final String[] keyWords;

    public AhoCorasick(String[] keyWords) {
        keyWords = Optional.ofNullable(keyWords).orElse(new String[]{});
        int charsCount = Arrays.stream(keyWords).map(String::length).reduce(Integer::sum).orElse(0);
        this.keyWords = keyWords;
        MAX_STATE = charsCount + 1;
        g = new int[MAX_STATE][ABC];
        suffixLinks = new int[MAX_STATE];
        out = new int[MAX_STATE];
    }

    private void buildStateMachine(String[] keyWords) {
        int wordsCount = keyWords.length;
        for (int i = 0; i < MAX_STATE; ++i) {
            Arrays.fill(g[i], - 1);
        }
        int states = 1;
        for (int i = 0; i < wordsCount; ++i) {
            int curState = 0;
            for (int j = 0, wordLen = keyWords[i].length(); j < wordLen; ++j) {
                int ch = keyWords[i].charAt(j);
                if (g[curState][ch] == -1) {
                    g[curState][ch] = states++;
                }
                curState = g[curState][ch];

            }
            out[curState] |= (1 << i);
        }

        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(suffixLinks, -1);
        for (int ch = 0; ch < ABC; ++ch) {
            if (g[0][ch] == -1) {
                g[0][ch] = 0;
            } else if (g[0][ch] > 0) {
                suffixLinks[g[0][ch]] = 0;
                q.add(g[0][ch]);
            }
        }

        while (!q.isEmpty()) {
            int curState = q.poll();
            for (int ch = 0; ch < ABC; ++ch) {
                if (g[curState][ch] == -1) {
                    continue;
                }
                int suffLink = suffixLinks[curState];
                while (g[suffLink][ch] == -1) {
                    suffLink = suffixLinks[suffLink];
                }
                suffLink = g[suffLink][ch];
                suffixLinks[g[curState][ch]] = suffLink;
                out[g[curState][ch]] |= out[suffLink];
                q.add(g[curState][ch]);
            }
        }
    }

    private int nextState(int state, int ch) {
        int ans = state;
        while (g[ans][ch] == -1) {
            ans = suffixLinks[ans];
        }
        return g[ans][ch];
    }

    public Map<String, List<Integer>> searchWords(String text) {
        text = Optional.ofNullable(text).orElse("");
        Map<String, List<Integer>> res = new HashMap<>();
        if (text.isEmpty()) {
            return res;
        }
        buildStateMachine(keyWords);
        int state = 0;
        for (int i = 0, len = text.length(); i < len; ++i) {
            state = nextState(state, text.charAt(i));
            if (state == 0) {
                continue;
            }
            for (int j = 0, keyWordCount = keyWords.length; j < keyWordCount; ++j) {
                if ((out[state] & (1 << j)) > 0) {
                    List<Integer> indexes = res.getOrDefault(keyWords[j], new ArrayList<>());
                    indexes.add(i - keyWords[j].length() + 1);
                    res.putIfAbsent(keyWords[j], indexes);
                }
            }
        }
        return res;
    }
}
