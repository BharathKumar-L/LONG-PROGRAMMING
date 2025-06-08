import java.util.Scanner;

public class string_compression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int i=0,j=0;
        int count =0;
        while(i<len){
            while(j<len){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
                else{
                    break;
                }
                j++;
            }
            System.out.print(s.charAt(i)+""+(count>1?count:""));
            i=j;
            count=0;
        }
        sc.close();
    }
}
