import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		int ans=dfs(a,n);
		System.out.println(ans);
	}
	public static int dfs(int[][] a, int n) {
		if(n==1) return a[0][0];
		if(n==2)return a[0][0]*a[1][1]-a[0][1]*a[1][0];
		int ans=0;
		int[][] b=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int row=0;row<n-1;row++) {
				for(int col=0;col<i;col++) {
					b[row][col]=a[row+1][col];
				}
				for(int col=i;col<n-1;col++) {
					b[row][col]=a[row+1][col+1];
				}
			}
			ans+=a[0][i]*dfs(b,n-1)*(i%2==0?1:-1);
		}
		return ans;
	}
}
