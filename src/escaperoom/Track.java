package escaperoom;

public class Track {

	private String startImage;
	private String gameImage;
	private String startMusic;
	private String gameMusic;
	private String hintImage;
	private String password;

	public Track(String startImage, String gameImage, String startMusic, String gameMusic, String hintImage,
			String password) {
		super();

		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.hintImage = hintImage;
		this.password = password;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}

	public String getHintImage() {
		return hintImage;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHintImage(String hintImage) {
		this.hintImage = hintImage;
	}

}