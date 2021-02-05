package com.test;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Test t = new Test();
        t.test();
    }

    public void test(){
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        pairs.add(new Pair( "H" , "G"));
        pairs.add(new Pair( "F" , "G"));
        pairs.add(new Pair( "G" , "D"));
        Map<Object, Node> temp = new HashMap<>();
        for (Pair pair: pairs) {
            Node parent = temp.getOrDefault(pair.parentId, new Node(pair.parentId));
            Node child = temp.getOrDefault(pair.childId, new Node(pair.childId));
            parent.children.add(child);
            child.parent = parent;
            temp.put(parent.id, parent);
            temp.put(child.id, child);
        }

        Node root;
        for (Node n: temp.values()) {
            if (n.parent == null) {
                root = n;
                break;
            }
        }
    }

    class Node {
        Object id;
        List<Node> children;
        Node parent;

        public Node(Object id) {
            this.id = id;
            children = new LinkedList<>();
        }
    }

    class Pair {
        private String childId ;
        private String parentId;

        public Pair(String childId, String parentId) {
            this.childId = childId;
            this.parentId = parentId;
        }
        public String getChildId() {
            return childId;
        }
        public void setChildId(String childId) {
            this.childId = childId;
        }
        public String getParentId() {
            return parentId;
        }
        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

    }


}
