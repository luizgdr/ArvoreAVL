//import java.util.Random;

class Node {
    private int valor;
    private Node esquerda, direita;
    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public Node pop(int n, Node pai) {
        Node ret = null;
        if (this.valor == n) {
            if (this.folha()) {
                // remover referência no nó pai
                if (pai.getEsquerda() == this) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
            } else {
                // checar se existe apenas um filho, caso verdade o pai de ret
                // agora referencia o nó filho de ret
                if (this.getDireita() == null && this.getEsquerda() != null) {
                    if (pai.getEsquerda() == this) {
                        pai.setEsquerda(this.getEsquerda());
                    } else {
                        pai.setDireita(this.getEsquerda());
                    }
                } else if
                   (this.getDireita() != null && this.getEsquerda() == null) {
                    if (pai.getEsquerda() == this) {
                        pai.setEsquerda(this.getDireita());
                    } else {
                        pai.setDireita(this.getDireita());
                    }
                }
                // se ret tiver mais de um filho, procurar pelo maior elemento
                // da subárvore esquerda e substituir no lugar de ret
                else {
                    Node anterior = this, maior = this.getEsquerda();
                    while (maior.getDireita() != null) {
                        anterior = maior;
                        maior = maior.getDireita();
                    }
                    // tirar referências do nó filho antes de substituir pelo
                    // ret
                    if (anterior.getEsquerda() == this) {
                        anterior.setEsquerda(null);
                    } else {
                        anterior.setDireita(null);
                    }
                    if (pai.getEsquerda() != this) {
                        pai.setEsquerda(maior);
                    } else {
                        pai.setDireita(maior);
                    }
                    maior.setEsquerda(this.esquerda);
                    maior.setDireita(this.direita);
                }
            }
            return this;
        }

        if (this.esquerda != null) {
            ret = esquerda.pop(n, this);
        }

        /* Considerar que existe apenas um elemento com valor n */
        if (this.direita != null && ret == null) {
            ret = direita.pop(n, this);
        }
        return ret;
    }

    public void imprimir() {
        System.out.println("Valor: " + this.valor + " " + this);
        if (this.esquerda != null) {
            System.out.println("Esquerda: " + this.esquerda.getValor());
        } else {
            System.out.println("Esquerda: " + this.esquerda);
        }
        if (this.direita != null) {
            System.out.println("Direita: " + this.direita.getValor() + "\n");
        } else {
            System.out.println("Direita: " + this.direita + "\n");
        }
    }

    public void imprimir_preordem() {
        this.imprimir();

        if (this.esquerda != null) {
            this.esquerda.imprimir_preordem();
        }

        if (this.direita != null) {
            this.direita.imprimir_preordem();
        }
    }

    public void setEsquerda(Node n) {
        esquerda = n;
    }

    public void setDireita(Node n) {
        direita = n;
    }

    public void setValor(int i) {
        valor = i;
    }

    public int getValor() {
        return valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public boolean folha() {
        return (esquerda == null) && (direita == null);
    }
}

public class ArvoreAVL {
    // Inserir um elemento em uma árvore binária de busca
    // Percorrer a árvore binária nas formas préordem, inordem e pósordem
    // Remover o maior elemento de uma árvore binária de busca
    // Remover o menor elemento de uma árvore binária de busca
    // Remover o elemento de valor N de uma árvore binária de busca
    private Node arvore;
    public ArvoreAVL() {
        arvore = null;
    }

    public int altura(Node no) {
        if (no == null) {
            return -1;
        }
        int esquerda = altura(no.getEsquerda());
        int direita = altura(no.getDireita());
        if (esquerda > direita)
            return 1 + esquerda;
        return 1 + direita;
    }

