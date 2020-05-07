package com.allen.concurrent.copyonwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lingfeng
 * @Date: 2020/4/22 21:45
 */

public abstract class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {

    final transient ReentrantLock lock = new ReentrantLock();
    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap(Map<K, V> internalMap) {
        this.internalMap = new HashMap<>();
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            newMap.putAll(m);
            internalMap = newMap;
        } finally {
            lock.unlock();
        }
    }
}
