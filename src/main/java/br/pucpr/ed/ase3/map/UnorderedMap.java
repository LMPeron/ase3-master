package br.pucpr.ed.ase3.map;

import br.pucpr.ed.ase3.list.List;
import br.pucpr.ed.ase3.list.UnorderedArrayList;

public class UnorderedMap<K extends Comparable, V> implements Map<K, V> {

    private UnorderedArrayList<Entry<K, V>> entries;

    public UnorderedMap() {
        entries = new UnorderedArrayList<>(50);
    }

    public UnorderedMap(int capacity) {
        entries = new UnorderedArrayList<>(capacity);
    }


    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    private Entry<K, V> find(K key) {
        return entries.find(new Entry<>(key));
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = find(key);
        return entry != null ? entry.value : null;
    }

    /**
     * @todo Implementar o método put. Ele é utilizado no put do HashMap.
     */
    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = find(key);
        if (entry != null) {
            V changed = entry.value;
            entries.remove(entry);
            entries.add(entry);
            return changed;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = find(key);
        if (entry != null) {
            V removedValue = entry.value;
            entries.remove(entry);
            return removedValue;
        }
        return null;
    }

    @Override
    public List<K> keySet() {
        List<K> keys = new UnorderedArrayList<>(entries.size());
        for (int i = 0; i < entries.size(); i++) {
            Entry<K, V> entry = entries.get(i);
            keys.add(entry.key);
        }
        return keys;
    }

    @Override
    public List<V> values() { 
        List<V> values = new UnorderedArrayList<V>(entries.size());
        for (int i = 0; i < entries.size(); i++) {
            Entry<K, V> entry = entries.get(i);
            values.add(entry.value);
        }
        return values;
    }

    @Override
    public List<Entry<K, V>> entrySet() {
        return entries;
    }
}
