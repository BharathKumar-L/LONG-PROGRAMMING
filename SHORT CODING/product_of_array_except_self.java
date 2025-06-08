import java.util.Scanner;

public class product_of_array_except_self {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num_arr[] = new int[size];
        for(int i=0;i<size;i++)
            num_arr[i] = sc.nextInt();
        int prefix[] = new int[size];
        int suffix[] = new int[size];
        prefix[0] = 1;
        suffix[size-1] = 1;
        for(int i=1;i<size;i++)
            prefix[i] = prefix[i-1] * num_arr[i-1];
        for(int i=size-2;i>=0;i--)
            suffix[i] = suffix[i+1] * num_arr[i+1];
        for(int i=0;i<size;i++)
            System.out.println(prefix[i]*suffix[i]);
        sc.close();
    }
}
