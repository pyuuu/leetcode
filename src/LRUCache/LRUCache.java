package LRUCache;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xijueyp on 14-11-3.
 */
// todo 还未完成
public class LRUCache {
    /*
    使用类库除非是接口的定义完全符合业务需求，否则慢的一比
     */

// 使用类库基本会使效率极低
//    class Entity {
//        int key;
//        int value;
//
//        Entity(int key, int value){
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public String toString(){
//            return "key:" + key + "/" + "value:" + value;
//        }
//    }
//
//    private int capacity;
//    List<Entity> list = new LinkedList<Entity>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        for (Entity entity:list){
//            if (entity.key == key){
//                return entity.value;
//            }
//        }
//        return -1;
//    }
//
//    public int getIndex(int key){
//        int i = 0;
//        for (Entity entity:list){
//            if (entity.key == key){
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }
//
//    public void set(int key, int value) {
//        int index = getIndex(key);
//        if (index != -1){
//            list.set(index, new Entity(key, value));
//            return;
//        }
//        // 进行增加节点
//        if (list.size() < capacity){
//            // add
//            list.add(new Entity(key, value));
//            return;
//        }
//
//        list.remove(0);
//        list.add(new Entity(key, value));
//    }
//
//    public void print(){
//        for (Entity entity:list){
//            System.out.println(entity.toString());
//        }
//    }
//
//    public static void main(String a[]){
//        LRUCache lruCache = new LRUCache(5);
//        for (int i = 0;i!=10;i++)
//            lruCache.set(i, i);
//        lruCache.set(3,3);
//        lruCache.set(9,91);
//        lruCache.print();
//
//    }

/*
    自建一个数据结构
 */



}