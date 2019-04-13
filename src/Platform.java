import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;


public class Platform {
	
	int dx;
	int x , y , width, height;
	Image plate;
	URL url;
	
	public Platform() {
		dx  = -1;
		x   = 450;
		y   = 300;
		width =120;
		height = 40;
		plate =picture.platForm;
	}
	

	public Platform(int x, int y) {
		dx = -1;
		this.x = x;
		this.y = y;
		width =120;
		height = 40;
		plate =picture.platForm;
	}
	
	
	public void update(simpleapplet sa , ball b){
		x += - (picture.level);
		checkForCollision(b);
		if(x < 0 - width){
			Random r = new Random();
			y = sa.getHeight() + 40 - r.nextInt(400);
			x = sa.getWidth() + r.nextInt(300);
		}
	}
	private void checkForCollision(ball b) {
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		
		if(ballY + radius > y && ballY + radius < y + height){
			if (ballX + radius > x && ballX + radius < x + width){
			double newDY = b.getGameDy() ;
			b.setY(y-radius);
			b.setDy(newDY);
			picture.bounce.play();
			}
		}
		
		
	}

	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		//g.drawImage(plate , x, y,picture.sa);
		g.drawImage(plate, x, y, x + width, y + height, 0, 0, 138, 55, picture.sa);
	}

}
