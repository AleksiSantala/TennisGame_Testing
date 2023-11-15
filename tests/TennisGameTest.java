import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score=game.getScore();
		
		assertEquals("End score incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins_4_to_1() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score=game.getScore();
		
		assertEquals("End score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins_4_to_2() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score=game.getScore();
		
		assertEquals("End score incorrect", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score=game.getScore();
		
		assertEquals("Score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage_5_to_4() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		
		String score=game.getScore();
		
		assertEquals("Score incorrect", "player2 has advantage", score);
	}
	@Test
	public void testTennisGame_Player2HasAdvantage_4_to_3() throws TennisGameException{
		TennisGame game=new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		String score=game.getScore();
		
		assertEquals("Score incorrect", "player2 has advantage", score);
	}
	@Test
	public void testTennisGame_EachPlayerWin1Point_Score_15_15() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		String score = game.getScore() ;
		assertEquals("Score incorrect", "15 - 15", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin2Points_Score_30_30() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		assertEquals("Score incorrect", "30 - 30", score);		
	}
	@Test
	public void testTennisGame_Score_40_30() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		String score = game.getScore() ;
		assertEquals("Score incorrect", "30 - 40", score);		
	}
	@Test
	public void testTennisGame_EahcPlayerWin3Points_Score_Deuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore() ;
		assertEquals("Tie score incorrect", "deuce", score);		
	}
}
