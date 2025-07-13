class MyHashMap {

    private static final int SIZE = 10000;
    private List<int[]>[] buckets;

    public MyHashMap() {
        buckets = new List[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private List<int[]> getBucket(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        return buckets[index];
    }

    public void put(int key, int value) {
        List<int[]> bucket = getBucket(key);
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value; 
                return;
            }
        }
        bucket.add(new int[]{key, value}); 
    }

    public int get(int key) {
        List<int[]> bucket = getBucket(key);
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1; // key not found
    }

    public void remove(int key) {
        List<int[]> bucket = getBucket(key);
        Iterator<int[]> it = bucket.iterator();
        while (it.hasNext()) {
            int[] pair = it.next();
            if (pair[0] == key) {
                it.remove();
                return;
            }
        }
    }
}
