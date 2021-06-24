package br.pucpr.ed.ase3.map;

import br.pucpr.ed.ase3.list.List;
import br.pucpr.ed.ase3.list.UnorderedArrayList;

public class HashMap<K extends Comparable, V> implements Map<K, V> {

    private int size;
    private int capacity;

    private UnorderedMap<K, V>[] mapList;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.mapList = new UnorderedMap[capacity];
    }

    /**
     * Método que calcula o código hash para a chave fornecida como parâmetro.
     *
     * @param key Chave
     * @return Código hash da chave.
     */
    private int hashValue(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        int hashValue = hashValue(key);
        if (mapList[hashValue] == null) {
            return null;
        }
        return mapList[hashValue].get(key);
    }

    /**
     * O método put primeiro verifica se já existe um UnorderedMap instanciado na posição indicada
     * pelo hashValue. Se não existir, cria uma nova instância com tamanho 5 (definido
     * arbitrariamente).
     * <p>
     * Então ele delega a inclusão para o put do UnorderedMap.
     *
     * @param key   Chave
     * @param value Valor
     * @return null, se não substituir nenhuma chave, valor anterior, se substituir o valor de uma
     * chave.
     */
    @Override
    public V put(K key, V value) {
        int hashValue = hashValue(key);

        if (mapList[hashValue] == null) {
            mapList[hashValue] = new UnorderedMap<>(5);
        }
        V oldValue = mapList[hashValue].put(key, value);
        if (oldValue == null) {
            size++;
        }
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int hashValue = hashValue(key);
        if (mapList[hashValue] == null) {
            return null;
        }
        V removed = mapList[hashValue].remove(key);
        if (removed != null) {
            size--;
        }
        return removed;
    }

    @Override
    public List<K> keySet() {
        List<K> keys = new UnorderedArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            if (mapList[i] != null) {
                List<Entry<K, V>> entries = mapList[i].entrySet();
                for (int j = 0; j < entries.size(); j++) {
                    Entry<K, V> entry = entries.get(j);
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new UnorderedArrayList<V>(size);
        for (int i = 0; i < capacity; i++) {
            if (mapList[i] != null) {
                List<Entry<K, V>> mapEntries = mapList[i].entrySet();
                for (int j = 0; j < mapEntries.size(); j++) {
                    Entry<K, V> entry = mapEntries.get(j);
                    values.add(entry.value);
                }
            }
        }
        return values;
    }

    @Override
    public List<Entry<K, V>> entrySet() {
        List<Entry<K, V>> entries = new UnorderedArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            if (mapList[i] != null) {
                List<Entry<K, V>> mapEntries = mapList[i].entrySet();
                for (int j = 0; j < mapEntries.size(); j++) {
                    Entry<K, V> entry = mapEntries.get(j);
                    entries.add(entry);
                }
            }
        }
        return entries;
    }
}
