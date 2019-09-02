import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		while(!checkMagicNumber(++n));
		
		System.out.println(n);
		
	}

	private static boolean checkMagicNumber(int n) {
		
		while(n > 0) {
			int r = n%10;
			if(r == 4 || r == 7) n/=10;
			else return false;
		}
		return true;
	}
}
