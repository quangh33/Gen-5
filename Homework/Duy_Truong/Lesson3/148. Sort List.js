/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if(!head || !head.next) return head;
    
    let fast=head.next.next,slow=head;
    
    while(fast && fast.next){
        fast=fast.next.next;
        slow=slow.next;
    }
    
    const mid=slow.next;
    slow.next=null;
    
    let left = sortList(head);
    let right = sortList(mid);
    
    return merge(left,right);
};

function merge(left,right){
	let dummy = new ListNode();
	const headPtr = dummy;
	while(left && right){
		if(left.val < right.val){
			dummy.next = left;
			left = left.next
		} else{
			dummy.next = right;
			right = right.next;
		}
		dummy = dummy.next;
	}
	dummy.next = (right) ? right : left
	return headPtr.next;

}