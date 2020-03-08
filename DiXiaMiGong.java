
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
 
/**
 * С������һ�첻С��������һ�������Թ�,
 * С����ϣ�����Լ���ʣ������ֵP������������Թ���
 * Ϊ���������,��������һ��n*m�ĸ����Թ�,
 * �Թ�ÿ��λ��Ϊ0����1,0�������λ�����ϰ���,
 * С���ܴﵽ�������λ��;1����С���ܿ��Դﵽ��λ�á�
 * С���ܳ�ʼ��(0,0)λ��,�����Թ��ĳ�����(0,m-1)(��֤������λ�ö���1,���ұ�֤һ������㵽�յ�ɴ��·��),
 * С�������Թ���ˮƽ�ƶ�һ����λ������Ҫ����1������ֵ,
 * ������һ����λ������Ҫ����3����λ������ֵ,
 * �����ƶ�����������ֵ,��С���ܵ�����ֵ����0��ʱ��û�е������,
 * С���ܽ��޷������Թ���������Ҫ�����С���ܼ�����ܷ��ý�ʣ������ֵ�����Թ�(���ﵽ(0,m-1)λ��)��
 */
public class �����Թ� {
 
    static int n, m, maxRemainEnergy = 0;
    static int[][] map;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> linkedlist = new LinkedList<>();
 
    public static void main(String[] args) {
 
        //����
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int P = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 
        //����
        runMap(0, 0, P);
 
        //���
        if (!flag)
            System.out.println("Can not escape!");
        else
            System.out.println(path);
 
    }
 
    public static synchronized void runMap(int x, int y, int energy) {
        if (energy < 0 || x<0 || y<0 || x>=n || y>= m || map[x][y] != 1) return;
        else {
            linkedlist.offer("[" + x + "," + y + "]");
            map[x][y] = 0;
            if (x == 0 && y == m - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1; linkedlist.removeLast();
                flag = true; return;
            }
            runMap(x, y+1, energy-1);
            runMap(x+1, y, energy);
            runMap(x-1, y, energy-3);
            runMap(x, y-1, energy-1);
            map[x][y] = 1;linkedlist.removeLast();
        }
    }
 
    public static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedlist.iterator();
        while (iterator.hasNext())
            sb.append(iterator.next() + ",");
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        path = sb.toString();
    }
 
}