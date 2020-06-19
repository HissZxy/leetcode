public class Main {
    public static void main(String[] args) {
        int j=1;
        int sumM=0;//富翁--万元
        int sumN=0;//陌生人--分 
        for(int i=0;i<30;i++){
            sumM=sumM+10;
            sumN=sumN+j;
            j=j*2;//陌生人每天拿到手的钱数--1 2 4 8...  呈现2的n次方规律
        }
        System.out.println(sumM+" "+sumN);
    }
}