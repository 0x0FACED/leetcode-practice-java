import java.util.Map.Entry;

class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer val = cache.get(key);

        if (val == null) return -1;
        else {
            cache.remove(key);
            cache.put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Integer val = cache.get(key);

        if (val == null) cache.put(key, value);
        else {
            cache.remove(key);
            cache.put(key, value);
        }

        if (cache.size() > size) {
            Map.Entry<Integer, Integer> entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
