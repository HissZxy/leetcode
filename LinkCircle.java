public class link{

	public static class LinkedList{
		int data;
		LinkedList next;
	public LinkedList(int data){
		this.data = data;
        this.next = null;
        }
     }
     
     public static LinkedList Circle(LinkedList head){
     if(head == null){//先判断头为空?
     return null;
     }
     LinkedList q1 = head;//第一个走一步
     LinkedList q2 = head;//第二个走两步
     if(q2 != null){
       q2 = q2.next.next//第二个要比第一个快一步;
       }else{
       return null;
       }
       q1 = q1.next;//
       while(q1 != q2){
       if(q2 != null && q2.next != null){   //q2 遇到null  则说明 不存在环
       q2 = q2.next.next;
       }else{
       return null;
       }
       q1 = q1.next;
       }
       
       while(head != q1){
       q1 = q1.next;
       head = head.next;//有环 二者定会见面
       }
       }
     

