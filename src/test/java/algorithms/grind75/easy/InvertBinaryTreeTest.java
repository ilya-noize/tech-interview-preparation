package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InvertBinaryTreeTest {

    private final InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(TreeNode root, TreeNode result) {
        TreeNode invertedTree = invertBinaryTree.invertTree(root);
        assertEquals(result, invertedTree);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(
                //[4,2,7,1,3,6,9]
                //       4
                //    2     7
                // 1    3 6   9
                new TreeNode(4,
                    new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                    new TreeNode(7, new
                        TreeNode(6), new TreeNode(9))),
                //[4,7,2,9,6,3,1]
                //       4
                //    7     2
                // 9    6 3   1
                new TreeNode(4,
                    new TreeNode(7,
                        new TreeNode(9), new TreeNode(6)),
                    new TreeNode(2, new
                        TreeNode(3), new TreeNode(1)))
            )
        );
    }
}