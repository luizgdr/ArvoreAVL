import java.util.Random;

public class ArvoreAVL {
    private Node raiz;
    public ArvoreAVL() {
        raiz = null;
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
        Node atual = this.raiz;
        while (atual != null && atual.getValor() != valor) {
            if (atual.getValor() > valor)
                atual = atual.getEsquerda();
            else
                atual = atual.getDireita();
        }
        return atual;
        /*
        if (atual != null && atual.getValor() == valor) {
            return atual;
        }
        return null; */
    }

    public void balancear(Node no, Node anterior) {
        int balanceamento = balanceamento(no);
        //System.out.println(balanceamento);
        if (balanceamento < -1) {
            /*
            System.out.println("Pré balanceamento");
            raiz.imprimir_preordem();
            */
            // funciona.
            // 1 vez so
            if (balanceamento(no.getDireita()) <= 0) {
                // rotação a esquerda
                Node novaRaiz = no.getDireita();
                Node temp = novaRaiz.getEsquerda();
                novaRaiz.setEsquerda(no);
                no.setDireita(temp);
                if (no == raiz)
                    raiz = novaRaiz;
                else
                    if (anterior.getEsquerda() == no)
                        anterior.setEsquerda(novaRaiz);
                    else if (anterior.getDireita() == no)
                        anterior.setDireita(novaRaiz);
                /*
                System.out.println("Rotacao 1 esquerda raiz:");
                raiz.imprimir_preordem();
                */
            }
            // 2 vezes
            else {
                // rotação a esquerda
                Node novaRaiz = no.getDireita().getEsquerda();
                Node filhoD = no.getDireita();
                Node temp = novaRaiz.getEsquerda();
                novaRaiz.setDireita(filhoD);
                novaRaiz.setEsquerda(no);
                no.setDireita(temp);
                filhoD.setEsquerda(null);
                if (no == raiz)
                    raiz = novaRaiz;
                else
                    if (anterior.getEsquerda() == no)
                        anterior.setEsquerda(novaRaiz);
                    else if (anterior.getDireita() == no)
                        anterior.setDireita(novaRaiz);
                /*
                System.out.println("Rotacao 2 esquerda raiz:" + no);
                raiz.imprimir_preordem();
                */
            }
        } else if (balanceamento > 1) {
            /*
            System.out.println("Pré balanceamento");
            raiz.imprimir_preordem();
            */
            // 1 vez so
            if (balanceamento(no.getEsquerda()) >= 0) {
                // rotação a direita
                Node novaRaiz = no.getEsquerda();
                Node temp = novaRaiz.getDireita();
                novaRaiz.setDireita(no);
                no.setEsquerda(temp);
                if (no == raiz)
                    raiz = novaRaiz;
                else
                    if (anterior.getEsquerda() == no)
                        anterior.setEsquerda(novaRaiz);
                    else if (anterior.getDireita() == no)
                        anterior.setDireita(novaRaiz);
                /*
                System.out.println("Rotacao 1 direita raiz:");
                raiz.imprimir_preordem();
                */
            }
            // 2 vezes
            else {
                // rotação a direita
                Node novaRaiz = no.getEsquerda().getDireita();
                Node filhoE = no.getEsquerda();
                Node temp = novaRaiz.getDireita();
                novaRaiz.setEsquerda(filhoE);
                novaRaiz.setDireita(no);
                no.setEsquerda(temp);
                filhoE.setDireita(null);
                if (no == raiz)
                    raiz = novaRaiz;
                else
                    if (anterior.getEsquerda() == no)
                        anterior.setEsquerda(novaRaiz);
                    else if (anterior.getDireita() == no)
                        anterior.setDireita(novaRaiz);
                /*
                System.out.println("Rotacao 2 direita raiz:");
                raiz.imprimir_preordem();
                */
            }
        }
    }

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return;
        }

        Node atual = raiz, anterior = raiz, anterior2 = raiz;
        while (atual != null) {
            // ir para direita
            if (atual.getValor() <= valor) {
                if (atual.getDireita() != null) {
                    anterior2 = anterior;
                    anterior = atual;
                    atual = atual.getDireita();
                } else {
                    // inserir elemento na direita do nodo
                    atual.setDireita(new Node(valor));
                    //System.out.println("Inserindo: " + valor);
                    balancear(anterior, anterior2);
                    break;
                }
            }
            // ir para esquerda
            else {
                if (atual.getEsquerda() != null) {
                    anterior2 = anterior;
                    anterior = atual;
                    atual = atual.getEsquerda();
                } else {
                    // inserir elemento na esquerda do nodo
                    atual.setEsquerda(new Node(valor));
                    //System.out.println("Inserindo: " + valor);
                    balancear(anterior, anterior2);
                    break;
                }
            }
        }
        balancear(raiz, raiz);
    }

    public void imprimir() {
        raiz.imprimir();
    }

    public void imprimir_preordem() {
        raiz.imprimir_preordem();
    }

    /* Considerar que existe apenas um elemento com valor n */
    public void remover(int n) {
        //System.out.println("remover " + n);
        Node ret = pop(n, raiz, null, null);
        if (ret == null) return;
        //System.out.println("Removendo " + ret + "\n");
        balancear(raiz, raiz);
    }

    public Node pop(int n, Node atual, Node pai, Node pai2) {
        Node ret = null;
        if (atual.getValor() == n) {
            if (atual.folha()) {
                // remover referência no nó pai
                if (pai.getEsquerda() == atual) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
            } else {
                // checar se existe apenas um filho, caso verdade o pai de ret
                // agora referencia o nó filho de ret
                if (atual.getDireita() == null && atual.getEsquerda() != null) {
                    if (pai.getEsquerda() == atual) {
                        pai.setEsquerda(atual.getEsquerda());
                    } else {
                        pai.setDireita(atual.getEsquerda());
                    }
                } else if
                    (atual.getDireita() != null && atual.getEsquerda() == null) {
                        if (pai.getEsquerda() == atual) {
                            pai.setEsquerda(atual.getDireita());
                        } else {
                            pai.setDireita(atual.getDireita());
                        }
                    }
                // se ret tiver mais de um filho, procurar pelo maior elemento
                // da subárvore esquerda e substituir no lugar de ret
                else {
                    Node anterior = atual, maior = atual.getEsquerda();
                    while (maior.getDireita() != null) {
                        anterior = maior;
                        maior = maior.getDireita();
                    }
                    // tirar referências do nó filho antes de substituir pelo
                    // ret
                    if (anterior.getEsquerda() == maior) {
                        anterior.setEsquerda(null);
                    } else {
                        anterior.setDireita(null);
                    }
                    if (pai.getEsquerda() == atual) {
                        pai.setEsquerda(maior);
                    } else {
                        pai.setDireita(maior);
                    }
                    maior.setEsquerda(atual.getEsquerda());
                    maior.setDireita(atual.getDireita());
                    // settar pai e pai2 para balanceamento
                    pai2 = pai;
                    pai = maior;
                }
            }
            if (pai != null && pai2 != null)
                balancear(pai, pai2);
            else if (pai != null && pai2 == null)
                balancear(pai, pai);
            return atual; // return da recursão
        }

        if (atual.getEsquerda() != null) {
            ret = pop(n, atual.getEsquerda(), atual, pai);
        }

        if (atual.getDireita() != null && ret == null) {
            ret = pop(n, atual.getDireita(), atual, pai);
        }
        return ret; // return para função que chamou essa
    }


    public static void main(String args[]) {
        Random rand = new Random();
        ArvoreAVL arvore = new ArvoreAVL();
        /* Quantidade de números aleatórios a serem gerados,
         * passado como argumento */
        int num;
        if (args.length == 1)
            num = Integer.parseInt(args[0]);
        else
            return;
        for (int i = 0; i < num; i++) {
            arvore.inserir(rand.nextInt(50000));
        }
        /*
        arvore.inserir(100);
        arvore.inserir(56);
        arvore.inserir(32);
        arvore.inserir(80);
        arvore.inserir(127);
        arvore.inserir(115);
        arvore.remover(32);
        arvore.inserir(85);
        arvore.inserir(130);
        arvore.inserir(82);
        arvore.inserir(90);
        arvore.inserir(120);
        arvore.remover(80);
        arvore.inserir(95);
        arvore.remover(127);
        arvore.inserir(40);
        arvore.inserir(68);
        arvore.remover(56);
        arvore.remover(40);
        arvore.remover(82);
        */
        /*
        System.out.println("Arvore:");
        arvore.imprimir_preordem();
        */
        System.out.println("Balanceamento da árvore: " +
                arvore.balanceamento(arvore.raiz));
    }
}
