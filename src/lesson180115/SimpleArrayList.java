package lesson180115;

public class SimpleArrayList<E> implements SimpleList<E> {
    Object[] array;
    int size = 0;

    public SimpleArrayList(){
        array = new Object[5];
    }

    @Override
    public void add(E el){
        if (size==array.length){
            Object[] newArray = new Object[(int)(size*1.5)];
            System.arraycopy(array,0,newArray,0, size);
            array = newArray;
        }
        array[size++] = el;
    }

    @Override
    public E get(int index) {
        // todo array bound checking
        return (E) array[index];
    }

    @Override
    public void remove(int index){
        // todo array bounds checking
        for (int i = index+1; i < array.length; i++) {
            array[i-1]=array[i];
        }
        array[--size] = null; // устраняется утечка памяти
    }

    @Override
    public int size(){
        return size;
    }
}
