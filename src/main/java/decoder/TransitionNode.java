package decoder;

import java.util.HashMap;
import java.util.Map;

public class TransitionNode implements TreeNode {

    private Map<Character, TreeNode> treeMap;

    public TransitionNode() {
        this.treeMap = new HashMap<>();
    }

    @Override
    public void addNode(char codeSymbol, TreeNode node) {
        this.treeMap.put(codeSymbol, node);
    }

    @Override
    public Map<Character, TreeNode> getTreeMap() {
        return this.treeMap;
    }

    @Override
    public String getClassType() {
        return "TransitionNode";
    }
}
