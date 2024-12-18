package Ass.q2;
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        public PQEntry(K key, V value) {
            this.key = key;
            this.value =  value;
        }
        public getKey() {return key;}
        public getValue() {return value;}

        protected void setKey(K k) { this.key = k); }
        protected void setValue(V v) { this.value = v); }

    }

    private Comparator<K> comp;
    protected AbstractPriorityQueue(Comparator<K> c) {comp = c;}
    protected AbstractPriorityQueue() {this(new DefaultComparator())}

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }


    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {return heap.size()==0;}
}
