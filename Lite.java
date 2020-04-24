public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = Merge(list1,list2.next);
        }
        return pMergeHead;
    }
}