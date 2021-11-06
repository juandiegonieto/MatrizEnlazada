package model;

public class Player {

	private String id;  
	private int position;
	
	//links
	private Player next;

	/**
	 * @param id
	 */
	public Player(String id,int position) {
		super();
		this.id = id;
		position=1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
