package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BalancedBinaryTreeTest {

    private final BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(TreeNode root, boolean result) {
        boolean isBalanced = balancedBinaryTree.isBalanced(root);
        assertEquals(result, isBalanced);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(
                //[3,9,20,null,null,15,7]
                //       3
                //    9     20
                //       15   17
                new TreeNode(3,
                    new TreeNode(9),
                    new TreeNode(20, new
                        TreeNode(15), new TreeNode(17))),
                true
            ),
            Arguments.of(
                //[1,2,2,3,3,null,null,4,4]
                //          1
                //       2     2
                //    3    3
                //  4   4
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(3,
                            new TreeNode(4),
                            new TreeNode(4)
                        ),
                        new TreeNode(3)
                    ),
                    new TreeNode(2)
                ),
                false
            )
        );
    }

}