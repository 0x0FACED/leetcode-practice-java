// Quick Sort

class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int supportElement = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < supportElement) {
                i++;
            }

            while (array[j] > supportElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
