package fantage;

import java.util.*;

public class fantage {
	
	static int[][][] arr = new int[21][21][21];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			if(n1 == -1 && n2 == -1 && n3 == -1) break;
			
			System.out.print("w(" + n1 + ", " + n2 + ", " + n3 + ") = ");
			System.out.println(dfs(n1, n2, n3));
		}
	}
	public static int dfs(int n1, int n2, int n3) {
		
		if(inRange(n1, n2, n3)  && arr[n1][n2][n3] != 0) {
			return arr[n1][n2][n3];
		}
		
		if(n1 <= 0 || n2 <= 0 || n3 <= 0) {
			return 1;
		}
		else if(n1 > 20 || n2 > 20 || n3 > 20) {
			return arr[20][20][20] = dfs(20, 20, 20);
		}
		else if(n1 < n2 && n2 < n3) {
			return arr[n1][n2][n3] =  dfs(n1, n2, n3 - 1) + dfs(n1, n2 - 1, n3 - 1) - dfs(n1, n2 -1, n3);
		}
		else {
			return arr[n1][n2][n3] = dfs(n1 - 1, n2, n3) + dfs(n1 - 1, n2 - 1, n3) + dfs(n1 - 1, n2, n3 - 1) - dfs(n1 - 1, n2 - 1, n3 - 1);
		}
		
	}
	static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
	}

}