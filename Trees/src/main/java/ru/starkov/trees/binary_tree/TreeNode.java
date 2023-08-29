package ru.starkov.trees.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class TreeNode<T, N extends TreeNode<T, N>> {
    T data;
    N parent;
    ArrayList<N> children;

    public TreeNode() {
    }

    public TreeNode(T data, N parent, ArrayList<N> children) {
        this.data = data;
        this.parent = parent;
        this.children = children;
    }

    public interface TypeAdapter<T, N> {
        N newInstance();
        boolean isChildOf(T parentNodeData, T childNodeData);
        boolean isRoot(T data);
    }

    public static <T, N extends TreeNode<T, N>> N makeTree(List<T> datas, TypeAdapter<T, N> typeAdapter) {
        N root = typeAdapter.newInstance();
        ArrayList<N> children = new ArrayList<>();
        root.children = children;
        for (T data : datas.stream().filter(typeAdapter::isRoot).toList()) {
            root.children.add(TreeNode.extractNode(data, root, datas, typeAdapter));
        }
        return root;
    }

    protected static <T, N extends TreeNode<T, N>> N extractNode(T data, N parent, List<T> datas, TypeAdapter<T, N> typeAdapter) {
        N currentNode = typeAdapter.newInstance();
        currentNode.data = data;
        currentNode.parent = parent;
        List<T> directChildren = datas.stream().filter(d -> typeAdapter.isChildOf(data, d)).toList();
        if (!directChildren.isEmpty()) {
            currentNode.children = new ArrayList<>();
            for (T child : directChildren) {
                currentNode.children.add(extractNode(child, currentNode, datas, typeAdapter));
            }
        }
        return currentNode;
    }

    public <R> R reduce(BiFunction<N, R, R> nrrBiFunction, R initial) {
        R value = nrrBiFunction.apply((N) this, initial);
        if (children != null) {
            for (N child : children) {
                value = child.reduce(nrrBiFunction, value);
            }
        }
        return value;
    }
}
