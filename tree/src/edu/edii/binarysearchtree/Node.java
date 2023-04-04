package edu.edii.binarysearchtree;

public class Node<E> {
    // valor do Nó
    private E value;
    // referência para o pai deste Nó
    private Node<E> parent;
    // filho a esquerda
    private Node<E> left;
    // filho a direita
    private Node<E> right;
    // valor chave
    private int key;

    // construtor
    public Node(int key, E value) {
        this.key = key;
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
    

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node [key=" + key + ", value=" + value + "]";
    }

    
    
}
