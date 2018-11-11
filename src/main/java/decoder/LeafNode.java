package decoder;

import java.util.HashMap;
import java.util.Map;

public class LeafNode implements TreeNode {


    private final char symbol;

    private Map<Character, TreeNode> treeMap;

    public LeafNode(char symbol) {
        this.symbol = symbol;
        this.treeMap = new HashMap<>();
    }

    @Override
    public void addNode(char codeSymbol, TreeNode node) {
        throw new IllegalStateException("Cannot add a new node to leaf node");
    }

    @Override
    public Map<Character, TreeNode> getTreeMap() {
        return this.treeMap;
    }

    @Override
    public String getClassType() {
        return "LeafNode";
    }
}
