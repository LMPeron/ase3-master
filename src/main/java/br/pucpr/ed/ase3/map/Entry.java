package br.pucpr.ed.ase3.map;

import java.util.Objects;

public class Entry<K extends Comparable,V> implements Comparable{
    protected K key;
    protected V value;

    public Entry(K key) {
        this.key = key;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return Objects.equals(key, entry.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ')';
    }

    @Override
    public int compareTo(Object o) {
        Entry<K,V> otherEntry = (Entry<K, V>) o;
        return this.key.compareTo(otherEntry.key);
    }
}
