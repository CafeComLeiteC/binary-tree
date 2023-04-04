package edu.edii.binarysearchtreeavl;

import edu.edii.binarysearchtree.*;

public class BinarySearchTreeAVL<E> extends BinarySearchTree<E> {
    /* ALTURA DA ÁRVORE */
    private int height(Node<E> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
        }
    }

    /* FATOR DE BALANCEAMENTO */
    private int getFB(Node<E> t) {
        return height(t.getRight()) - height(t.getLeft());
    }

    /*
     * (1) O filho a esquerda do filho a direita do nó desbalanceado passa a ser o
     * filho a direita do nó desbalanceado. (2) O nó desbalanceado passa a ser filho
     * a esquerda do seu antigo filho a direita.
     */
    private Node<E> rotateLeft(Node<E> noDesb) {
        Node<E> filhoD = noDesb.getRight();
        noDesb.setRight(filhoD.getLeft());
        if (filhoD.getLeft() != null)
            filhoD.getLeft().setParent(noDesb);
        filhoD.setLeft(noDesb);
        filhoD.setParent(noDesb.getParent());
        noDesb.setParent(filhoD);
        return filhoD;
    }

    /*
     * (1) O filho a direita do filho a esquerda do nó desbalanceado passa a ser o
     * filho a esquerda do nó desbalanceado. (2) O nó desbalanceado passa a ser
     * filho a direita do seu antigo filho a esquerda.
     */
    private Node<E> rotateRight(Node<E> noDesb) {
        Node<E> filhoE = noDesb.getLeft();
        noDesb.setLeft(filhoE.getRight());
        if (filhoE.getRight() != null)
            filhoE.getRight().setParent(noDesb);
        filhoE.setRight(noDesb);
        filhoE.setParent(noDesb.getParent());
        noDesb.setParent(filhoE);
        return filhoE;
    }

    private Node<E> balance(Node<E> t) {
        Node<E> aux = t;
        if (t != null) {
            /* Desbalanceada a direita */
            if (getFB(t) == 2) {
                if (getFB(t.getRight()) == -1)
                    t.setRight(rotateRight(t.getRight()));
                aux = rotateLeft(t);
            }
            /* Desbalanceada a esquerda */
            else if (getFB(t) == -2) {
                if (getFB(t.getLeft()) == 1)
                    t.setLeft(rotateLeft(t.getLeft()));
                aux = rotateRight(t);
            }
        }
        return aux;
    }

    /* Remover */
    
    public Node<E> remove(Node<E> n, int k) {
        if (n != null) {
            if (k < n.getKey()) {
                n.setLeft(remove(n.getLeft(), k));
                n = balance(n);
            } else if (k > n.getKey()) {
                n.setRight(remove(n.getRight(), k));
                n = balance(n);
            } else if (isExternal(n))
                return null;
            else if (n.getLeft() == null) {
                if (!isRoot(n))
                    n.getRight().setParent(n.getParent());
                n = n.getRight();
            } else if (n.getRight() == null) {
                if (!isRoot(n))
                    n.getLeft().setParent(n.getParent());
                n = n.getLeft();
            } else {
                n.setRight(menorDir(n, n.getRight()));
            }
        }
        return n;
    }

    @Override
    public Node<E> put(Node<E> n, Node<E> a, int k, E v) {
        if (n == null) {
            Node<E> t = new Node<>(k, v);
            t.setParent(a);
            return t;
        } else {
            if (k < n.getKey()) {
                n.setLeft(put(n.getLeft(), n, k, v));
            } else {
                n.setRight(put(n.getRight(), n, k, v));
            }
        }
        n = balance(n);
        return n;
    }
}