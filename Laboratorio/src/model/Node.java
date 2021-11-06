package model;

public class Node {
	
	//values
	private int id;
	private Player p;
	
	//links
	private Node next;
	private Node prev;

	public Node(int id, Player p) {
		this.id = id;
		this.p = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "[" + id + ", " + p + "] ";
	}
	
	
	
}
