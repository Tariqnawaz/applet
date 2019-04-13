import java.awt.Color;
import java.awt.Graphics;


public class ball {
	
private double gravity    = 15;
private double energyloss = 1;
private double xFriction  = .9;
private double dt         =.2;
private int x             =400;
private int y             =25;
private double dx         =0;
private double dy         =0;
private double gameDy	  =-85;
private int radius        =20;
private int agility = 3 ;
private int maxSpeed = 20;
private boolean game_over =false;

public ball() {
	// TODO Auto-generated constructor stub
}

public ball(int i, int j) {
	// TODO Auto-generated constructor stub
	x = i;
	y = j; 
	
}
public double getGameDy() {
	return gameDy;
}
public void setGameDy(double gameDy) {
	this.gameDy = gameDy;
}
public int getRadius() {
	return radius;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}

public double getDx() {
	return dx;
}
public void setDx(double dx) {
	this.dx = dx;
}

public double getDy() {
	return dy;
}
public void setDy(double dy) {
	this.dy = dy;
}

public double getGravity() {
	return gravity;
}
public void setGravity(double gravity) {
	this.gravity = gravity;
}
public int getAgility() {
	return agility;
}

public void setAgility(int agility) {
	this.agility = agility;
}

public int getMaxSpeed() {
	return maxSpeed;
}

public void setMaxSpeed(int maxSpeed) {
	this.maxSpeed = maxSpeed;
}


public void moveRight(){
	if(dx + agility < maxSpeed){
		dx += agility;
	}
}
public void moveLeft(){
	if (dx - agility > -maxSpeed){
		dx -= agility;
	}
}

public void update(simpleapplet sa){
	if (x + dx > sa.getWidth()-radius-1 ){
		x = sa.getWidth()-radius-1;
		dx = -dx;
	}else if(x + dx < 0 + radius){
		x = 0 + radius;
		dx = -dx;
	}
	else{
		x += dx;
	}
	
	if (y == sa.getHeight()-radius-1 ){
		dx *= xFriction;
		if(Math.abs(dx) < .8){
			dx = 0;
		}
	}
		if( y-200 > sa.getHeight()-radius-1){
			game_over =true;
			/*y = sa.getHeight()-radius-1;
			dy *= energyloss;
			dy = gameDy;*/
	}else {
		//velocity formula
		dy += gravity * dt;
		// position formula
		y += dy * dt +.5 * gravity * dt * dt;
	}	

}

public void paint(Graphics g){
	g.setColor(Color.GREEN);
	g.fillOval(x-radius, y-radius, radius*2, radius*2);
	
	
}

public boolean getGameOver() {
	// TODO Auto-generated method stub
	return game_over;
}
}
