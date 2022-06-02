package Source;

import java.io.Serializable;

public class Node<T> implements Serializable{
	T info;
	Node next = null;
	public Node(T info) {
		this.info = info;
	}
	
	public Node(T info, T next) {
		this.info = info;
		this.next = (Node<T>)next;
	}
	
	@Override
	public String toString() {
		return (this.info+"\n");
	}
}
