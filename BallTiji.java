import java.lang.Math;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            double x0=in.nextFloat();
            double y0=in.nextFloat();
            double z0=in.nextFloat();
            double x1=in.nextFloat();
            double y1=in.nextFloat();
            double z1=in.nextFloat();
            //注意要在循环输入语句中输出结果
            //注意输入格式哟
            System.out.printf("%.3f",getRadius(x0,y0,z0,x1,y1,z1));
            System.out.print(" ");
            System.out.printf("%.3f",getVolume(x0,y0,z0,x1,y1,z1));
            System.out.println();
        }
        in.close();
    }
    //计算半径的方法，写的详细了点，快的话，可以直接return表达式
    public static double getRadius(double x0,double y0,double z0,double x1,double y1,double z1){
        double radius=0;
        double radiusSquare=0;
        radiusSquare=(x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        radius=Math.sqrt(radiusSquare);//开根号方法
        return radius;
    }
    //计算体积的方法
    public static double getVolume(double x0,double y0,double z0,double x1,double y1,double z1){
        double volume=0;
        //调用math中的方法，也可以用r*r*r
        volume=4*Math.acos(-1)*Math.pow(getRadius(x0,y0,z0,x1,y1,z1), 3)/3;
        return volume;
    }
}