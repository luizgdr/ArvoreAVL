public class Node {
    private int valor;
    private Node esquerda, direita;
    public Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
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
