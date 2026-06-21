public class ListaVetor<T> implements Lista<T> {

    private T[] itens;
    private int tamanho;
    //vetor que guarda os elementos e o que define quantos existem

    @SuppressWarnings("unchecked")
    public ListaVetor() {
        itens = (T[]) new Object[10];
        tamanho = 0;
    }

    @Override
    public void add(T valor) {

        verificaCheio();
        //adiciona e atualiza
        itens[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void add(T valor, int pos) {

        //essa permite add no meio

        if (pos < 0 || pos > tamanho) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }
        verificaCheio();

        for (int i = tamanho; i > pos; i--) {
            //vai andando pra trás
            itens[i] = itens[i - 1];
        }

        itens[pos] = valor;
        tamanho++;
    }

    @Override
    public T get(int pos) {

        verificaPosicao(pos);

        return itens[pos];
    }

    @Override
    public T remove(int pos) {

        verificaPosicao(pos);

        T removido = itens[pos];
        //percorre até encontrar e remove
        for (int i = pos; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }

        itens[tamanho - 1] = null;
        tamanho--;

        return removido;
    }

    @Override
    public boolean remove(T valor) {

        for (int i = 0; i < tamanho; i++) {

            if (itens[i].equals(valor)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return tamanho;
    }

    //metodos para nao repetir if
    private void verificaCheio() {
    if (tamanho == itens.length) {
         aumentarCapacidade();
    }
}

private void verificaPosicao(int pos) {

    if (pos < 0 || pos >= tamanho) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }
}

@SuppressWarnings("unchecked")
private void aumentarCapacidade() {

    T[] novoVetor = (T[]) new Object[itens.length * 2];
    //se o vetor tinha 10, agora tem 20 posicoes, dobra a capacidade

    for (int i = 0; i < tamanho; i++) {
        //for pra percorrer toda a galera valida
        novoVetor[i] = itens[i];
        //copia um por um
    }
    //aponta pro maior
    itens = novoVetor;
}

//esse aqui é para imprimir no main sem varios for :)
@Override
public String toString() {

    String resultado = "[";

    for (int i = 0; i < tamanho; i++) {

        resultado += itens[i];

        if (i < tamanho - 1) {
            resultado += ", ";
        }
    }

    resultado += "]";

    return resultado;
}
}
