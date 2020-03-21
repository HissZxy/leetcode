import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        //�������ܼ���¼�����
        Scanner cin = new Scanner(System.in);
        // �����ļ����ƻ����ļ�·��
        String file = null;
        // ��ȡ�ļ�·�� ���һ����\�� �±�����
        int lastIndex = 0;
        // ��ȡ�ļ�����
        // ���ܴ�����ֵ��к�
        int errorLine = 0;
        // ����һ��HashMap<ErrLog>
        HashMap<String, ErrLog> hashMap = new HashMap<String, ErrLog>();
        ErrLog errLog = null;
        String key = null;
        StringBuilder sbBuilder = new StringBuilder();
        while (cin.hasNext()) {
            // ��һ������Ϊ�ļ����ƻ��ļ�·��
            file = cin.next();
            // ��ȡ�����к�
            errorLine = cin.nextInt();
            // ��ȡ���һ��'\'������
            lastIndex = file.lastIndexOf('\\');
            // ���û���ҵ�˵������·��,ֱ�ӷ����ļ���
            // ��·�� �ͽ�ȡ\������ַ�����Ϊ�ļ���
            sbBuilder
                .append(lastIndex < 0 ? file : file.substring(lastIndex + 1))
                .append(" ").append(errorLine);
            key = sbBuilder.toString();
            sbBuilder.setLength(0);
            // �������¼��ӽ�hashMap ��
            errLog = hashMap.get(key);
            if (errLog == null) {
                // ��������ڣ�new һ������ӽ�ȥ
                hashMap.put(key, new ErrLog(key, 1));
            } else errLog.size++; //���ڣ��ͽ���������ۼ�
        }
        cin.close();
        // ----------���Ͼ���ͳ�ƴ�����Ϣ��������ȡֵ------------------
        ArrayList<ErrLog> list = new ArrayList<ErrLog>(hashMap.values());
        // ���� ��������Ƚϣ������������ķ�ǰ�棬����������һ�£�������˳����ķŵ�ǰ�� ��������
        Comparator<ErrLog> cmp = new Comparator<ErrLog>() {
            @Override
            public int compare(ErrLog o1, ErrLog o2) {
                return o2.size - o1.size == 0 ? (o1.queueMark - o2.queueMark)
                    : o2.size - o1.size;
            }
        };
        Collections.sort(list, cmp);
        // ȡ��ǰ8���������
        int lens = 8 > list.size() ? list.size() : 8;
        for (int i = 0; i < lens; i++) {
            //�����ļ����������16λ ����Ҫ��ȡ�ļ���16λ + �к� ���
            errLog = list.get(i);
            //�����ͻ�ȡ���˷ֽ��' '��������,Ȼ����ǰ��16λ��������Ҫ������ļ�����
            lastIndex = errLog.name.lastIndexOf(" ");
            lastIndex = lastIndex - 16 < 0 ? 0 : lastIndex - 16;
            // ��ȡ�ļ��������
            System.out.println((lastIndex == 0 ? errLog.name : errLog.name
                .substring(lastIndex)) + " " + errLog.size);
        }
    }
}
 
class ErrLog {
    // ���ಢ����׼�����������Ŀʵ�ֶ���
    static int mark; //����ʵ���ֶ�queueMark������˳������
    String name;//fileName �洢������ļ����ƣ����������ļ�����������к���ɡ�
    int queueMark; // ��ǳ��ֵ�˳��
    int size; // ͳ�Ƴ��ִ���Ĵ���
 
    public ErrLog(String name, int size){
        super();
        this.name = name;
        this.queueMark = mark++;
        this.size = size;
    }
}