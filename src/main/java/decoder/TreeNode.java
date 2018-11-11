package decoder;

import java.util.Map;

public interface TreeNode {

    void addNode(char codeSymbol, TreeNode node);

    Map<Character, TreeNode> getTreeMap();

    String getClassType();
}
