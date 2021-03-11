package escaperoom;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;			//나중에 곡을 바꿀때 사용됨
		player.close();			//
		this.interrupt();		//곡을 종료해주는거 쓰레드로 튼거를
	}
	
	@Override
	public void run() {		//쓰레드 쓸때 꼭 써야되는거
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		}
}
