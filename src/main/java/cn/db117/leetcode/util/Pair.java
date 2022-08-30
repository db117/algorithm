package cn.db117.leetcode.util;

/**
 * javafx.util.Pair<K,V>
 *
 * @author db117
 * @since 2022/8/30 15:55
 **/
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
