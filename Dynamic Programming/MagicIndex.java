public class MagicIndex{

    public static int findMagicIndex(int[] arr, int start, int end){
        if(end < start)
            return -1;
            
        int mid = (start + end) / 2;
        if(arr[mid] == mid)
            return mid;
        else if(arr[mid] > mid)
            return findMagicIndex(arr, start, mid-1);
        else 
            return findMagicIndex(arr, mid+1, end);
    }

    public static void main(String[] args){
        int[] inputArray = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(findMagicIndex(inputArray, 0, inputArray.length-1));
    }
}