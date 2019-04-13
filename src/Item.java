import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {
	
	private simpleapplet sa ;
	private int x , y , dx , radius;
	private boolean createNew = false;
	
	public boolean isCreateNew() {
		return createNew;
	}

	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

	public Item(int x) {
		// TODO Auto-generated constructor stub
		this.x= x;
		Random r = new Random();
		y = r.nextInt(400) + radius;
		dx = -2;
		radius = 10;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	
	public void update(simpleapplet sa , ball b){
		x += dx;
		this.sa =sa;
		checkForCollision(b);
		if(x < 0 - radius){
			createNew = true;
		}
	}
	private void checkForCollision(ball b) {
		int ballX = b.getX();
		int ballY = b.getY();
		int ballR = b.getRadius();
		
		int a = x - ballX;
		int bb = y - ballY;
		int collide = radius + ballR;
		
		double c = Math.sqrt((double)(a*a ) + (double)(bb*bb));
		
		if (c < collide){
			performeAction(b);
			createNew =true;
		}
	}

	private void performeAction(ball b) {
		// TODO Auto-generated method stub
		
	}
	public void paint(Graphics g){
		//g.setColor(Color.RED);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}

}
