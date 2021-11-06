package model;

public class Table {
	
	private Node first;
	private Node last;
	private Player firstPlayer;
	
	private int n, m;
	private String player;
	
	public Table(int n, int m,String player) {
		this.n = n;
		this.m = m;
		int numTabla=n*m;
		int i=0;
		createTable(numTabla, i);
		String[] campoPlayer=player.split("");
		int valPLayer=campoPlayer.length;
		createPlayer( campoPlayer, valPLayer, i);
		
	}
	
	/* Create a new player 
	 * <b> Pre: 
	 *  @Param playerNames
	 *  @Param playersAmount
	 *  @Param j counter  
	 *  </b>
	 */
	public void createPlayer(String[] playerNames,int playersAmount,int j) {
		if(playersAmount>0) {
			Player nodePlayer = new Player(playerNames[j],1);
			playerPos(nodePlayer);
			createPlayer(playerNames, playersAmount-1, j+1);
		}
	}
	
	public void createTable(int num,int i) {
		if(num>0) {
			Node node = new Node(i+1, null);
			addLast(node);
			createTable(num-1,i+1);
		}
		
	}

	public void addLast(Node node) {
		if(first == null) {
			first = node;
			last = first;
		} else {
			Node penultimo = last;
			last = node;
			penultimo.setNext(node);
			node.setPrev(penultimo);
		}
	}
	
	public void printList() {
		Node node = last;
		int i=0;
		
		for( i=0; i<n; i++) {
			String row="";
			if(i % 2==0) {
				for(int j=0; j<m; j++) {
					row=node.toString()+row;
					node = node.getPrev();
				}
			}else  {
				for(int j=0; j<m; j++) {
					row=row+node.toString();
					node = node.getPrev();
				}
			}
			System.out.print(row);
			System.out.println("\n");
		}
	}
	public String printlnList(int i,String row) {
		if(i<n) {
			if(i % 2==0) {
				for(int j=0; j<m; j++) {
					row=last.toString()+row;
					last = last.getPrev();
				}
				
			}else  {
				for(int j=0; j<m; j++) {
					row=row+last.toString();
					last = last.getPrev();
				}
			}
			return printlnList( i++, row);
		}else {
			return row;
		}
	}
	
	public void playerPos(Player py) {
		if(firstPlayer == null) {
			firstPlayer = py;
		} else {
			Player penultimo = py;
			penultimo.setNext(firstPlayer);
		}if(py.getNext()==null) {
			py.setNext(firstPlayer);
		}
	}
	
	public int dado() {
		int resultados = (int)(Math.random()*6 + 1); 
		return resultados;
	}
	
	public Node initCambioPLayer(Player py) {
        Node tempo = first;

        while (tempo!=null && tempo.getP()!=py) {
            tempo = tempo.getNext();
        }
        return tempo;
    }

    public void rotateOfPlayer(int newPisicion, Node posicion,Player py) {
        Node tempo =  first;
        while (tempo!=null &&  tempo.getId()!=(posicion.getId()+newPisicion) ) {
            tempo = tempo.getNext();
        }
        tempo.setP(py);
        posicion.setP(null);
    }


    public void AddNamePlayer(String[] namePlayer) {
        Player tempo =  firstPlayer;
        int i=0;
        while (tempo!=null && namePlayer[i]!=null) {
            tempo.setId(namePlayer[i]);
            tempo = tempo.getNext();
            i++;
        }
    }

    public Player PlayerOn(String py) {
        Player tempo = firstPlayer;

        while (tempo!=null && tempo.getId().equals(py)) {
            tempo = tempo.getNext();
        }
        return tempo;
    }
	
    public void asignaPlayer() {
        Player tempo = firstPlayer;
        Node tempoNode = first;
        while (tempo!=null) {
            while (tempoNode!=null) {
                if(tempo.getPosition()==tempoNode.getId()) {
                    tempoNode.setP(tempo);
                }
                tempoNode = tempoNode.getNext();
            }
            tempo = tempo.getNext();
        }
    }
}
