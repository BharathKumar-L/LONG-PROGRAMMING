import java.util.*;

public class Pattern1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 1; i <= n; i++) {
			int index = i;
			arr[i - 1][--index] = i;
			int incr = 5;
			for (int j = 2; j <= i; j++) {
				arr[i - 1][i - j] = arr[i - 1][index] + incr;
				index--;
				incr--;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++){
				if(arr[i][j]!=0){
					if(arr[i][j]<10)
						System.out.print(arr[i][j] + "  ");
					else
						System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}