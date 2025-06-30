import java.util.Scanner;

public class diamond{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the number of rows: ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(" ".repeat(n-i));
            for(int j=1;j<=2*i-1;j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i=n-1;i>0;i--){
            System.out.print(" ".repeat(n-i));
            for(int j=1;j<=2*i-1;j++)
                System.out.print("*");
            System.out.println();
        }
        sc.close();
    }
}