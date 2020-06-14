import java.util.*;
public class GrayCode {
    public String[] getGray(int n) {
        int m = 1<<n;
		String[] r = new String[m];
		if(n==1){
			r[0] = "0";
			r[1] = "1";
			return r;
		}
		String[] temp = getGray(n-1);
		int j = 0;
		for(int i = 0;i<m;i++){
			if(i<m/2){
				r[i] = "0"+temp[j++];
			}else{
				r[i] = "1"+temp[--j];
			}
		}
		return r;
    }
}