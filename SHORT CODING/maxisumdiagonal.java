import java.util.*;
public class maxisumdiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i <n;i++)
            for(int j=0;j<=i;j++)
                arr[i][j]=sc.nextInt();  
        System.out.println(recursion(arr,0,0,arr.length));
        sc.close();      
    }
    static int recursion(int arr[][],int i,int j,int n){
        if(i==n-1)
            return arr[n-1][j];
        int d = arr[i][j]+recursion(arr,i+1,j,n);
        int d1 = arr[i][j]+recursion(arr,i+1,j+1,n);
        return Math.max(d,d1);
    }
}
