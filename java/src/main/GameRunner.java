import java.util.Random;


public class GameRunner {

	private static boolean notAWinner;
	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		int currentPlayer = 0;
		Random rand = new Random();

	
		do {
			Player current = aGame.players.get(currentPlayer);
			aGame.roll(rand.nextInt(5) + 1,current);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer(current);
				currentPlayer++;
				if (currentPlayer == aGame.players.size()) currentPlayer = 0;
			} else {
				notAWinner = aGame.wasCorrectlyAnswered(current);
				currentPlayer++;
				if (currentPlayer == aGame.players.size()) currentPlayer = 0;
			}
		} while (notAWinner);
		
	}
}
