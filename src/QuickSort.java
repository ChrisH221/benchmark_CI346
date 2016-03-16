import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 16/03/2016.
 */
public class QuickSort  {
    private List<Integer> numbers;
    private int number;

    public void sort(List<Integer> values) {
        // check for empty or null array
        if (values ==null || values.size()==0){
            return;
        }
        this.numbers = values;
        number = values.size();
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = (low + (high-low)/2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers.get(i) < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers.get(j) > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i,numbers.get(j) ) ;
        numbers.set(j,temp);
    }
}

