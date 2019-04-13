import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;


public class simpleapplet extends Applet implements Runnable , KeyListener ,MouseMotionListener,MouseListener {
	
	private Image i;
	private Graphics doubleG;
	ball b;
	Platform p[] = new Platform[7];
	Item item[] = new Item[3];
	private int score; 
	double cityX = 0;
	double cityDx = .8;
	URL  url;
	Image city;
	int checklevel = 0;
	boolean gameOver = false;
	boolean mouseIn = false;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void init() {
	setSize(1000, 800);
	addKeyListener(this);
	addMouseMotionListener(this);
	addMouseListener(this);
	try{
		url = getDocumentBase();
	}catch(Exception e){
		
	}
	city = getImage(url, "images/game.png");
	picture p =new picture(this);
	picture.wind.play();
	picture.music.loop();
	}
	
	@Override
	public void start() {
	b =new ball();
	score = 0;
	for (int i = 0; i < p.length; i++){
		Random r =new Random();
		p[i] = new Platform( i*120 ,300 );
	}

	for (int i = 0; i < item.length; i++){
		Random r =new Random();
		switch(r.nextInt(5)){
		case 0:
			item[i] = new GravUp(getWidth() + 2000 * i   );
			break;
		case 1:
			item[i] = new GravDown(getWidth() + 2000 * i  );
			break;
		case 2:
			item[i] = new agilUp(getWidth() + 2000 * i  );
			break;
		case 3:
			item[i] = new agilDown(getWidth() + 2000 * i  );
			break;
		case 4:
			item[i] = new scoreplus(getWidth() + 2000 * i  ,this);
			break;
		}
	}
	Thread t = new Thread(this);
	t.start();
	
	}
	
	@Override
	public void run() {
		while(true){
			gameOver =b.getGameOver();
			if (checklevel > 1000){
				picture.level++;
				checklevel = 0;
			}
			checklevel++;
			
			if (cityX > getWidth() * - 1){
			cityX -= cityDx;
			}else {
				cityX = 0;
			}
			if(!gameOver){
			score++;
			}
			Random r = new Random();
			for (int i = 0; i<item.length;i++){
				if(item[i].isCreateNew() ){
					item[i] = null;
					switch(r.nextInt(5)){
					case 0:
						item[i] = new GravUp(getWidth() + 10 * r.nextInt(500));
						break;
					case 1:
						item[i] = new GravDown(getWidth() + 10 * r.nextInt(500));
						break;
					case 2:
						item[i] = new agilUp(getWidth() + 10 * r.nextInt(500));
						break;
					case 3:
						item[i] = new agilDown(getWidth() + 10 * r.nextInt(500));
						break;
					case 4:
						item[i] = new scoreplus(getWidth() + 10 * r.nextInt(500), this);
						break;
					}
					item[i].setCreateNew(false);
				}	
			}
				b.update(this);
				for (int i = 0; i<p.length;i++){
					p[i].update(this,b);	
				}
				for (int i = 0; i<item.length;i++){
					item[i].update(this,b);	
				}
				repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	@Override
	public void stop() {
	
	
	}
	
	@Override
	public void destroy() {
	
	
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (i == null){
		i = createImage(this.getSize().width,this.getSize().height);
		doubleG =  i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0,this.getSize().width,this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i,0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
	g.setColor(new Color(15,77,147));
	g.fillRect(0, 0,getWidth(), getHeight());
	g.drawImage(city,(int) cityX, 0, this);
	g.drawImage(city,(int) cityX + getWidth(), 0, this); // tell mapping is done here
	 
	for (int i = 0; i<p.length;i++){
		p[i].paint(g);	
	}

	for (int i = 0; i<item.length;i++){
		item[i].paint(g);	
	}
	b.paint(g);
	String s = Integer.toString(score);
	Font font = new Font("Serif", Font.BOLD, 25);
	g.setFont(font);
	g.setColor(Color.BLACK);
	g.drawString(s,getWidth()-150+2 , 50+2);
	g.setColor(new Color(198,226,255));
	g.drawString(s,getWidth()-150 , 50);
	if (gameOver){
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 400, 400);
		//mouse check
		g.drawRect(390, 430, 160, 40);
		if(mouseIn){
			g.setColor(Color.RED);
			g.drawString("Play Again...??", 390, 455);
		}else{
			g.setColor(Color.WHITE);
			g.drawString("Play Again...??", 390, 455);
		}
	
	}
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			b.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			b.moveRight();
			break;
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getX() > 390 && e.getX() < 500){
			if(e.getY() > 430  && e.getY() < 470){
				mouseIn = true;
			}
		}
		if(e.getX () < 390 ||  e.getX() > 500){
			
				mouseIn = false;
			
		}
		if(e.getY () < 430 ||  e.getY() > 470){
			
			mouseIn = false;
		
	}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mouseIn){
			b = null ;
			b = new ball();
			score = 0;
			picture.level++;
			for (int i = 0; i < p.length; i++){
				Random r =new Random();
				p[i] = new Platform( i*120 ,300 );
			}

			for (int i = 0; i < item.length; i++){
				Random r =new Random();
				switch(r.nextInt(5)){
				case 0:
					item[i] = new GravUp(getWidth() + 2000 * i   );
					break;
				case 1:
					item[i] = new GravDown(getWidth() + 2000 * i  );
					break;
				case 2:
					item[i] = new agilUp(getWidth() + 2000 * i  );
					break;
				case 3:
					item[i] = new agilDown(getWidth() + 2000 * i  );
					break;
				case 4:
					item[i] = new scoreplus(getWidth() + 2000 * i  ,this);
					break;
				}
			}
			mouseIn = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

