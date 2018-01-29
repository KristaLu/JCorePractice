package lesson180115;

public interface SimpleList<E> {
    void add(E el);

    E get(int index);

    void remove(int index);

    int size();
}
