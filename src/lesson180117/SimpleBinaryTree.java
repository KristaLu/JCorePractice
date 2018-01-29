package lesson180117;

import java.util.*;

public class SimpleBinaryTree<E extends Comparable<E>> {

    Node<E> root;

    public void add(E value){
        root=createOrAdd(root, value);
    }
    public boolean remove(E value){
        // todo итерация по дереву
        return false;
    }

    class Node<T extends Comparable<T>>{
        T value;
        Node<T> left=null;
        Node<T> right=null;

        public Node(T value){
            this.value=value;
        }

        void add(T value){
            if (this.value.compareTo(value)>0)
                left=createOrAdd(left,value);
            else right=createOrAdd(right,value);
        }
    }

    private <X extends Comparable<X>>Node<X> createOrAdd(Node<X> node, X value) {
        if (node==null)
            node=new Node<>(value);
        else node.add(value);
        return node;
    }

    private class BFIterator implements Iterator<E> {
        Queue<Node<E>> queue = new LinkedList<>();

        public BFIterator(){
            queue.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            Node<E> cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            return cur.value;
        }
    }

    // для того, чтобы можно было вернуть два итератора bf и df
    // т.к. если писать в классе SimpleBinaryTree implements Iterable и реализовывать метод iterator,
    // то итератор будет только один
    public Iterable<E> bfIterator(){
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new BFIterator();
            }
        };
    }

    public void depthAlg(){
        stepIn(root);
    }

    private void stepIn(Node<E> node){
        if (node==null)
            return;

        //pre-order
        System.out.println(node.value);
        stepIn(node.left);
        stepIn(node.right);

        //in-order
        stepIn(node.left);
        System.out.println(node.value);
        stepIn(node.right);

        //post-order
        stepIn(node.left);
        stepIn(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(7,3,8,5,2,1,10);
        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();

        for(Integer el:list){
            tree.add(el);
        }

        // обход в ширину:
        for (Integer el : tree.bfIterator()) {
            System.out.println(el);
        }

        tree.depthAlg();
    }

//        private class DFIterator implements Iterator<E>{
//
//        @Override
//        public boolean hasNext() {
//        }
//
//        @Override
//        public E next() {
//        }
//    }
//
//    public Iterable<E> dfIterator(){
//        return new Iterable<E>() {
//            @Override
//            public Iterator<E> iterator() {
//                return new DFIterator();
//            }
//        };
//    }
}





