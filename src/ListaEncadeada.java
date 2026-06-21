public class ListaEncadeada<T> implements Lista<T> {

    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    @Override
    public void add(T valor) {

        No<T> novo = new No<>(valor);
        // quando a lista eh criada n existe nenhum nó
        if (inicio == null) {
            inicio = novo;
        } else {

            // variavel p anda na lista
            No<T> atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }
        tamanho++;
    }

    @Override
    public void add(T valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            throw new IndexOutOfBoundsException("posição inválida");
        }

        No<T> novo = new No<>(valor);

        if (pos == 0) {
            novo.proximo = inicio;
            inicio = novo;
        } else {

            No<T> anterior = inicio;

            for (int i = 0; i < pos - 1; i++) {
                anterior = anterior.proximo;
            }

            // salvando o nó anterior antes de salvar para o proximo
            novo.proximo = anterior.proximo;
            anterior.proximo = novo;
        }

        tamanho++;
    }

    @Override
    public T get(int pos) {

        validaPosicao(pos);

        No<T> atual = inicio;

        for (int i = 0; i < pos; i++) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    @Override
    public T remove(int pos) {

        validaPosicao(pos);

        T valorRemovido;
        // o primeiro no aponta pro inicio com pos == 0
        if (pos == 0) {
            valorRemovido = inicio.valor;
            inicio = inicio.proximo;
        } else {
            No<T> anterior = inicio;

            for (int i = 0; i < pos - 1; i++) {
                anterior = anterior.proximo;
            }

            valorRemovido = anterior.proximo.valor;
            anterior.proximo = anterior.proximo.proximo;
        }
        tamanho--;
        return valorRemovido;
    }

    @Override
    public boolean remove(T valor) {

        No<T> atual = inicio;
        int pos = 0;
        // definindo a posicao (as veze e bom lembra)
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                remove(pos);
                return true;
            }

            atual = atual.proximo;
            pos++;
        }
        return false;

    }

    @Override
    public int size() {
        return tamanho;
    }

    private void validaPosicao(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    }

    //esse aqui é para imprimir no main sem varios for :) obg objects
    @Override
    public String toString() {

        String resultado = "[";

        No<T> atual = inicio;

        while (atual != null) {

            resultado += atual.valor;

            if (atual.proximo != null) {
                resultado += ", ";
            }

            atual = atual.proximo;
        }

        resultado += "]";

        return resultado;
    }
}
