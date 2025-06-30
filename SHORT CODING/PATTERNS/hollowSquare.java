import java.util.Scanner;

public class hollowSquare{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the number of rows: ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("*");
            if(i==1 || i==n)
                System.out.print("*".repeat(n-2));
            else
                System.out.print(" ".repeat(n-2));
            System.out.print("*");
            System.out.println();
        }
        sc.close();
    }
}