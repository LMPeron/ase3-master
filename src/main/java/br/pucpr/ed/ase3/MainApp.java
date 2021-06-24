package br.pucpr.ed.ase3;

import br.pucpr.ed.ase3.list.List;
import br.pucpr.ed.ase3.list.ListSort;
import br.pucpr.ed.ase3.list.OrderedArrayList;
import br.pucpr.ed.ase3.list.SortableArrayList;
import br.pucpr.ed.ase3.list.UnorderedArrayList;
import br.pucpr.ed.ase3.tree.ArvoreBinaria;
import br.pucpr.ed.ase3.util.StringUtil;
import br.pucpr.ed.ase3.util.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class MainApp {
    private static final int VARIEDADE_NUMEROS = 100000;

    /**
     * @todo Implementar a execução dos algoritmos definidos no README com
     *       quantidades variadas de elementos e de buscas. Exibir os resultados
     *       conforme especificações.
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        Random random = new Random();

        for (int quantidadeNumeros = 10000; quantidadeNumeros <= 30000; quantidadeNumeros = quantidadeNumeros + 10000) {
            for (int quantidadeBuscas = 10000; quantidadeBuscas <= 110000; quantidadeBuscas = quantidadeBuscas
                    + 25000) {
                        System.out.println("----------------------------------------------------------------\n");
                System.out.println(
                        "QUANTIDADE NÚMEROS: " + quantidadeNumeros + "\t QUANTIDADE BUSCAS: " + quantidadeBuscas + "\n");

                // Algoritmo Alocação Ordenação Busca Total

                System.out.println(StringUtil.lpad("Algoritmo", 20) + StringUtil.lpad("Alocação", 20)
                        + StringUtil.lpad("Ordenação", 20) + StringUtil.lpad("Busca", 20)
                        + StringUtil.lpad("Total", 20) + "\n");

                int[] numerosGerados = IntStream.generate(() -> random.nextInt(VARIEDADE_NUMEROS))
                        .limit(quantidadeNumeros).toArray();
                int[] numerosParaProcurar = new int[quantidadeBuscas];
                for (int i = 0; i < numerosParaProcurar.length; i++) {
                    numerosParaProcurar[i] = numerosGerados[random.nextInt(quantidadeNumeros)];
                }

                timer.startTimer("sequencial");
                List<Integer> numberList = alocacaoArrayNaoOrdenado(numerosGerados, quantidadeNumeros);
                timer.addStop("sequencial");
                timer.addStop("sequencial");
                buscaSequencial(numberList, numerosParaProcurar);
                timer.addStop("sequencial");

                List<Long> result = timer.getResult("sequencial");
                Long total = timer.getTotal("sequencial");

                System.out.println(
                StringUtil.lpad("sequencial", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

                timer.startTimer("binaria");
                numberList = alocacaoArrayOrdenado(numerosGerados, quantidadeNumeros);
                timer.addStop("binaria");
                timer.addStop("binaria");
                buscaBinaria(numberList, numerosParaProcurar);
                timer.addStop("binaria");

                result = timer.getResult("binaria");
                total = timer.getTotal("binaria");
                System.out.println(
                StringUtil.lpad("binaria", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

                timer.startTimer("bubble-sort");
                var sortableList = alocacaoSortableArrayList(numerosGerados, quantidadeNumeros);
                timer.addStop("bubble-sort");
                ListSort.bubbleSort(sortableList);
                timer.addStop("bubble-sort");
                buscaBinaria(sortableList, numerosParaProcurar);
                timer.addStop("bubble-sort");

                System.out.println(
                StringUtil.lpad("bubble-sort", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

                timer.startTimer("merge-sort");
                sortableList = alocacaoSortableArrayList(numerosGerados, quantidadeNumeros);
                timer.addStop("merge-sort");
                ListSort.mergeSort(sortableList);
                timer.addStop("merge-sort");
                buscaBinaria(sortableList, numerosParaProcurar);
                timer.addStop("merge-sort");

                result = timer.getResult("merge-sort");
                total = timer.getTotal("merge-sort");
                System.out.println(
                StringUtil.lpad("merge-sort", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

                timer.startTimer("shell-sort");
                sortableList = alocacaoSortableArrayList(numerosGerados, quantidadeNumeros);
                timer.addStop("shell-sort");
                ListSort.shellSort(sortableList);
                timer.addStop("shell-sort");
                buscaBinaria(sortableList, numerosParaProcurar);
                timer.addStop("shell-sort");

                result = timer.getResult("shell-sort");
                total = timer.getTotal("shell-sort");
                System.out.println(
                StringUtil.lpad("shell-sort", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

                timer.startTimer("quick-sort");
                sortableList = alocacaoSortableArrayList(numerosGerados, quantidadeNumeros);
                timer.addStop("quick-sort");
                ListSort.quickSort(sortableList);
                timer.addStop("quick-sort");
                buscaBinaria(sortableList, numerosParaProcurar);
                timer.addStop("quick-sort");
                System.out.println(
                StringUtil.lpad("quick-sort", 20) +
                StringUtil.lpad(result.get(0).toString(), 20) +
                StringUtil.lpad(result.get(1).toString(), 20) +
                StringUtil.lpad(result.get(2).toString(), 20) +
                StringUtil.lpad(total.toString(), 20)
                );

            }
        }
    }

    private static List<Integer> alocacaoArrayNaoOrdenado(int[] numbersArray, int quantidadeNumeros) {
        List<Integer> numberList = new UnorderedArrayList(quantidadeNumeros);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static SortableArrayList alocacaoSortableArrayList(int[] numbersArray, int quantidadeNumeros) {
        var numberList = new SortableArrayList<>(quantidadeNumeros);
        for (var i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaSequencial(List<Integer> numberList, int[] numbersToSearch) {
        for (int i = 0; i < numbersToSearch.length; i++) {
            numberList.exists(numbersToSearch[i]);
        }
    }

    private static List<Integer> alocacaoArrayOrdenado(int[] numbersArray, int quantidadeNumeros) {
        List<Integer> numberList = new OrderedArrayList(quantidadeNumeros);
        for (int i = 0; i < numbersArray.length; i++) {
            numberList.add(numbersArray[i]);
        }
        return numberList;
    }

    private static void buscaBinaria(List<Integer> numberList, int[] numbersToSearch) {
        for (int i = 0; i < numbersToSearch.length; i++) {
            numberList.exists(numbersToSearch[i]);
        }
    }

}
