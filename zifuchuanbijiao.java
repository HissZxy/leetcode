class Solution {
    public int lengthOfLongestSubstring(String s) {
       //���sΪ�գ�length������0����һ���մ�����û������ִ�еı�Ҫ��
        if(s != null && s.length() > 0 && s != ""){
            //String -> char[]
            char[] strChar = s.toCharArray();
            // �洢��ִ� key:charֵ��value:index�±�
            ArrayList<String> maxStr = new ArrayList<>();
            //��ʱ���ִ��洢�ռ�
            ArrayList<String> tempStr = new ArrayList<>();
            //ѭ��
            for(int i=0; i<strChar.length; i++){
                //char -> String
                String str = new String(new char[]{strChar[i]});
                //�ж�str�Ƿ������tempStr��
                if(tempStr.contains(str)){
                    //���ж�tempStr�ĳ����Ƿ���ڵ���maxStr�ĳ���,���ڣ����ܽ���ִ�����
                    if(tempStr.size() > maxStr.size()){
                        maxStr = new ArrayList<>(tempStr);
                    }
                    //�洢�ظ��ַ�
                    int reIndex = tempStr.indexOf(str);
                    // ɾ��tempStr�е��ظ��ֽڼ���֮ǰ���ַ�
                    for(int j=0;j<=reIndex;j++){
                        tempStr.remove(0);
                    }
                }
                //����ǰ�ַ�����tempStr��
                tempStr.add(str);
            }
            //�����ж�
            if(tempStr.size() > maxStr.size()){
                maxStr = tempStr;
            }
            //������ִ��ĳ���
            return maxStr.size();
        }
        return 0;
    }
}