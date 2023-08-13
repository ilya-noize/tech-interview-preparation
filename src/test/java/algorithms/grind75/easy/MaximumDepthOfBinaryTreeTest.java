package algorithms.grind75.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumDepthOfBinaryTreeTest {

    private final MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();


    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testRecursiveSolution(TreeNode root, int result) {
        int depth = maximumDepthOfBinaryTree.maxDepth(root);
        assertEquals(result, depth);
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
                3
            )
        );
    }
}