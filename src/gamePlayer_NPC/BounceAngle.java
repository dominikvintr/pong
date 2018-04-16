package gamePlayer_NPC;

import gameCore.GameClass;
/**
 * UNUSED CLASS
 * @author dominikvintr
 *
 */
public class BounceAngle {
	
	//private static int gameHeight = GameClass.HEIGHT;
	private static int deskHeight = Opponent.getBasicHeight();
	private static int oneDeskSection = Opponent.getBasicHeight()/11;
	private static int ballCenter = Ball.getHeight()/2;
	
	private static int Y;
	
	public static int Y(int ballY, int deskY) {
		int section = deskY + deskHeight - ballY + ballCenter;
		
		if (section <= oneDeskSection) {
			Y = -10;
		} else if (section <= oneDeskSection*2) {
			Y = -7;
		} else if (section <= oneDeskSection*3) {
			Y = -4;
		}else if (section <= oneDeskSection*4) {
			Y = -2;
		}else if (section <= oneDeskSection*5) {
			Y = -1;
		}else if (section <= oneDeskSection*6) {
			Y = 0;
		}else if (section <= oneDeskSection*7) {
			Y = 1;
		}else if (section <= oneDeskSection*8) {
			Y = 2;
		}else if (section <= oneDeskSection*9) {
			Y = 4;
		} else if (section <= oneDeskSection*10) {
			Y = 7;
		} else {
			Y = 10;
		}
	return Y;
	}
}
