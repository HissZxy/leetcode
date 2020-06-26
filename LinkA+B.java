import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode resultHead = new ListNode(-1);
        ListNode resultCurrent = resultHead;
        int addToNextDight = 0;
        while(a != null || b != null || addToNextDight != 0){
            int aval = a != null ? a.val : 0;
            int bval = b != null ? b.val : 0;
            int sum = aval + bval + addToNextDight;
            int nodeDigit = sum % 10;
            addToNextDight = sum / 10;
            resultCurrent.next = new ListNode(nodeDigit);
            resultCurrent = resultCurrent.next;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return resultHead.next;
}