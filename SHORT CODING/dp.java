public class dp {
    public static void main(String[] args) {
        int[] arr = {130,60,-20,-60,170};
        System.out.println(recursion(arr,arr.length-1));
    }
     static int recursion(int[] arr, int i){
        if(i < 0) return 0;
        if(i == 0) return arr[i];

        int t = arr[i] + recursion(arr, i - 2);
        int nt = 0 + recursion(arr, i - 1);
        return Math.max(nt, t);
     }
}