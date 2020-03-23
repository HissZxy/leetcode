import java.util.*;

public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int [] a = new int[m*n];
        if(mat == null)
            return a;
        int i =0;
        int j =0;
        int k =0;
        int startX =0;
        int startY =0;
        int endX =n-1;
        int endY =m-1;
        while(startX <= endX && startY <= endY){
            if(startX == endX){
                for( ; j <= endY; j++, k++){
          

                    a[k] =    mat[startX][j];
                }
                return a;
            }
            //如果只剩下一列 
            if( startY ==    endY ){
                for( ; i    <= endX ; i++,k++){
                    a[k] =    mat[i][startY];
                }
                return a;
            }

            //将矩阵上边除右顶点添加到返回的数组中

            for( ; j <    endY ; j++,k++){
                a[k] =    mat[i][j];
            }
            //将矩阵右边除边下顶点添加到返回的数组中 
            for( ; i <    endX ; i++,k++){
                a[k] =    mat[i][j];
            }
            //将矩阵下边除边左顶点添加到返回的数组中 
            for( ; j >    startX ; j--,k++){
                a[k] =    mat[i][j];
            }
            //将矩阵左边除边上顶点添加到返回的数组中 
            for( ; i >    startY ; i--,k++){
                a[k] =    mat[i][j];
            }

            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;
        }

        return a;

    }
} 
