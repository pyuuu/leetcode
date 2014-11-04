package LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xijueyp on 14-11-3.
 */
// todo 还未完成
public class LRUCache {

    private int capacity;
    Map<Integer, Integer> data = new HashMap<Integer, Integer>();
    Queue<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        queue = new LinkedBlockingQueue<Integer>(capacity);
    }

    public int get(int key) {
        Integer integer = data.get(key);
        if (integer == null)
            return -1;
        return integer;
    }

    public void set(int key, int value) {

    }
}