import java.util.Scanner;
public class untitled {
    public static void main(String[] args) {
        int [][] a = new int [110][110];
        int [][] b = new int [110][110];
        int [][] c = new int [110][110];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = scanner.nextInt();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < k; j++)
                b[i][j] = scanner.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < k; j++) 
                for(int t = 0; t < m; t++)
                    c[i][j] += a[i][t] * b[t][j];
        System.out.println(n + " " + k);
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < k; j++)
                System.out.print(c[i][j] + " ");
                System.out.println(" ");
        }
    }
}