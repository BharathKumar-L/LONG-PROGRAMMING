import java.util.Scanner;

public class spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                matrix[i][j] = sc.nextInt();
        int r=0,c=0;
        int topWall = 0;
        int bottomWall = row - 1;
        int leftWall = 0;
        int rightWall = col - 1;
        int total = row*col;
        int ansCount = 0;
        while(ansCount<total){
            while(c<=rightWall && ansCount<total){
                System.out.print(matrix[r][c]+" ");
                c++;
                ansCount++;
            }
            c--;r++;
            topWall+=1;
            while(r<=bottomWall && ansCount<total){
                System.out.print(matrix[r][c]+" ");
                r++;
                ansCount++;
            }
            r--;c--;
            rightWall-=1;
            while(c>=leftWall && ansCount<total){
                System.out.print(matrix[r][c]+" ");
                c--;
                ansCount++;
            }
            c++;r--;
            bottomWall-=1;
            while(r>=topWall && ansCount<total){
                System.out.print(matrix[r][c]+" ");
                r--;
                ansCount++;
            }
            r++;c++;
            leftWall+=1;
        }
        sc.close();
    }
}
