package ru.starkov.third_week.subtree_of_another_tree;


import ru.starkov.util.TreeNode;

import java.util.*;

public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        Map<TreeNode, Boolean> map = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            map.put(current, isSameTree(current, subRoot));
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return map.containsValue(true);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        Queue<TreeNode> stackOfP = new ArrayDeque<>();
        Queue<TreeNode> stackOfQ = new ArrayDeque<>();

        stackOfP.add(p);
        stackOfQ.add(q);

        while (!stackOfP.isEmpty() || !stackOfQ.isEmpty()) {
            TreeNode currentP = stackOfP.remove();
            TreeNode currentQ = stackOfQ.remove();
            if (currentP.val != currentQ.val) {
                return false;
            } else {
                if (currentP.left != null && currentQ.left != null) {
                    stackOfP.add(currentP.left);
                    stackOfQ.add(currentQ.left);

                }
                if (currentP.right != null && currentQ.right != null) {
                    stackOfP.add(currentP.right);
                    stackOfQ.add(currentQ.right);

                }
                if (currentP.left == null && currentQ.left != null) {
                    return false;
                }
                if (currentP.left != null && currentQ.left == null) {
                    return false;
                }
                if (currentP.right == null && currentQ.right != null) {
                    return false;
                }
                if (currentP.right != null && currentQ.right == null) {
                    return false;
                }
            }
        }
        return true;
    }
















//    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        if (root == null || subRoot == null) {
//            return false;
//        }
//        String stringFromTreeNode = createStringFromTreeNode(subRoot);
//
//        List<String> stringsOfRoots = new ArrayList<>();
//
//        Queue<TreeNode> rootQueue = new ArrayDeque<>();
//        rootQueue.add(root);
//        while (!rootQueue.isEmpty()) {
//            TreeNode currentNode = rootQueue.poll();
//            stringsOfRoots.add(createStringFromTreeNode(currentNode));
//            if (currentNode.left != null) {
//                rootQueue.add(currentNode.left);
//            }
//            if (currentNode.right != null) {
//                rootQueue.add(currentNode.right);
//            }
//        }
//        return stringsOfRoots.contains(stringFromTreeNode);
//    }

//    private static String createStringFromTreeNode(TreeNode subRoot) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(subRoot);
//        while (!queue.isEmpty()) {
//            TreeNode currentSubRoot = queue.poll();
//            stringBuilder.append(currentSubRoot.val);
//            if (currentSubRoot.left != null) {
//                queue.add(currentSubRoot.left);
//            }
//            if (currentSubRoot.right != null) {
//                queue.add(currentSubRoot.right);
//            }
//        }
//        return stringBuilder.toString();
//    }



    /*public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        TreeNode sameSubRoot = findSameSubRoot(root, subRoot);
        if (sameSubRoot == null) {
            return false;
        } else {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(sameSubRoot);
            queue.add(subRoot);
            while (!queue.isEmpty()) {
                TreeNode currentRoot = queue.poll();
                TreeNode currentRootOfSubRoot = queue.poll();
                if (currentRoot != null && currentRootOfSubRoot != null) {
                    if (isSameRoot(currentRoot, currentRootOfSubRoot)) {
                        if (currentRoot.left != null) {
                            queue.add(currentRoot.left);
                        }
                        if (currentRootOfSubRoot.left != null) {
                            queue.add(currentRootOfSubRoot.left);
                        }

                        if (currentRoot.right != null) {
                            queue.add(currentRoot.right);
                        }

                        if (currentRootOfSubRoot.right != null) {
                            queue.add(currentRootOfSubRoot.right);
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static TreeNode findSameSubRoot(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (isSameRoot(currentNode, subRoot)) {
                return currentNode;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return null;
    }

    public static boolean isSameRoot(TreeNode currentNode, TreeNode subRoot) {
        return (currentNode.val == subRoot.val) && (maxDepth(currentNode) == maxDepth(subRoot));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }*/
}
