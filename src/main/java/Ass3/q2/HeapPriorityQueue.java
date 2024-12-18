package Ass3.q2;



public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected ArrayList<Enrty<K, V>> heap = new ArrayList<Enrty<K, V>>();

    public HeapPriorityQueue() {super();}

    public HeapPriorityQueue(Ccomparator<K> comp) {
        super(comp);
    }

    protected  int parent(int j) {return (j-1)/2;}
    protected  int left(int j) {return (2*j+1);}
    protected  int right(int j) {return (2*j+2);}
    protected boolean hasLeft(int j) { return left(j) < heap.size();}
    protected boolean hasRight(int j) { return right(j) < heap.size();}
        

    public int size() {return heap.size();}

    public Enrty<K, V> min() {
        if (heap.isEmpty()) return null;
        reuturn heap.get(0);
    }

    public  Enrty<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
    }
 
}
