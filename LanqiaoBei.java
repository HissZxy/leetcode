package lqb8;
 
import java.util.Scanner;
 
public class l8_1 {
 
	public static void main(String[] args) {
		double sum=0;
		Scanner input=new Scanner(System.in);
		double[][] nums=new double[100][2];
		for (int i = 0; i < 50; i++) {
			nums[i][0]=input.nextDouble();
			nums[i][1]=input.nextDouble();
		}
		
		for (int i = 0; i < 50; i++) {
			if (nums[i][0]==0) {
				break;
			}
			sum=sum+nums[i][0]*nums[i][1]/100;
		}
		System.out.println(sum);
	}
 
	
}