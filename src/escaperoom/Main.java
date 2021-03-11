package escaperoom;

public class Main {
	public static final int SCREEN_WIDETH = 1280;	//처음 창 세로화면
	public static final int SCREEN_HEIGHT = 720;	//처음 창 가로화면
	public static final int HSCREEN_WIDETH = 450;
	public static final int HSCREEN_HEIGHT = 300;
	public static final int PWSCREEN_WIDETH = 400;
	public static final int PWSCREEN_HEIGHT = 150;
	
	public static String password;
	
	static EscapeRoomMain escaperoom;
	
	public static void main(String[] args) {
		escaperoom = new EscapeRoomMain();
	}

}
