package ru.starkov.trees.prefix_tree;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class PrefixTreeNode {
    public List<PrefixTreeNode> children;
    private char value;
    public PrefixTreeNode(char value) {
        this.value = value;
    }

    public void insertData(String data) {
        if (data == null || data.isEmpty() || data.isBlank()) {
            return;
        }
        if (children == null) {
            children = new ArrayList<>();
        }
        char c = data.charAt(0);
        Optional<PrefixTreeNode> child = findNodeByChar(c);

        if (child.isEmpty()) {
            child = Optional.of(new PrefixTreeNode(c));
            children.add(child.get());
        }
        child.get().insertData(data.substring(1));
    }

    public Optional<PrefixTreeNode> findNodeByChar(char value) {
        if (children != null && !children.isEmpty()) {
            for (PrefixTreeNode node : children) {
                if (node.value == value) {
                    return Optional.of(node);
                }
            }
        }
        return Optional.empty();
    }

    public boolean containString(String string) {
        if (string == null) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (findNodeByChar(c).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getAllNumbers(PrefixTreeNode root) {
        String path = "";
        List<String> allNumbers = new ArrayList<>();
        Queue<PrefixTreeNode> queue = new ArrayDeque<>();
        Queue<String> pathQueue = new ArrayDeque<>();
        queue.add(root);
        pathQueue.add(path);
        while (!queue.isEmpty()) {
            PrefixTreeNode currentNode = queue.poll();
            String currentPath = pathQueue.poll();

            if (currentNode.value != ' ') {
                currentPath += currentNode.value;
            }
            if (currentNode.children != null) {
                for (PrefixTreeNode child : currentNode.children) {
                    queue.add(child);
                    pathQueue.add(currentPath);
                }
            } else {
                allNumbers.add(currentPath);
            }
        }
        return allNumbers;
    }

    private void writeToFile(PrintWriter printWriter) {
        printWriter.write(value);
        if (children != null) {
            for (PrefixTreeNode child : children) {
                child.writeToFile(printWriter);
            }
        }
        printWriter.write(']');
    }
    
    private void writeToFileIteratively(PrintWriter printWriter) {
        Deque<PrefixTreeNode> stack = new ArrayDeque<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            PrefixTreeNode current = stack.removeFirst();
            printWriter.write(current.value);
            if (current.children != null) {
                for(PrefixTreeNode child : current.children) {
                    stack.push(child);
                }
            }
            if (current.children == null) {
                for (int i = 0; i < stack.size(); i++) {
                    printWriter.write(']');
                }
            }
        }
    }
    public static void writeTreeToFileIteratively(String path, PrefixTreeNode root) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        root.writeToFileIteratively(printWriter);
        printWriter.flush();
        printWriter.close();
    }

    public static void writeTreeToFile(String path, PrefixTreeNode root) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        root.writeToFile(printWriter);
        printWriter.flush();
        printWriter.close();
    }

    public void readFromFile(FileReader reader) throws IOException {
        char ch;
        while ((ch = (char) reader.read()) != ']') {
            PrefixTreeNode treeNode = new PrefixTreeNode(ch);
            treeNode.readFromFile(reader);
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(treeNode);
        }
    }


    public static PrefixTreeNode readTreeFromFile(String path) throws IOException {
        PrefixTreeNode root = new PrefixTreeNode(' ');
        try (FileReader fileReader = new FileReader(path)) {
            fileReader.read();
            root.readFromFile(fileReader);
        }
        return root;
    }

    @Override
    public String toString() {
        return "node{" +
                "children=" + children +
                ", value=" + value +
                '}';
    }
}
