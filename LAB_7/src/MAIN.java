import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size...");
        int size = sc.nextInt();

        gen_arr ob = new gen_arr();
        ob.size=size;
        ob.gen_arr();



        long time = start - System.currentTimeMillis();
        System.out.println();
        System.out.println("TIME: "+(-time));}
}
