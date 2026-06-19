public class No<T> {

    T valor;
    No<T> proximo;
    //guarda uma referencia para o proximo

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
