public class XSearch{
public static int xSerach(int arr[],int i,int r,int x){
if(r > 1){
int mid = 1+(r-1)/2;//中间值
  if(arr[mid] == x)
    return mid;
  if(mid > 1 && arr[mid - 1] == x)
    return (mid - 1);
  if(mid < r && arr[mid + 1] == x)
    return (mid + 1);
  if(arr[mid] > x)return xSearch(arr , i, mid - 1, x);//应该-2 
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
      System .out .println("数组没这个数");
    else
      System.out.println("数字下标为"+result);
  }