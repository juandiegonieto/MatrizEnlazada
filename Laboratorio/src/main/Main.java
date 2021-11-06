package main;

import model.Table;

public class Main {

	public static void main(String[] args) {
		
		Table table = new Table(5, 6,"qsrt");
		
		String[] playerNames = {"S","H","B"};
		table.createPlayer(playerNames, playerNames.length, 0);
		for(int i=0; i<playerNames.length; i++) {
			System.out.println(playerNames[i]);
		}
		
		table.printList();
		table.asignaPlayer();
	}

}
