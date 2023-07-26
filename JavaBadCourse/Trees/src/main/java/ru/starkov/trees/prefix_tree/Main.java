package ru.starkov.trees.prefix_tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("./numbers.txt"));
        PrefixTreeNode root = new PrefixTreeNode(' ');
        for (String string : strings) {
            root.insertData(string);
        }
        System.out.println(strings);
        System.out.println("***********");
        System.out.println(PrefixTreeNode.getAllNumbers(root));
        System.out.println("***********");
        PrefixTreeNode.writeTreeToFile("./treeNumbers.txt", root);
        PrefixTreeNode node = PrefixTreeNode.readTreeFromFile("./treeNumbers.txt");
        System.out.println(PrefixTreeNode.getAllNumbers(node));
        System.out.println("***********");
        PrefixTreeNode.writeTreeToFileIteratively("./treeNumbers1.txt", root);
        System.out.println(root.toString());
        System.out.println(node.toString());

    }
}
