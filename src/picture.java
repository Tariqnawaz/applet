import java.awt.Image;
import java.net.URL;
import java.applet.AudioClip;

public class picture {
static Image platForm;
 URL url;
 static simpleapplet sa;
 static AudioClip music ,wind,bounce;
 static int level = 1;
 
	public picture(simpleapplet sa) {
		// TODO Auto-generated constructor stub
		try{
			url =sa.getDocumentBase();
		}catch(Exception e){
			
		}
		wind = sa.getAudioClip(url,"music/thunder.au");
		music = sa.getAudioClip(url,"music/music.au");
		bounce = sa.getAudioClip(url,"music/jump.au");
		platForm =sa.getImage(url, "images/form.png");
		this.sa = sa;
		}
	}

