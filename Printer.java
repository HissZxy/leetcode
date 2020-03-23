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
            //���ֻʣ��һ�� 
            if( startY ==    endY ){
                for( ; i    <= endX ; i++,k++){
                    a[k] =    mat[i][startY];
                }
                return a;
            }

            //�������ϱ߳��Ҷ�����ӵ����ص�������

            for( ; j <    endY ; j++,k++){
                a[k] =    mat[i][j];
            }
            //�������ұ߳����¶�����ӵ����ص������� 
            for( ; i <    endX ; i++,k++){
                a[k] =    mat[i][j];
            }
            //�������±߳����󶥵���ӵ����ص������� 
            for( ; j >    startX ; j--,k++){
                a[k] =    mat[i][j];
            }
            //��������߳����϶�����ӵ����ص������� 
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
