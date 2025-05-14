class PeakIndex {
    public int peakIndexInMountainArray(int[] arr) {

        // int low = 0;
        // int high = arr.length - 1;

        // while (low < high) {
        //     int mid = low + (high - low) / 2;
        //     if (arr[mid] < arr[mid + 1]) {
        //         low = mid + 1;
        //     } else {
        //         high = mid;
        //     }
        // }

        // return low;

        return binarySearchPeak(arr, 0, arr.length - 1);

    }

    private int binarySearchPeak(int[] arr, int low, int high) {
        if (low == high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] < arr[mid + 1]) {
            return binarySearchPeak(arr, mid + 1, high);
        } else {
            return binarySearchPeak(arr, low, mid);
        }
    }
}