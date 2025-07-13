class MyHashSet {
    private static final int SIZE = 10000;
    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new List[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private List<Integer> getBucket(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        return buckets[index];
    }

    public void add(int key) {
        List<Integer> bucket = getBucket(key);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        List<Integer> bucket = getBucket(key);
        bucket.remove((Integer) key);  
    }

    public boolean contains(int key) {
        List<Integer> bucket = getBucket(key);
        return bucket.contains(key);
    }
}
