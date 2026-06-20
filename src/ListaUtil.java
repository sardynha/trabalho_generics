public class ListaUtil {
    
    public static int count(Lista<?> lista) {
        //wildcard, o "?" = aceita uma lista de qualquer tipo
        return lista.size();
    }

    public static <T extends Comparable<T>> T max(Lista<T> lista) {

    T maior = lista.get(0);

    for (int i = 1; i < lista.size(); i++) {

        if (lista.get(i).compareTo(maior) > 0) {
            maior = lista.get(i);
        }
    }

    return maior;
}

public static <T extends Comparable<T>> T min(Lista<T> lista) {

    T menor = lista.get(0);

    for (int i = 1; i < lista.size(); i++) {

        if (lista.get(i).compareTo(menor) < 0) {
            menor = lista.get(i);
        }
    }

    return menor;
}
}
