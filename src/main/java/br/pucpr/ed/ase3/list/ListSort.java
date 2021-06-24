package br.pucpr.ed.ase3.list;

import java.util.Arrays;

public class ListSort {

    /**
     * @todo Implementar bubble-sort.
     */
    public static SortableArrayList bubbleSort(SortableArrayList list) {

        int size = list.size();
        for (var i = 0; i < size - 1; i++) {
            for (var j = 0; j < size - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    var order = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, order);
                }
            }
        }
        return list;
    }

    /**
     * @todo Implementar merge-sort.
     */
    public static SortableArrayList mergeSort(SortableArrayList list) {

        var left = new SortableArrayList<>(list.size() / 2 +1);
        var right = new SortableArrayList<>(list.size() / 2 +1);
        
        int center;

        if (list.size() == 1) 
            return list;
        
        else {
            center = list.size() / 2;

            for (var i = 0; i < center; i++) 
                left.add(list.get(i));
            
        
            for (int i = center; i < list.size(); i++) 
                right.add(list.get(i));

            left = mergeSort(left);
            right = mergeSort(right);
            list = merge(left, right);
        }

        return list;
    }

    /**
     * @todo Implementar merge.
     */
    private static SortableArrayList merge(SortableArrayList list1, SortableArrayList list2) {

        var list = new SortableArrayList<>(list1.size() + list2.size());

        var left = 0;
		var right = 0;
		var index = 0;

        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left).compareTo(list2.get(right)) < 0) {
                list.set(index, list1.get(left));
                left++;
            } else {
                list.set(index, list2.get(right));
                right++;
            }
            index++;
        }

        while (left < list1.size()) {
            list.set(index, list1.get(left));
            index++;
            left++;
        }

        while (right < list2.size()) {
            list.set(index, list2.get(right));
            index++;
            right++;
        }

        return list;
	}
    

    /**
     * @todo Implementar shell-sort.
     */
    public static SortableArrayList shellSort(SortableArrayList list) {

        for (int g = list.size() / 2; g > 0; g /= 2) {
            for (int i = g; i < list.size(); i += 1) {
                var temp = list.get(i);

                int j;
                for (j = i; j >= g && list.get(j - g).compareTo(temp) > 0; j -= g)
                    list.set(j, j - g);

                list.set(j, temp);

            }
        }

        return list;
    }

    /**
     * @todo Implementar quick-sort.
     */
    public static SortableArrayList quickSort(SortableArrayList list) {
        if (list.isEmpty() || list.size() == 1)
            return list;
        var s = new SortableArrayList<>(list.array.length);
        var g = new SortableArrayList<>(list.array.length) ;
        var pivot = list.get(0);
        int i;
        Comparable j;

        for (i = 1; i < list.size(); i++) {
            j = list.get(i);
            if (j.compareTo(pivot) < 0)
                s.add(j);
            else
                g.add(j);
        }

        s = quickSort(s);
        g = quickSort(g);
        s.add(pivot);

        for (var k = 0; k < g.size() - 1; k++) {
            s.add(g.get(k));
        }
        list = s;
        return list;
    }
}
