import java.util.Scanner;

public class find_distance_of_given_char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.next();
        char c = sc.next().charAt(0);
        int dist[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int index = s.substring(i, s.length()).indexOf(c);
            if(index==-1){
                StringBuffer sb = new StringBuffer(s.substring(0, i));
                sb.reverse();
                System.out.println(sb.toString()+" "+i);
                index = sb.toString().indexOf(c);
                dist[i] = index - i;
            }
            else
                dist[i] = index - i;
        }
        for(int i=0;i<s.length();i++)
            System.out.print(dist[i]+" ");
        sc.close();
    }
}
