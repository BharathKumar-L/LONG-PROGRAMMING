import java.util.*;
class count_perfect_squares{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num_arr[] = new int[n];
        int count =0;
        for(int i=0;i<n;i++){
            num_arr[i] = sc.nextInt();
            if(Math.sqrt(num_arr[i]) == (int)Math.sqrt(num_arr[i]))
                count++;
        }
        System.out.println(count);
        sc.close();
    }
}