import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        //创建接受键盘录入对象
        Scanner cin = new Scanner(System.in);
        // 接受文件名称或者文件路径
        String file = null;
        // 获取文件路径 最后一个“\” 下标索引
        int lastIndex = 0;
        // 获取文件名称
        // 接受错误出现的行号
        int errorLine = 0;
        // 创建一个HashMap<ErrLog>
        HashMap<String, ErrLog> hashMap = new HashMap<String, ErrLog>();
        ErrLog errLog = null;
        String key = null;
        StringBuilder sbBuilder = new StringBuilder();
        while (cin.hasNext()) {
            // 第一个参数为文件名称或文件路径
            file = cin.next();
            // 获取错误行号
            errorLine = cin.nextInt();
            // 获取最后一个'\'的索引
            lastIndex = file.lastIndexOf('\\');
            // 如果没有找到说明不是路径,直接返回文件名
            // 是路径 就截取\后面的字符串作为文件名
            sbBuilder
                .append(lastIndex < 0 ? file : file.substring(lastIndex + 1))
                .append(" ").append(errorLine);
            key = sbBuilder.toString();
            sbBuilder.setLength(0);
            // 将错误记录添加进hashMap 中
            errLog = hashMap.get(key);
            if (errLog == null) {
                // 如果不存在，new 一个并添加进去
                hashMap.put(key, new ErrLog(key, 1));
            } else errLog.size++; //存在，就将错误次数累加
        }
        cin.close();
        // ----------以上就是统计错误信息，下面是取值------------------
        ArrayList<ErrLog> list = new ArrayList<ErrLog>(hashMap.values());
        // 根据 错误次数比较，将错误次数多的放前面，如果错误次数一致，将出现顺序早的放到前面 进行排序
        Comparator<ErrLog> cmp = new Comparator<ErrLog>() {
            @Override
            public int compare(ErrLog o1, ErrLog o2) {
                return o2.size - o1.size == 0 ? (o1.queueMark - o2.queueMark)
                    : o2.size - o1.size;
            }
        };
        Collections.sort(list, cmp);
        // 取出前8个，并输出
        int lens = 8 > list.size() ? list.size() : 8;
        for (int i = 0; i < lens; i++) {
            //这里文件名如果大于16位 还需要截取文件名16位 + 行号 输出
            errLog = list.get(i);
            //这样就获取到了分界符' '的索引了,然后往前推16位就是我们要输出的文件名了
            lastIndex = errLog.name.lastIndexOf(" ");
            lastIndex = lastIndex - 16 < 0 ? 0 : lastIndex - 16;
            // 获取文件名并输出
            System.out.println((lastIndex == 0 ? errLog.name : errLog.name
                .substring(lastIndex)) + " " + errLog.size);
        }
    }
}
 
class ErrLog {
    // 此类并不标准，仅方便此题目实现而已
    static int mark; //辅助实现字段queueMark按出现顺序自增
    String name;//fileName 存储错误的文件名称，由完整的文件名，与错误行号组成。
    int queueMark; // 标记出现的顺序
    int size; // 统计出现错误的次数
 
    public ErrLog(String name, int size){
        super();
        this.name = name;
        this.queueMark = mark++;
        this.size = size;
    }
}