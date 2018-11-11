package decoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class DecoderImpl implements Decoder {

    private TreeNode rootNode;

    private Set<Character> codingSymbols;

    private Map<Character, String> symbolCodeMap;

    public DecoderImpl(String symbols) {
        if (symbols == null || "".equals(symbols)) {
            throw new IllegalStateException("codeSymbols cannot be null or empty");
        }
        codingSymbols = new HashSet<>();

        char codes[] = symbols.toCharArray();
        IntStream.range(0, codes.length)
                .forEach(i -> codingSymbols.add(codes[i]));
        rootNode = new TransitionNode();
        symbolCodeMap = new HashMap<>();
    }

    @Override
    public void addCode(char symbol, String codes) throws IllegalStateException {
        if (codes == null || "".equals(codes)) {
            throw new IllegalStateException("code for symbol cannot be null or empty");
        }
        if (symbolCodeMap.keySet().contains(symbol)) {
            throw new IllegalStateException("symbol already exists");
        }
        char codeChars[] = codes.toCharArray();
        IntStream.range(0, codeChars.length).forEach(i -> {
            if (!codingSymbols.contains(codeChars[i])) {
                throw new IllegalStateException("The coding symbol does not exist in code.");
            }
        });
        TreeNode temp = rootNode;
        for (int i = 0; i < codes.length() - 1; i++) {
            TreeNode newNode = new TransitionNode();
            Map<Character, TreeNode> treeMap = temp.getTreeMap();
            char currentCode = codes.charAt(i);
            if (treeMap.keySet().contains(currentCode)) {
                if (treeMap.get(currentCode).getClassType().equals("LeafNode")) {
                    throw new IllegalStateException("not a prefix coding");
                }
            } else {
                temp.addNode(currentCode, newNode);
            }
            temp = temp.getTreeMap().get(currentCode);
        }

        TreeNode leafNode = new LeafNode(symbol);
        char lastCode = codes.charAt(codes.length() - 1);
        if (temp.getTreeMap().keySet().contains(lastCode)) {
            if (temp.getTreeMap().get(lastCode).getClassType().equals("Transition Node")) {
                throw new IllegalStateException("Not a prefix coding.");
            } else {
                throw new IllegalStateException("Code already used for other symbol.");
            }
        }
        temp.addNode(lastCode, leafNode);
        symbolCodeMap.put(symbol, codes);

    }

    @Override
    public String decode(String encodedMessgae) throws IllegalStateException {
        return null;
    }

    @Override
    public String allCodes() {
        return null;
    }

    @Override
    public boolean isCodeComplete() {
        return false;
    }
}
