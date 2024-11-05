import java.util.Scanner;
public class HanoiTower{
	public static void hanoi(Integer n , int a , int b, int c){
		if (n==1){
			System.out.println(a+"->"+b);
		}else {
			hanoi(n-1, a, c, b);
			System.out.println(a+"->"+b);
			hanoi(n-1,c,b,a );
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		Hanoi t = new Hanoi();
		t.hanoi(n, a,b,c);
	}
}