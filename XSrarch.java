public class XSearch{
public static int xSerach(int arr[],int i,int r,int x){
if(r > 1){
int mid = 1+(r-1)/2;//�м�ֵ
  if(arr[mid] == x)
    return mid;
  if(mid > 1 && arr[mid - 1] == x)
    return (mid - 1);
  if(mid < r && arr[mid + 1] == x)
    return (mid + 1);
  if(arr[mid] > x)return xSearch(arr , i, mid - 1, x);//Ӧ��-2 
  if(arr[mid] < x)return xSearch(arr, mid + 1, r, x);
}
  return -1;
  }
  public static void main(String[] args){
    int arr[] = {3, 4, 5, 6, 7, 1, 2};
    int n = arr.length;
    int x = 7;
    int result = xSearch(arr, 0, n-1, x);
    if(result == -1)
      System .out .println("����û�����");
    else
      System.out.println("�����±�Ϊ"+result);
  }