import java.util.*;
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // �������������ռ�
        if (iniString == null || iniString.length() <= 0)
            return iniString;
         
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}