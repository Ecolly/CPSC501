import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Game {
    List<Player> players = new ArrayList<>(); //creates a list of players with attrb
	    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
        
    public  Game(){

    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public void add(String playerName) {
		Player player = new Player(playerName); //player class make a new player
	    players.add(player); //adds to general list to keep track of
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll, Player play) {
		//does the checks based on the play (who is calculated to be current player elsewhere)
		System.out.println(play.getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (play.getinPenaltyBox()) {
			if (roll % 2 != 0) { //if rolls even, then gets out of box
				play.setinPenaltyBox(false);
				System.out.println(play.getName() + " is getting out of the penalty box");
				play.setLocation(roll);
				if (play.getLocation() > 11) play.setLocation(-12); //if the player goes out of 11 bonds, then reset them back at 0
				
				System.out.println(play.getName() 
						+ "'s new location is " 
						+ play.getLocation());
				System.out.println("The category is " + currentCategory(play));
				askQuestion(play);
			} else { //if roll odd, then doesn't get out of box
				System.out.println(play.getName() + " is not getting out of the penalty box");
				play.setinPenaltyBox(false);
				}
			
		} else { //if players is not in the box
			play.setLocation(roll);
			if (play.getLocation() > 11) play.setLocation(-12); 
			
			System.out.println(play.getName() 
					+ "'s new location is " 
					+ play.getLocation());
			System.out.println("The category is " + currentCategory(play));
			askQuestion(play);
		}
		
	}

	private void askQuestion(Player c) {
		if (currentCategory(c) == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory(c) == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory(c) == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory(c) == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory(Player c) {
		if (c.getLocation() == 0) return "Pop";
		if (c.getLocation() == 4) return "Pop";
		if (c.getLocation() == 8) return "Pop";
		if (c.getLocation() == 1) return "Science";
		if (c.getLocation() == 5) return "Science";
		if (c.getLocation() == 9) return "Science";
		if (c.getLocation() == 2) return "Sports";
		if (c.getLocation() == 6) return "Sports";
		if (c.getLocation() == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered(Player play) {
		if (play.getinPenaltyBox()){ //check to see if player is in penality
			if (play.getinPenaltyBox()) { 
				System.out.println("Answer was correct!!!!");
				play.setPurse(1);
				System.out.println(play.getName() 
						+ " now has "
						+ play.getPurse()
						+ " Gold Coins.");
				boolean winner = play.didPlayerWin();
				System.out.println(winner);
				return winner;
			} else {
				return true;
			}
			
		} else {
			System.out.println("Answer was correct!!!!");
			play.setPurse(1);
			System.out.println(play.getName()
					+ " now has "
					+ play.getPurse()
					+ " Gold Coins.");
			boolean winner = play.didPlayerWin();	
			System.out.println(winner);		
			return winner;
		}
	}
	
	public boolean wrongAnswer(Player play){
		System.out.println("Question was incorrectly answered");
		System.out.println(play.getName() + " was sent to the penalty box");
		play.setinPenaltyBox(true);
		return true;
	}


	
}
