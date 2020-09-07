import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) {
        // Elemento<Integer> e1= new Elemento();
        ArrayList<Elemento> arr = new ArrayList<>();
        ArrayList<Elemento> arr2 = new ArrayList<>();
        ArrayList<Elemento> arr3 = new ArrayList<>();
        ArrayList<Elemento> arr4 = new ArrayList<>();
        ArrayList<Elemento> arr5 = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Elemento x = new Elemento<>();
            x.set(i + (int) (Math.random() * 100));
            arr.add(x);
            arr2.add(x);
            arr3.add(x);
            arr4.add(x);
            arr5.add(x);
        }
        bubble(arr);
        selection(arr2);
        insert(arr3);
        System.out.println("# Merge sort te odio alv #");
        System.out.println("UNSORTED: " + arr4);
        System.out.println("SORTED: " + merge(arr4));
        System.out.println("# QUICK SORT #");
        Qsort(arr5);
        // Bubble, Select, Insert, Merge, Quicksort
    }

    public static ArrayList<Elemento> bubble(ArrayList<Elemento> arr) {
        System.out.println("# bubble sort #");
        System.out.println("UNSORTED: " + arr);
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j).get().compareTo(arr.get(j + 1).get()) > 0) {
                    Collections.swap(arr, j, (j + 1));
                }
        System.out.println("SORTED: " + arr);
        return arr;
    }

    public static ArrayList<Elemento> selection(ArrayList<Elemento> arr) {
        System.out.println("# selection sort #");
        System.out.println("UNSORTED: " + arr);
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j).get().compareTo(arr.get(min_idx).get()) < 0)
                    min_idx = j;
            Collections.swap(arr, i, min_idx);
        }
        System.out.println("SORTED:" + arr);
        return arr;
    }

    public static ArrayList<Elemento> insert(ArrayList<Elemento> arr) {
        System.out.println("# insertion sort #");
        System.out.println("UNSORTED: " + arr);
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            Elemento key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j).get().compareTo(key.get()) > 0) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        System.out.println("SORTED: " + arr);
        return arr;
    }

    public static ArrayList<Elemento> merge(ArrayList<Elemento> a) {
        if (a.size() <= 1)
            return a;
        int mid = a.size() / 2;
        ArrayList<Elemento> left = new ArrayList<Elemento>();
        ArrayList<Elemento> right = new ArrayList<Elemento>();

        for (int i = 0; i < mid; i++)
            left.add(a.remove(0));
        while (a.size() != 0)
            right.add(a.remove(0));
        merge(left);
        merge(right);
        while (left.size() != 0 && right.size() != 0) {
            if (left.get(0).get().compareTo(right.get(0).get()) < 0)
                a.add(left.remove(0));
            else
                a.add(right.remove(0));
        }
        while (left.size() != 0)
            a.add(left.remove(0));
        while (right.size() != 0)
            a.add(right.remove(0));
        return a;
    }

    public static void Qsort(ArrayList<Elemento> arr) {
        quickSort(arr, arr.size() / 2, arr.size() - 1);
    }

    public static void quickSort(ArrayList<Elemento> arr, int from, int to) {
        if (from < to) {
            int p = split(arr, from, to);
            quickSort(arr, from, p);
            quickSort(arr, p + 1, to);
        }
        System.out.println("SORTED: " + arr);
    }

    public static int split(ArrayList<Elemento> arr, int from, int to) {
        Elemento pivot = arr.get(from);
        int i = from - 1;
        int j = to + 1;

        while (i < j) {
            i++;
            while ((arr.get(i).get().compareTo(pivot.get()) < 0)) {
                i++;
            }
            j--;
            while ((arr.get(i).get().compareTo(pivot.get()) > 0)) {
                j--;
            }
            if (i < j) {
                Elemento temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        return j;
    }

}
