import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class scoreplus extends Item {

	private simpleapplet appletInfo;
	public scoreplus(int x, simpleapplet appletInfo) {
		super(x);
		// TODO Auto-generated constructor stub
		this.appletInfo = appletInfo;
	}
	public void performAction(ball b){
		Random r = new Random();
		appletInfo.setScore(appletInfo.getScore() + 500 + r.nextInt(2000));
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.MAGENTA);
	}

}
