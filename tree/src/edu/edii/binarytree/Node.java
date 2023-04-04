package edu.edii.binarytree;

public class Node<E> {
    // valor do Nó
    private E value;
    // referência para o pai deste Nó
    private Node<E> parent;
    // filho a esquerda
    private Node<E> left;
    // filho a direita
    private Node<E> right;

    // construtor
    public Node(E value) {
        this.value = value;
    }

    // getters e setters
    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
    public Node<E> getParent() {
        return parent;
    }
    public void setParent(Node<E> parent) {
        this.parent = parent;
    }
    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
}
