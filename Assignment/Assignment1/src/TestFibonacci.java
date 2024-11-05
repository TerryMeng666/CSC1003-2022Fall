 import java.util.*;

public class TestFibonacci {

	static Scanner input = new Scanner(System.in);

	public static void parse_line(int n, int d) {
		if (d > n) {
			System.out.println("invalid");
			return;
		}

		long[] f = new long[(int)1e5+5];

		f[0] = f[1] = 1;

		for (int i = 2; i < n; ++i)
			f[i] = f[i - 1] + f[i - 2];

		for (int i = n - 1; i > n - d; --i)
			System.out.print(f[i] + ", ");
		if (d == 0)
			System.out.println("");
		else
			System.out.println(f[n - d]);
		return;
	}

	public static void main(String[] args) throws Exception {
		int line_number = Integer.parseInt(input.nextLine());
		for (int i = 0; i < line_number; ++i) {
			String s = input.nextLine();
			String t[] = s.split(", ");
			int n = Integer.parseInt(t[0]);
			int d = Integer.parseInt(t[1]);
			TestFibonacci.parse_line(n, d);
		}
		return;
	}
}