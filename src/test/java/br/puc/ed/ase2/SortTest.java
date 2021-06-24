package br.puc.ed.ase2;

import br.pucpr.ed.ase3.list.ListSort;
import br.pucpr.ed.ase3.list.SortableArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A execução dos testes 1 a 4 com sucesso valem valem 0,2 ponto cada.
 * Total: 4 * 0,2 = 0,8
 *
 * @todo Executar testes para validar implementação dos algoritmos de ordenação.
 */
public class SortTest {

    /**
     * Testa o bubble-sort.
     * A execução deste teste com sucesso vale 0,2 ponto.
     */
    @Test
    void teste1(){
        SortableArrayList<Integer> list = createList();
        list = ListSort.bubbleSort(list);
        Assertions.assertTrue(validateList(list));
    }

    /**
     * Testa o merge-sort.
     * A execução deste teste com sucesso vale 0,2 ponto.
     */
    @Test
    void teste2(){
        SortableArrayList<Integer> list = createList();
        list = ListSort.mergeSort(list);
        Assertions.assertTrue(validateList(list));
    }

    /**
     * Testa o shell-sort.
     * A execução deste teste com sucesso vale 0,2 ponto.
     */
    @Test
    void teste3(){
        SortableArrayList<Integer> list = createList();
        ListSort.shellSort(list);
        Assertions.assertTrue(validateList(list));
    }

    /**
     * Testa o quick-sort.
     * A execução deste teste com sucesso vale 0,2 ponto.
     */
    @Test
    void teste4(){
        SortableArrayList<Integer> list = createList();
        list = ListSort.quickSort(list);
        Assertions.assertTrue(validateList(list));
    }

    public SortableArrayList<Integer> createList(){
        SortableArrayList<Integer> list = new SortableArrayList<>(8);
        list.add(70);
        list.add(50);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(80);
        list.add(25);
        list.add(90);
        return list;
    }

    public boolean validateList(SortableArrayList<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
