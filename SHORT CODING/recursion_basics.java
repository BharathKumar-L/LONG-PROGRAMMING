public class recursion_basics {
    public static void main(String[] args) {
        flower(1000);
    }
    public static void flower(int a ){
        if(a==1)
            return;
        System.out.print(a+" ");
        flower(2*a);
        System.out.print(a+" ");
    }
}