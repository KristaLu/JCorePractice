package lesson180117;

// приоритетная очередь:
public class SimpleHashTable<K,V> {

    Entry<K,V>[] table;
    int size=0;

    public SimpleHashTable(){
        table=(Entry<K,V>[]) new Entry[16];
    }

    public void put(K key, V value){
        final int hash = key.hashCode();
        final int index = Math.abs(hash) % table.length;
        if (table[index] == null) {
            //base case
            table[index] = new Entry<K,V>(key, value);
        } else {
            // collision case
            Entry<K,V> cur = table[index];
            while (cur.next!=null){
                if (key.equals(cur.key)) {
                    cur.value = value;
                    size++;
                    return;
                }
                cur=cur.next;
            }
            cur.next = new Entry<K,V>(key,value);
        }
        size++;
    }

    public V get(K key){
        // todo get
        return null;
    }

    public V remove(K key){
        // todo remove
        return null;
    }

    static class Entry<K,V>{
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(K key,V value) {
            this.key=key;
            this.value = value;
            this.next = null;
        }
    }
}
