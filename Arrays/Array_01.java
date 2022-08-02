package Arrays;
import java.util.*;

class pair {
    long max, min;
    public pair(long max, long min)
    {
        this.max = max;
        this.min = min;
    }
}


public class Array_01 {

    public static pair findMaxAndMin(int[] arr){
        pair obj = new pair(Integer.MIN_VALUE, Integer.MAX_VALUE);

        for (int elem : arr){
            if (elem < obj.min){
                obj.min = elem;
            }
            if (elem > obj.max){
                obj.max = elem;
            }
        }

//        System.out.println(obj.min + " " + obj.max);
        return obj;
    }

    public static int findKthSmallest(int[] arr, int k){
        //Min Heap:
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int elem : arr){
            pq.add(elem);
        }
        int ans = -1;
        //to find the kth smallest element, we'll run the loop k times:
        for (int i = 0; i < k; i++) {
            ans = pq.poll();
        }

        return ans;
    }

    public static void sort012(int[] arr){

        int low = 0, mid = 0;
        int high = arr.length-1;

        int temp;
        while (mid <= high){
            if (arr[mid] == 0){
                //swap elements at low and mid
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++; low++;
            }else if (arr[mid] == 1){
                mid++;
            }else { //arr[mid] == 2
                //swap elements at high and mid, dec high
                temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }

    }

    public static void segregateElements(int[] arr){

        int t1 = 0, t2 = 1; int temp;
        while (t2 < arr.length){

            //if t2 is negative increment both the ptrs
            if (arr[t2] >= 0) { //if t2 is positive => shift the positive num to its correct location:
                int pos = t1;
                int curr = t2;
                while (pos >= 0 && arr[pos] < 0) {
                    temp = arr[pos];
                    arr[pos] = arr[curr];
                    arr[curr] = temp;
                    pos--;
                    curr--;
                }
            }
            t1++; t2++;
        }
    }

    public static int[] nextPermutation(int[] arr, int n){

        int ind1 = 0, ind2 = 0;
        for (int i = 0; i < n; i++) {
            if (i+1 < n && arr[i] < arr[i+1]){
                ind1 = i+1;
                break;
            }
        }

        for (int j = n-1; j >= 0; j--){
            if (arr[j] > arr[ind1]){
                ind2 = j;
                break;
            }
        }

        if (ind1 == ind2){ //that means arr is in desc.form
            return arr;
        }
        //swap the elements at ind1 and ind2:
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;

        //reverse the elements from ind1+1 to (n-1):
        int t1 = ind1+1; int t2 = n-1;
        while (t1 < t2){
            temp = arr[t1];
            arr[t1] = arr[t2];
            arr[t2] = temp;
            t1++; t2--;
        }


        return arr;
    }

    public static boolean findSubArrayWithSum0(int[] arr){

        int sumTillNow = 0; //prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int elem : arr) {
            sumTillNow += elem;

            if (sumTillNow == 0) {
                return true;
            }
            //push into map => check if it already contains that element:
            if (map.containsKey(sumTillNow)) {
                return true;
            } else {
                map.put(sumTillNow, 1);
            }
        }

        return false;
    }

    private static int longestContinuousSubSequence(int[] arr) {

        HashSet<Integer> hs = new HashSet<>();
        for (int elem : arr){
            hs.add(elem);
        }

        int max = 1;
        for (int i = 0; i < arr.length; i++) {

            //if must be the 1st element of the subsequence:
            if (!hs.contains(arr[i]-1)){

                int j = arr[i];
                while (hs.contains(j)){
                    j++;
                }

                if (max < (j-arr[i])){
                    max = j-arr[i];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int[] arr = {1,2,35,2,1,454,11};
//        findMaxAndMin(arr);

//        int k = sc.nextInt();
//        System.out.println(findKthSmallest(arr, k));

//        int[] arr = {0,1,2,2,1,0,2,1,0};
//        sort012(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {-8, 9, 5, 10, 2, 6, -7, 7};
//        segregateElements(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {3,2,1};
//        System.out.println(Arrays.toString(nextPermutation(arr, 3)));

//        int[] arr = {1,4,-2,-2,5,-4,3};
//        System.out.println(findSubArrayWithSum0(arr));

        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestContinuousSubSequence(arr));


    }


}
