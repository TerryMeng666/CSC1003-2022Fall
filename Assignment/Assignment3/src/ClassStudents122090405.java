 import java.util.*;

 public class Student {
    private String name, gender, birthYear, phoneNumber;

    public Student(String name, String gender, String birthYear, String phoneNumber) {
        this.name           = name;
        this.gender         = gender;
        this.birthYear      = birthYear;
        this.phoneNumber    = phoneNumber;
        return;
    }

    public boolean check(String name) {
        return this.name.equals(name);
    }

    public String toString() {
        return name + ": " + gender + ", " + birthYear + ", " + phoneNumber; 
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n       = Integer.parseInt(sc.nextLine());
        Student[] s = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split(", ");
            s[i] = new Student(str[0], str[1], str[2], str[3]);
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; ++i) {
            String str      = sc.nextLine();
            boolean mark    = false;
            for (int j = 0; j < n; ++j)
                if (s[j].check(str)) {
                    mark = true;
                    System.out.println(s[j].toString());
                }
            if (!mark)
                System.out.println(str + ": None");
        }
        return;
    }
 }
