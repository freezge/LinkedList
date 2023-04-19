public interface MyList<T>{
    int size();
    public void check_index(int index);
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove_elem(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
