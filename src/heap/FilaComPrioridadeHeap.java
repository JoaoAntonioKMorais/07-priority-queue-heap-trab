package heap;

/**
 * Fila de prioridade implementada com Heap Binário de máximo.
 *
 * O maior elemento, de acordo com o compareTo, fica na raiz do heap.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class FilaComPrioridadeHeap<T extends Comparable<T>> {
    private T[] elementos;
    private int tamanho;

    /**
     * Cria uma fila com a capacidade informada.
     *
     * @param capacidade quantidade máxima de elementos
     */
    @SuppressWarnings("unchecked")
    public FilaComPrioridadeHeap(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        this.elementos = (T[]) new Comparable[capacidade];
    }

    /**
     * Insere um elemento usando o algoritmo Sobe Heap.
     *
     * @param elemento elemento a ser inserido
     */
    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("A fila está cheia.");
        }

        elementos[tamanho] = elemento;
        sobeHeap(tamanho);
        tamanho++;
    }

    /**
     * Remove e retorna o elemento de maior prioridade usando Desce Heap.
     *
     * @return elemento de maior prioridade
     */
    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia.");
        }

        T elementoRemovido = elementos[0];
        tamanho--;
        elementos[0] = elementos[tamanho];
        elementos[tamanho] = null;

        if (!estaVazia()) {
            desceHeap(0);
        }

        return elementoRemovido;
    }

    /**
     * Retorna o elemento de maior prioridade sem removê-lo.
     */
    public T frente() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia.");
        }

        return elementos[0];
    }

    private void sobeHeap(int indice) {
        while (indice > 0) {
            int indicePai = (indice - 1) / 2;

            if (elementos[indice].compareTo(elementos[indicePai]) <= 0) {
                break;
            }

            trocar(indice, indicePai);
            indice = indicePai;
        }
    }

    private void desceHeap(int indice) {
        while (true) {
            int filhoEsquerdo = 2 * indice + 1;
            int filhoDireito = 2 * indice + 2;
            int maior = indice;

            if (filhoEsquerdo < tamanho && elementos[filhoEsquerdo].compareTo(elementos[maior]) > 0) {
                maior = filhoEsquerdo;
            }

            if (filhoDireito < tamanho && elementos[filhoDireito].compareTo(elementos[maior]) > 0) {
                maior = filhoDireito;
            }

            if (maior == indice) {
                break;
            }

            trocar(indice, maior);
            indice = maior;
        }
    }

    private void trocar(int i, int j) {
        T temporario = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temporario;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return elementos.length;
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