    public int balanceamento(Node no) {
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    public Node buscar(int valor) {
        Node atual = this.arvore;
        while (atual != null && atual.getValor() != valor) {
            if (atual.getValor() > valor)
                atual = atual.getEsquerda();
            else
                atual = atual.getDireita();
        }
        if (atual != null && atual.getValor() == valor) {
            return atual;
        }
        return null;
    }

    public void balancear() {
        // balanceamento
        int balanceamento = balanceamento(arvore);
        System.out.println(balanceamento);
        if (balanceamento < -1) {
            System.out.println("Pré balanceamento");
            arvore.imprimir_preordem();
            // rotação a esquerda
            //Node novaRaiz = arvore.getDireita();
            //Node temp = novaRaiz.getEsquerda();
            //novaRaiz.setEsquerda(arvore);
            //arvore.setDireita(temp);
            //arvore = novaRaiz;
            //System.out.println("Pós balanceamento");
            //arvore.imprimir_preordem();
                    // 1 vez so
                    if (arvore.getEsquerda() == null) {
                        // rotação a esquerda
                        Node novaRaiz = arvore.getDireita();
                        Node temp = novaRaiz.getEsquerda();
                        novaRaiz.setEsquerda(arvore);
                        arvore.setDireita(temp);
                        arvore = novaRaiz;
                        System.out.println("Rotacao 1 esquerda raiz:");
                        arvore.imprimir_preordem();
                    }
                    // 2 vezes
                    else {
                        // rotação a esquerda
                        //
                        Node novaRaiz = arvore.getDireita().getEsquerda();
                        Node filhoD = arvore.getDireita();
                        Node temp = novaRaiz.getEsquerda();
                        novaRaiz.setDireita(filhoD);
                        novaRaiz.setEsquerda(arvore);
                        arvore.setDireita(temp);
                        filhoD.setEsquerda(null);
                        arvore = novaRaiz;
                        arvore.imprimir_preordem();
                    }
        } else if (balanceamento > 1) {
            System.out.println("Pré balanceamento");
            arvore.imprimir_preordem();
            // rotação a direita
            //Node novaRaiz = arvore.getEsquerda();
            //Node temp = novaRaiz.getDireita();
            //novaRaiz.setDireita(arvore);
            //arvore.setEsquerda(temp);
            //arvore = novaRaiz;
            //System.out.println("Pós balanceamento");
            //arvore.imprimir_preordem();
                    if (arvore.getDireita() == null) {
                        // rotação a direita
                        Node novaRaiz = arvore.getEsquerda();
                        Node temp = novaRaiz.getDireita();
                        novaRaiz.setDireita(arvore);
                        arvore.setEsquerda(temp);
                        arvore = novaRaiz;
                        System.out.println("Rotacao 1 direita raiz:");
                        arvore.imprimir_preordem();
                    }
                    // 2 vezes
                    else {
                        // rotação a direita
                        // Caso especial direita 2 vezes: 80 Atual: 56 Anterior: 100 Anterior do anterior: 100
                        //
                        Node novaRaiz = arvore.getEsquerda().getDireita();
                        Node filhoE = arvore.getEsquerda();
                        Node temp = novaRaiz.getDireita();
                        novaRaiz.setEsquerda(filhoE);
                        novaRaiz.setDireita(arvore);
                        arvore.setEsquerda(temp);
                        filhoE.setDireita(null);
                        arvore = novaRaiz;
                        arvore.imprimir_preordem();
                    }
        }
    }

    public void inserir(int valor) {
        if (arvore == null) {
            arvore = new Node(valor);
            return;
        }

        Node atual = arvore, anterior = arvore, anterior2 = arvore;
        while (atual != null) {
            // ir para direita
            if (atual.getValor() <= valor) {
                if (atual.getDireita() != null) {
                    anterior2 = anterior;
                    anterior = atual;
                    atual = atual.getDireita();
                } else {
                    atual.setDireita(new Node(valor));
                    System.out.println("Inserindo: " + valor + "\natual:");
                    atual.imprimir();
                    System.out.println("Eu nao aguento mais isso\n" +
                                " Atual: " + atual.getValor() +
                                " Anterior: " + anterior.getValor() +
                                "Anterior do anterior: " + anterior2.getValor());
                    // 1 vez so
                    if (anterior != atual && anterior.getEsquerda() == null) {
                        // rotação a esquerda
                        Node novaRaiz = anterior.getDireita();
                        Node temp = novaRaiz.getEsquerda();
                        novaRaiz.setEsquerda(anterior);
                        anterior.setDireita(temp);
                        anterior2.setEsquerda(novaRaiz);
                        System.out.println("Caso especial esquerda: " + valor +
                                " Atual: " + atual.getValor() +
                                " Anterior: " + anterior.getValor() +
                                "Anterior do anterior: " + anterior2.getValor());
                        arvore.imprimir_preordem();
                    }
                    // 2 vezes
                    else if (anterior != atual && anterior.getDireita() == null) {
                        // rotação a direita
                        // Caso especial direita 2 vezes: 80 Atual: 56 Anterior: 100 Anterior do anterior: 100
                        //
                        Node novaRaiz = anterior.getEsquerda();
                        Node temp = novaRaiz.getDireita();
                        novaRaiz.setDireita(anterior);
                        anterior.setEsquerda(temp);
                        if (anterior2 != anterior)
                            anterior2.setEsquerda(novaRaiz);

                        novaRaiz = anterior.getEsquerda();
                        temp = novaRaiz.getDireita();
                        novaRaiz.setDireita(anterior);
                        anterior.setEsquerda(temp);
                        novaRaiz.setEsquerda(atual);
                        // XXX
                        atual.setDireita(temp);
                        if (anterior2 != anterior)
                            anterior2.setEsquerda(novaRaiz);
                        else
                            arvore = novaRaiz;
                        System.out.println("Caso especial direita 2 vezes: " + valor +
                                " Atual: " + atual.getValor() +
                                " Anterior: " + anterior.getValor() +
                                "Anterior do anterior: " + anterior2.getValor());
                        arvore.imprimir_preordem();
                    }
                    break;
                }
            }
            // ir para esquerda
            else {
                if (atual.getEsquerda() != null) {
                    anterior2 = anterior; // arvore (100)
                    anterior = atual;     // arvore (100)
                    atual = atual.getEsquerda(); // 56
                } else {
                    atual.setEsquerda(new Node(valor));
                    System.out.println("Inserindo: " + valor + "atual:");
                    atual.imprimir();
                    // 1 vez so
                    if (anterior != atual && anterior.getDireita() == null) {
                        // rotação a direita
                        Node novaRaiz = anterior.getEsquerda();
                        Node temp = novaRaiz.getDireita();
                        novaRaiz.setDireita(anterior);
                        anterior.setEsquerda(temp);
                        anterior2.setDireita(novaRaiz);
                        System.out.println("Caso especial direita: " + valor + " Atual: " + atual.getValor() + " Anterior: " + anterior.getValor() + "Anterior do anterior: " + anterior2.getValor());
                        arvore.imprimir_preordem();
                    }
                    // 2 vezes
                    else if (anterior != atual && anterior.getEsquerda() == null) {
                        // rotação a esquerda
                        Node novaRaiz = anterior.getDireita();
                        Node temp = novaRaiz.getEsquerda();
                        novaRaiz.setEsquerda(anterior);
                        anterior.setDireita(temp);
                        if (anterior2 != anterior)
                            anterior2.setDireita(novaRaiz);

                        novaRaiz = anterior.getDireita();
                        temp = novaRaiz.getEsquerda();
                        novaRaiz.setEsquerda(anterior);
                        anterior.setDireita(temp);
                        novaRaiz.setDireita(atual);
                        // XXX
                        atual.setEsquerda(temp);
                        if (anterior2 != anterior)
                            anterior2.setDireita(novaRaiz);
                        else
                            arvore = novaRaiz;
                        System.out.println("Caso especial esquerda 2 vezes: " + valor +
                                " Atual: " + atual.getValor() +
                                " Anterior: " + anterior.getValor() +
                                "Anterior do anterior: " + anterior2.getValor());
                        arvore.imprimir_preordem();
                    }
                    break;
                }
            }
        }
        System.out.print("inserir " + valor + ": ");
        balancear();
    }

    public void imprimir() {
        arvore.imprimir();
    }

    public void imprimir_preordem() {
        arvore.imprimir_preordem();
    }

    public void remover_maior() {
        Node anterior, atual = arvore;
        while (true) {
            anterior = atual;
            atual = atual.getDireita();
            if (atual.getDireita() == null) {
                break;
            }
        }
        atual = null;
        anterior.setDireita(null);
        balancear();
    }

    public void remover_menor() {
        Node anterior, atual = arvore;
        while (true) {
            anterior = atual;
            atual = atual.getEsquerda();
            if (atual.getEsquerda() == null) {
                break;
            }
        }
        atual = null;
        anterior.setEsquerda(null);
        balancear();
    }

    public void remover(int n) {
        Node ret = arvore.pop(n, arvore);
        if (ret == null) return;
        System.out.println("Removendo " + ret + "\n");
        System.out.print("remover " + n + ": ");
        balancear();
    }

/*                  14
 *                /    \
 *               04      15
 *              /  \    /  \
 *             03  09  14  18
 *                /  \    /  \
 *               07  09  16  20
 *              /          \
 *             05           17
 *            /  \
 *           04  05
 *             \
 *              04
 * */
    public static void main(String args[]) {
        ArvoreAVL arvore = new ArvoreAVL();
        arvore.inserir(100);
        arvore.inserir(56);
        //arvore.inserir(32);
        arvore.inserir(80);
        arvore.inserir(127);
        arvore.inserir(115);
        //arvore.remover(32);
        arvore.inserir(85);

        //arvore.inserir(130);
        //arvore.inserir(82);

        //arvore.inserir(90);
        //arvore.inserir(120);
        //arvore.remover(80);
        //arvore.inserir(95);
        //arvore.remover(127);
        //arvore.inserir(40);
        //arvore.inserir(68);
        //arvore.remover(56);
        //arvore.remover(40);
        //arvore.remover(82);
        System.out.println("Arvore:");
        arvore.imprimir_preordem();
        System.out.println("Balanceamento da árvore: " +
                arvore.balanceamento(arvore.arvore));
    }
}
