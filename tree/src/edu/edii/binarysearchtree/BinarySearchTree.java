package edu.edii.binarysearchtree;
import edu.edii.exceptions.*;

public class BinarySearchTree<E> {
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
    public boolean hasLeft(Node<E> node) {
        return node.getLeft() != null;
    }

    // verifica se existe filho a direita.
    public boolean hasRight(Node<E> node) {
        return node.getRight() != null;
    }

    // retorna o filho da esquerda, ocorre uma condição de erro
    // (InvalidNodeException) se n não tiver filho a esquerda.
    public Node<E> left(Node<E> node) {
        if (!hasLeft(node))
            throw new InvalidNodeException("Não existe filho a esquerda!");
        return node.getLeft();
    }

    // retorna o filha da direita, ocorre uma condição de erro
    // (InvalidNodeException) se n não tiver filho a direita.
    public Node<E> right(Node<E> node) {
        if (!hasRight(node))
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
    public Node<E> parent(Node<E> node) {
        if (isRoot(node))
            throw new BoundaryViolationException("Este nó é raiz!");
        return node.getParent();
    }

    protected Node<E> addRoot(int k, E value) {
        // verificar se a árvore está vazia
        if (!isEmpty())
            throw new EmptyTreeException("Erro: Árvore já possui raiz!");
        // criando o novo node
        Node<E> node = new Node<E>(k, value);
        // atribuir o novo node a raiz
        this.root = node;
        return node;
    }

    // Inserir node
    // método não recursivo
    public void putNoRecursive(int k, E v) {
        // árvore vazia
        if (isEmpty())
            // adicionar novo node na raiz
            addRoot(k, v);
        else {
            // começar a busca do ponto de inserção pela raiz
            Node<E> temp = this.root;
            boolean inseriu = false;
            // enquanto não inserir o valor (encontrar o ponto de inserção)
            while (inseriu == false) {
                if (k < temp.getKey()) {
                    if (!hasLeft(temp)) {
                        insertLeftNode(temp, k, v);
                        inseriu = true;
                    } else {
                        temp = temp.getLeft();
                    }
                } else {
                    if (!hasRight(temp)) {
                        insertRightNode(temp, k, v);
                        inseriu = true;
                    } else {
                        temp = temp.getRight();
                    }
                }
            }
        }
    }

    // insertLeft(n, v): cria e retorna um nodo novo que armazena o valor v,
    // acrescenta o novo nodo como filho a esquerda de n. um condição de erro ocorre
    // caso n já tenha filho a esquerda (InvalidNodeException)
    protected Node<E> insertLeftNode(Node<E> n, int k, E v) throws InvalidNodeException {
        if (hasLeft(n))
            throw new InvalidNodeException("Já existe nó a esquerda!");
        Node<E> novo = new Node<>(k, v);
        n.setLeft(novo);
        novo.setParent(n);
        return novo;
    }

    // insertRight(n, v): cria e retorna um nodo novo que armazena o valor v,
    // acrescenta o novo nodo como filho a direita de n. um condição de erro ocorre
    // caso n já tenha filho a direita
    protected Node<E> insertRightNode(Node<E> n, int k, E v) throws InvalidNodeException {
        if (hasRight(n))
            throw new InvalidNodeException("Já existe nó a direita!");
        Node<E> novo = new Node<>(k, v);
        n.setRight(novo);
        novo.setParent(n);
        return novo;
    }

    // método recursivo para inserção
    public void put(int key, E v) {
        this.root = put(this.root, null, key, v);
    }

    protected Node<E> put(Node<E> n, Node<E> parent, int k, E v) {
        if (n == null) {
            // criando o novo node
            Node<E> t = new Node<>(k, v);
            // atribuir o pai do novo node como o node anterior
            t.setParent(parent);
            return t;
        } else {
            // procurando a posição de inserção
            if (k < n.getKey()) {
                // caso a chave passada seja menor do que o node atual verificado
                n.setLeft(put(n.getLeft(), n, k, v));
            } else {
                // caso a chave passada seja maior do que o node atual verificado
                n.setRight(put(n.getRight(), n, k, v));
            }
        }
        return n;
    }

    // METODO DE PESQUISA
    public Node<E> get(int k) {
        return get(this.root, k);
    }

    protected Node<E> get(Node<E> n, int key) {
        if (n == null)
            return null;
        else if (key == n.getKey())
            return n;
        else {
            if (key < n.getKey())
                return get(n.getLeft(), key);
            else if (key > n.getKey())
                return get(n.getRight(), key);
        }
        return n;
    }

    // REMOVER
    public void remove(int key) {
        this.root = remove(this.root, key);
    }

    protected Node<E> remove(Node<E> n, int k) {
        if (n != null) {
            // Buscando o node a ser removido
            if (k < n.getKey()) {
                n.setLeft(remove(n.getLeft(), k));
            } else if (k > n.getKey()) {
                n.setRight(remove(n.getRight(), k));
            }
            //O nó a ser removido é folha 
            else if (isExternal(n))
                return null;
            // Só existe filhos a direita do nó a ser removido: O filho da direita irá ocupar a posição do no a ser removido
            else if (n.getLeft() == null) {
                n.getRight().setParent(n.getParent());
                n = n.getRight();
            //Só existe filhos a esquerda do nó a ser removido: O filho da esquerda irá ocupar a posição do no a ser removido 
            } else if (n.getRight() == null) {
                n.getLeft().setParent(n.getParent());
                n = n.getLeft();
            //  Existem filhos a esquerda e a direita do nó a ser removido: É necessário buscar o elemento de menor chave da subárvore a direita (ou o elemento de maior chave da subárvore a esquerda) para ocupar o lugar do nó a ser removido.
            } else {
                n.setRight(menorDir(n, n.getRight()));
            }
        }
        return n;
    }

    protected Node<E> menorDir(Node<E> aRemover, Node<E> menor) {
        //O próximo node a esquerda do menor node é nulo
        if (menor.getLeft() == null) {
            aRemover.setValue(menor.getValue());
            aRemover.setKey(menor.getKey());
            if (hasRight(menor))
                menor.getRight().setParent(menor.getParent());
            return menor.getRight();
        } else {
            menor.setLeft(menorDir(aRemover, menor.getLeft()));
        }
        return menor;
    }

    // FIMREMOVER

    // CAMINHAMENTO
    // preOrder (R-e-d)
    public void preOrder() {
        if (!isEmpty())
            preOrder(this.root);
    }

    protected void preOrder(Node<E> node) {
        System.out.println(node);
        if (hasLeft(node))
            preOrder(node.getLeft());
        if (hasRight(node))
            preOrder(node.getRight());
    }

    // posOrder (e-d-R)
    public void posOrder() {
        if (!isEmpty())
            posOrder(this.root);
    }

    protected void posOrder(Node<E> node) {
        if (hasLeft(node))
            posOrder(node.getLeft());
        if (hasRight(node))
            posOrder(node.getRight());
        System.out.println(node);
    }

    // inOrder (e-R-d)
    public void inOrder() {
        if (!isEmpty())
            inOrder(this.root);
    }

    protected void inOrder(Node<E> node) {
        if (hasLeft(node))
            inOrder(node.getLeft());
        System.out.println(node);
        if (hasRight(node))
            inOrder(node.getRight());
    }
}
