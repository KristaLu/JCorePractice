package lesson180115;

// в java связный список двусвязный, но здесь рассматривается односвязный
public class SimpleLinkedList<E> implements SimpleList<E> {

    Entry<E> first;
    Entry<E> last;
    int size = 0;

    @Override
    public void add(E value) {
        // вставка в конец
        Entry<E> newEntry = new Entry<>(value);

        if(first==null){
            first = last = newEntry;
        } else {
            last.next = newEntry;
            last = newEntry;
        }
        size++;
    }

    public void addMiddle(E value, int index){
        // todo addMiddle
        checkBounds(index);

        Entry<E> newEntry = new Entry<>(value);
    }

    @Override
    public E get(int index) {
        checkBounds(index);

        Entry<E> cur = getEntry(index);
        return cur.value;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);

        if (index==0){
            first = first.next;
            if (size==1){
                last = first;
            }
        } else {
          Entry<E> cur = getEntry(index-1);
          cur.next = cur.next.next;
          if (cur.next==null){
              last=cur;
          }
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private Entry<E> getEntry(int index) {
        Entry<E> cur = first;
        for (int i = 0; i < index && cur != null; i++) {
            cur=cur.next;
        }
        return cur;
    }

    private void checkBounds(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IllegalArgumentException("Index must be >=0 and <" + (size() - 1));
        }
    }

    // Entry - звено связного списка
    static class Entry<E>{
        final E value;
        Entry<E> next;

        Entry(E value) {
            this.value = value;
            this.next = null;
        }
    }
}
