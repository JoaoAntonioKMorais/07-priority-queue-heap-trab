package estatica;

public class FilaComPrioridade<T> extends FilaEstatica<T> {

    public FilaComPrioridade(int capacidade) {
        super(capacidade);
    }

    @Override
    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("A fila está cheia.");
        }

        Comparable<T> elementoOrdenavel = (Comparable<T>) elemento;

        int posicao;
        for (posicao = 0; posicao < tamanho(); posicao++) {
            if (elementoOrdenavel.compareTo(elementos[posicao]) < 0) {
                break;
            }
        }

        adicionaPosicao(posicao, elemento);
    }

    public void adicionaPosicao(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = tamanho - 1; i >= posicao; i--) {
            elementos[i+1] = elementos[i];
        }

        elementos[posicao] = elemento;
        tamanho++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
