package Source;

import java.io.Serializable;

public class MyList<T> implements Serializable {
	Node<T> head;
	Node<T> tail;
	
	public MyList() {
		head=tail=null;
	}

	 /**

	  * Checking if this list is empty

	  *

	  * @return true if list is empty

	  */

	 public boolean isEmpty() {
		 return (head==null);
	 }

	 

	 /**

	  * Returning the length of this list

	  *

	  * @return The length of this list

	  */

	 public int length() {
		 int a = 0;
		 Node<T> curr = this.head;
		 while(curr.next!=null) {
			 a++;
			 curr = curr.next;
		 }
		 return a;
	 }

	 public void addToTail(T item) {
		 Node newN = new Node<T>(item);
		 boolean check = this.isEmpty();
		 if(check) {
			 this.head = newN;
			 this.tail = newN;
		 }else {
			 Node<T> curren = this.tail.next;
			 while(curren != null) {
				 curren = this.tail.next;
			 }
			 this.tail.next = newN;
			 this.tail = newN;
			 
		 }
	 }

	 
	 /**

	  get node in position

	  */

	 public Node<T> getNode(int position) {
		 int n = this.length();
		 Node<T> cur = this.head;
		for(int i = 0; i<n ; i++) {
			 if(i == position) {
				 break;
			 }
			 cur = cur.next;
		 }
		 return cur;
	 }

	 

	 /**

	  * Deleting the head of this list

	  */

	 public void deleteHead() {
		 this.head = this.head.next;
	 }

	 

	 /**

	  * Searching and deleting an item from this list by comparing the ID of items

	  *

	  * @param item The item to be deleted

	  */

	 public void deleteElement(T item) {
		 boolean check = this.isEmpty();
		 Node finder = new Node<T>(item);		
		 if(this.head.info.equals(finder.info)) {
			 this.head = this.head.next;
		 }else {
			 Node find = this.head;
			 while(find.next != null && !find.next.info.equals(finder.info)) {
				 find = find.next;
			 }
			 find.next = find.next.next;
		 }
		 
	 }

	 

	 /**

	  * Swaping two nodes [firstNode] and [secondNode]

	  *

	  * @param firstNode

	  * @param secondNode

	  */

	 public void swap(Node<T> firstNode, Node<T> secondNode) {
		 Product temp = (Product) firstNode.info;
		 firstNode.info = secondNode.info;
		 secondNode.info = (T) temp;
	 }

	 

	 /**

	  * Deleting all items in the list

	  */

	 public void clear() {
		 this.head= this.tail = null;
	 }

	 
	
}
