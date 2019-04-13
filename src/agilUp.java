import java.awt.Color;
import java.awt.Graphics;


public class agilUp extends Item {

	public agilUp(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GRAY);
		super.paint(g);
	}
	public void performAction(ball b){
		if (b.getAgility() < 8){
		b.setAgility(b.getAgility() + 1);
		
		}
	}

}
