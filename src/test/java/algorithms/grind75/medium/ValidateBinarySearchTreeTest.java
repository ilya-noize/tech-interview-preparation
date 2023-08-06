package algorithms.grind75.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.grind75.domain.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidateBinarySearchTreeTest {

    private final ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    @ParameterizedTest
    @MethodSource("assignTestData")
    public void testBruteForeSolution(TreeNode root, boolean result) {
        boolean isValid = validateBinarySearchTree.isValidBST(root);
        assertEquals(result, isValid);
    }

    private static Stream<Arguments> assignTestData() {
        return Stream.of(
            Arguments.of(
                //[5,1,4,null,null,3,6]
                //       5
                //    1     4
                //        3   6
                new TreeNode(5,
                    new TreeNode(1),
                    new TreeNode(4, new
                        TreeNode(3), new TreeNode(6))),
                false
            ),
            Arguments.of(
                //[2,1,3]
                //       2
                //    1     3
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                ),
                true
            )
        );
    }

}