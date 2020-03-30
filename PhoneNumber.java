class Solution {
	//һ��ӳ����ڶ���λ����"abc��,������λ����"def"������
	//����Ҳ������map����������Ը���ʡ���ڴ�
	String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
		//ע��߽�����
		if(digits==null || digits.length()==0) {
			return new ArrayList<>();
		}
		iterStr(digits, "", 0);
		return res;
	}
	//������������list
	List<String> res = new ArrayList<>();
	
	//�ݹ麯��
	void iterStr(String str, String letter, int index) {
		//�ݹ����ֹ������ע���������ֹ��������ȥ����̬��ʾͼ��Щ��ͬ����Ҫ�����˵��Ż�
		//��̬ͼ����ÿ�ν�ȡ�ַ�����һ���֣�"234"�����"23"���ٱ��"3"�������""���������ܲ���
		//����index��¼ÿ�α������ַ�����λ�ã��������ܸ���
		if(index == str.length()) {
			res.add(letter);
			return;
		}
		//��ȡindexλ�õ��ַ�������������ַ���"234"
		//��һ�εݹ�ʱindexΪ0����c=2���ڶ���indexΪ1����c=3��������c=4
		//subStringÿ�ζ��������µ��ַ�������index����ȡ��ǰ��һ���ַ�������Ч�ʸ���һ��
		char c = str.charAt(index);
		//map_string���±��Ǵ�0��ʼһֱ��9�� c-'0'�Ϳ���ȡ����Ե������±�λ��
		//����c=2ʱ��2-'0'����ȡ�±�Ϊ2,letter_map[2]����"abc"
		int pos = c - '0';
		String map_string = letter_map[pos];
		//�����ַ����������һ�εõ�����2��ҳ���Ǳ���"abc"
		for(int i=0;i<map_string.length();i++) {
			//������һ��ݹ飬�����ֺ�������������϶�̬ͼ���
			iterStr(str, letter+map_string.charAt(i), index+1);
		}
	}
}

