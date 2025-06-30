import java.util.Scanner;

public class pascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("1");
            int ans = 1;
            for(int j=1;j<i;j++){
                ans = ans*(i-j);
                ans = ans/j;
                System.out.print(" "+ans);
            }
            System.out.println(" 1");
        }
        sc.close();
    }
}
