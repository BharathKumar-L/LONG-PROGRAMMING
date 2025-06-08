import java.util.Scanner;

class remove_outermost_parantheses{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuffer sb = new StringBuffer(s);
        int open = 0;
        int close = 0;
        int open_i = 0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                if(open==0)
                    open_i=i;   
                open++;
            }
            else if (s.charAt(i)==')'){
                close++;
            }
            if(open==close && open!=0){
                sb.setCharAt(i, ' ');
                sb.setCharAt(open_i, ' ');
                open=0;
                close=0;
            }
        }
        System.out.println(sb.toString().replace(" ", ""));
        sc.close();
    }
}
