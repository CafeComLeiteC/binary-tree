package edu.edii.treegeneric;

import java.util.ArrayList;

public class Node<E> {
    // valor do Nó
    protected E value;
    // referência para o pai deste Nó
    protected Node<E> parent;
    // filhos do Nó
    protected ArrayList<Node<E>> children;

    // construtor
    public Node(E value) {
        this.value = value;
        //instanciando a lista de filhos
        this.children = new ArrayList<>();
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
    public ArrayList<Node<E>> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Node<E>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    
    
}
