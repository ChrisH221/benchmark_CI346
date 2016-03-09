import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/03/2016.
 */
public class sorter
{
    List<Integer> arr;

    public  sorter(List<Integer> arr) {


        if (arr.size() == 0) {
            return;
        }
        this.arr = arr;
        int length = arr.size();
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        int pivot = arr.get(lowerIndex+(higherIndex-lowerIndex)/2);

        while (i <= j) {

            while (arr.get(i) < pivot) {
                i++;
            }
            while (arr.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

}
