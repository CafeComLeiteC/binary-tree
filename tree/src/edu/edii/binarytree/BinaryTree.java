package edu.edii.binarytree;

import edu.edii.exceptions.*;
public class BinaryTree<E> {
    // raiz da árvore
    protected Node<E> root;

    // Verifica se o nó é interno, ou seja, verifica se ele tem filhos
    public boolean isInternal(Node<E> node) {
        return node.getLeft() != null || node.getRight() != null;
    }

    // Verifica se o nó é externo(folha), ou seja, verifica se ele não tem filhos
    public boolean isExternal(Node<E> node) {
        return node.getLeft() == null && node.getRight() == null;
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

    // verifica se existe filho a esquerda.
    public boolean hasLeft(Node<E> node){
        return node.getLeft() != null;
    }

    // verifica se existe filho a direita.
    public boolean hasRight(Node<E> node){
        return node.getRight() != null;
    }

    // retorna o filho da esquerda, ocorre uma condição de erro (InvalidNodeException) se n  não tiver filho a esquerda.
    public Node<E> left(Node<E> node){
        if(!hasLeft(node)) 
            throw new InvalidNodeException("Não existe filho a esquerda!");
        return node.getLeft();
    }

    // retorna o filha da direita, ocorre uma condição de erro (InvalidNodeException) se n  não tiver filho a direita.
    public Node<E> right(Node<E> node){
        if(!hasRight(node)) 
            throw new InvalidNodeException("Não existe filho a direita!");
        return node.getRight();
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

    public Node<E> addRoot(E value){
        //verificar se a árvore está vazia
        if(isEmpty()) throw new EmptyTreeException("Erro: Árvore vazia!");
        // criando o novo node
        Node<E> node = new Node<E>(value); 
        // atribuir o novo node a raiz
        this.root = node;
        return node;
    }

    // CAMINHAMENTO
    // preOrder (R-e-d)
    public void preOrder(){
        if(!isEmpty()) preOrder(this.root);
    }
    private void preOrder(Node<E> node){
       System.out.println(node);
        if(hasLeft(node))preOrder(node.getLeft());
        if(hasRight(node)) preOrder(node.getRight());
    }
    // posOrder (e-d-R)
    public void posOrder(){
        if(!isEmpty()) posOrder(this.root);
    }
    private void posOrder(Node<E> node){
        if(hasLeft(node))posOrder(node.getLeft());
        if(hasRight(node)) posOrder(node.getRight());
        System.out.println(node);
    }

    // inOrder (e-R-d)
    public void inOrder(){
        if(!isEmpty()) inOrder(this.root);
    }
    private void inOrder(Node<E> node){
        if(hasLeft(node))inOrder(node.getLeft());
        System.out.println(node);
        if(hasRight(node)) inOrder(node.getRight());
    }
}
