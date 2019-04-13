import java.awt.Color;
import java.awt.Graphics;


public class agilDown extends Item {

	public agilDown(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		super.paint(g);
	}
	public void performAction(ball b){
		if (b.getAgility() >= 2){
		b.setAgility(b.getAgility() - 1);
		
		}
	}

}
