import java.util.Arrays;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
			Scanner sca=new Scanner(System.in);
			String s=sca.next();
			String str="";
			int[] a=new int[s.length()];
			for(int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if(a[i]==1) {
					continue;
				}
				if(c=='(') {
					boolean bo=true;
					if(i-1>=0) {
						if(s.charAt(i-1)=='*' || s.charAt(i-1)=='/' ) {  //�ж�������ǰ�Ƿ��г˳�
							bo=false;
						}
					}
					if(!bo) {
						continue;
					}
					int index=i+1;
					int zuo=0;
					boolean jian=true;
					if(i-1>=0) {
						if(s.charAt(i-1)=='-') {  
							jian=false;
						}
					}
					while(true) {    //�ҵ�ƥ���������
						if(!jian && s.charAt(index)=='+') {  //�ж���������-ʱ����������û��+
							bo=false;
							break;
						}
						if(s.charAt(index)==')' && zuo==0) {
							break;
						}
						if(s.charAt(index)=='(') {
							zuo++;
						}
						if(s.charAt(index)==')') {
							zuo--;
						}
						index++;
					}
					if(!bo) {
						continue;
					}
					boolean bo2=true;
					if(index+1<s.length()) {
						if(s.charAt(index+1)=='*' || s.charAt(index+1)=='/') {  //�ж��������ұ��Ƿ��г˳�
							bo2=false;
						}
					}
					if(bo2) {   //��¼����ɾ��������λ��
						a[i]=1;
						a[index]=1;
					}
				}
			}
			for(int i=0;i<s.length();i++) {
				if(a[i]==0) {
					str+=s.charAt(i);
				}
			}
			System.out.println(str);
		}
	}
	
