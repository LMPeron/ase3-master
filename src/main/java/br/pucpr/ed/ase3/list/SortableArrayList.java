package br.pucpr.ed.ase3.list;

import java.util.stream.Stream;

public class SortableArrayList<T extends Comparable> extends UnorderedArrayList<T> {

    public SortableArrayList(Integer capacity) {
        super();
        array = (T[]) new Comparable[capacity];
        size = 0;
    }

    public SortableArrayList(T[] array){
        this.array = array;
        this.size = Math.toIntExact(Stream.of(array).filter(a -> a != null).count());
    }

    @Override
    public void add(T element) {
        super.add(element);
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }

    @Override
    public T find(T key) {
        return super.find(key);
    }

    @Override
    public boolean exists(T key) {
        return binaryExists(key); // com recursão
    }

    private boolean binaryExists(T key){
        int baixo = 0;
        int cima = size - 1;
        while (baixo <= cima){
            int meio = (cima + baixo) / 2;
            int resultado = key.compareTo(array[meio]);
            if(resultado == 0){
                return true;
            } else if(resultado < 0){
                cima = meio - 1;
            } else {
                baixo = meio + 1;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index >= array.length){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}
