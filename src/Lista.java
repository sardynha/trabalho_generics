public interface Lista<T> {
    
    void add(T valor);
    void add(T valor, int pos);
    T get(int pos);
    T remove(int pos);
    boolean remove(T valor);
    int size();
}
