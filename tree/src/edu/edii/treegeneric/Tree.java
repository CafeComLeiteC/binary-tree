package edu.edii.treegeneric;

import java.util.ArrayList;
import edu.edii.exceptions.*;

public class Tree<E> {
    // raiz da árvore
    protected Node<E> root;

    // Verifica se o nó é interno, ou seja, verifica se ele tem filhos
    public boolean isInternal(Node<E> node) {
        return node.getChildren().size() > 0;
        // return !node.getChildren().isEmpty();
    }

    // Verifica se o nó é externo(folha), ou seja, verifica se ele não tem filhos
    public boolean isExternal(Node<E> node) {
        return node.getChildren().size() == 0;
        // return node.getChildren().isEmpty();
    }

    // isRoot(): verifica se um nó é raiz.
    public boolean isRoot(Node<E> node) {
        // return node.getParent() == null;
        return node == this.root;
    }

    // isEmpty(): verifica se a árvore está vazia.
    public boolean isEmpty() {
        return this.root == null;
    }

    // root( ): Retorna a raiz da árvore; um erro ocorre se a árvore está vazia.
    // (EmptyTreeException)
    public Node<E> root() {
        if (isEmpty())
            throw new EmptyTreeException("A árvore está vazia!");
        return this.root;
    }

    // parent(v): Retorna o nodo pai de v; ocorre um erro se v for raiz.
    // (BoundaryViolationException)
    public Node<E> parent(Node<E> node){
        if(isRoot(node)) 
            throw new BoundaryViolationException("Este nó é raiz!");
        return node.getParent();
    }

    // children(v): Retorna uma coleção iterável contendo os filhos do nodo v.
    public ArrayList<Node<E>> children(Node<E> node){
        return node.getChildren();
    }

    public boolean addRoot(Node<E> node){
        //verificar se a árvore está vazia
        if(isEmpty()){
            this.root = node;
            return true;
        }
        return false;
    }

    public Node<E> addChild(Node<E> parent, Node<E> child){
        //atribui o pai para o novo nó criado
        child.setParent(parent);
        //recuperando a lista de filhos do pai e adicionando o novo nó
        parent.getChildren().add(child);
        return child;
    }


}
