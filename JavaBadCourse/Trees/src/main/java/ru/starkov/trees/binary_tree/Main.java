package ru.starkov.trees.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        List<Data> items = new ArrayList<>();
        items.add(new Data(1, "Соки", 0));
        items.add(new Data(2, "Манго", 1));
        items.add(new Data(3, "Виноградный", 1));
        items.add(new Data(4, "Яблочный", 1));
        items.add(new Data(5, "Газировка", 0));
        items.add(new Data(6, "Кола", 5));
        items.add(new Data(7, "Кола 0.5л", 6));
        items.add(new Data(8, "Кола 1.5л", 6));
        items.add(new Data(9, "Минералка", 5));
        items.add(new Data(10, "Лимонад", 5));

        DataNode dataNode = DataNode.makeTree(items, new TreeNode.TypeAdapter<Data, DataNode>() {
            @Override
            public DataNode newInstance() {
                return new DataNode();
            }

            @Override
            public boolean isChildOf(Data parentNodeData, Data childNodeData) {
                return childNodeData.parentId == parentNodeData.id;
            }

            @Override
            public boolean isRoot(Data data) {
                return data.parentId == 0;
            }
        });

        String names = dataNode.reduce(new BiFunction<DataNode, String, String>() {
            @Override
            public String apply(DataNode dataNode, String s) {
                if (dataNode.data != null && dataNode.children == null || dataNode.children.isEmpty()) {
                    s = s + ", ";
                }
                if (dataNode.data != null) {
                    s = s + dataNode.data.name();
                }
                return s;
            }

        }, "");
        System.out.println(names);
    }

    private static class DataNode extends TreeNode<Data, DataNode> {
        @Override
        public String toString() {
            return data.name;
        }
    }

    private record Data(int id, String name, int parentId) {

        @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj == null || obj.getClass() != this.getClass()) return false;
                var that = (Data) obj;
                return this.id == that.id &&
                        Objects.equals(this.name, that.name) &&
                        this.parentId == that.parentId;
            }

        @Override
            public String toString() {
                return "Data[" +
                        "id=" + id + ", " +
                        "name=" + name + ", " +
                        "parentId=" + parentId + ']';
            }

    }
}
