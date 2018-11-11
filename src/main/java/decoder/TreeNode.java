package decoder;

import java.util.Map;

public interface TreeNode {

    String TRANSITION_NODE = "TransitionNode";

    String LEAF_NODE = "LeafNode";

    void addNode(char codeSymbol, TreeNode node);

    Map<Character, TreeNode> getTreeMap();

    char getDecodedChar() throws IllegalStateException;

    String getClassType();
}
