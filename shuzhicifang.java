public class Solution {
    public double Power(double base, int exponent) {
         
        //����exponent��int���͵�����������ܰ�����������0�Լ����������������
        double temp=1;
        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                temp=temp*base;
                if(temp>1.7976931348623157E308){
                    System.out.println("�Ѿ�����double���͵�ȡֵ��Χ��");
                    return -1;
                }
            }
            return temp;
             
        }if(exponent<0){
            exponent=-exponent;
            for(int i=1;i<=exponent;i++){
                temp=temp*base;
                if(temp>1.7976931348623157E308){
                    System.out.println("�Ѿ�����double���͵�ȡֵ��Χ��");
                    return -1;
                }
            }
            temp=1.0/temp;
            return temp;
        }else{
            return 1;
        }
         
  }
}