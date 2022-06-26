package escaperoom;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class EscapeRoomMain extends JFrame {

	Hint hint_gui;
	
	private Image screenImage; // ���ۿ� �������ؼ�
	private Graphics screenGraphic; // ���ۿ� �������ؼ� ���۸� ���������� �����Ÿ� �߻�

	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage(); // �̹�����
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	
	private ImageIcon gamestartButtonBasicImage = new ImageIcon(Main.class.getResource("../images/gamestartButtonBasic.png"));
	private ImageIcon gamestartButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/gamestartButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	private ImageIcon hintButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hintButtonBasic.png"));
	private ImageIcon hintButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hintButtonEntered.png"));
	
	private ImageIcon passwordButtonImage = new ImageIcon(Main.class.getResource("../images/passwordImage.png"));
	
	private static ImageIcon outdoorButtonImage = new ImageIcon(Main.class.getResource("../images/outdoorButtonImage.png"));
	
	private ImageIcon clearButtonImage = new ImageIcon(Main.class.getResource("../images/clearButtonImage.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton gamestartButton = new JButton(gamestartButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton hintButton = new JButton(hintButtonBasicImage);
	private JButton passwordButton = new JButton(passwordButtonImage);
	static JButton outdoorButton = new JButton(outdoorButtonImage);
	private JButton clearButton = new JButton(clearButtonImage);
	
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	public static ArrayList<Track> trackList = new ArrayList<Track>();
	
			
	private Image selectedImage;// = new ImageIcon(Main.class.getResource("../images/�־��Ǽ��� Start Image.png")).getImage(); 
	private Image titleImage;// = new ImageIcon(Main.class.getResource("../images/�־��Ǽ��� Title Image.png")).getImage();									
//	Music intromusic = new Music("intromusic.mp3", true);
//	private Music selectedMusic;
	public static int nowSelected = 0;	//���缱�õ� �� ��ȣ
	
	public EscapeRoomMain() {
		setUndecorated(true);
		setTitle("Escape Room"); // �� â�� �߸� â ���� ǥ�õǴ� �̸�
		setSize(Main.SCREEN_WIDETH, Main.SCREEN_HEIGHT);
		setResizable(false); // â�� ������ ����ڰ� ���̷� âũ�� ���� �Ұ�
		setLocationRelativeTo(null); // â�� ���߾ƿ� �ߴ°�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		
//		intromusic.start();
		
		trackList.add(new Track("Step1 Start Image.png", "EscapeRoom Game Image.jpg", 
				"�ｺ�� Game Music.mp3", "Raging Streets - SefChol.mp3","hintImage.jpg","500"));
		trackList.add(new Track("Step2 Start Image.png", "EscapeRoom Game Image2.png",
				"�ｺ�� Game Music.mp3", "Raging Streets - SefChol.mp3","hintImage2.png","60"));
		
		
		
		exitButton.setBounds(1245, 0, 30, 30);							//���� �����°� ������ ���� ��ư
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {	//���콺�� �̹����� �������
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {		//���콺�� �̹������� �������� ��
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {	//���콺�� Ŭ���ҋ�
				System.exit(0);
				
			}
			
		});
		add(exitButton);
		
		startButton.setBounds(440, 250, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusable(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
//			intromusic.close();			
			enterMain();
			}
		});

		add(startButton);
				
		quitButton.setBounds(440, 380, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusable(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 250, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusable(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
				//���ʹ�ư �̺�Ʈ
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 250, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusable(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
				//�����ʹ�ư �̺�Ʈ
			}
		});

		add(rightButton);
		
		gamestartButton.setVisible(false);
		gamestartButton.setBounds(515, 370, 250, 67);
		gamestartButton.setBorderPainted(false);
		gamestartButton.setContentAreaFilled(false);
		gamestartButton.setFocusable(false);
		gamestartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gamestartButton.setIcon(gamestartButtonEnteredImage);
				gamestartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				gamestartButton.setIcon(gamestartButtonBasicImage);
				gamestartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "gamestart");
			}
		});

		add(gamestartButton);
		
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusable(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});

		add(backButton);
		
		hintButton.setVisible(false);
	      hintButton.setBounds(1220, 40, 60, 60);
	      hintButton.setBorderPainted(false);
	      hintButton.setContentAreaFilled(false);
	      hintButton.setFocusable(false);
	      hintButton.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseEntered(MouseEvent e) {
	            hintButton.setIcon(hintButtonEnteredImage);
	            hintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	         }

	         @Override
	         public void mouseExited(MouseEvent e) {
	            hintButton.setIcon(hintButtonBasicImage);
	            hintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	         }

	         @Override
	         public void mousePressed(MouseEvent e) {
	            hint_gui = new Hint(trackList.get(nowSelected).getHintImage());
	         }
	      });

	      add(hintButton);
		
		passwordButton.setVisible(false);
		passwordButton.setBounds(790, 250, 140, 110);
		passwordButton.setBorderPainted(false);
		passwordButton.setContentAreaFilled(false);
		passwordButton.setFocusable(false);
		passwordButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {						
				Password password = new Password();			
			}	
		});
		add(passwordButton);
		
		outdoorButton.setVisible(false);
		outdoorButton.setBounds(345, 150, 477, 523);
		outdoorButton.setBorderPainted(false);
		outdoorButton.setContentAreaFilled(false);
		outdoorButton.setFocusable(false);
		outdoorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clearButton.setVisible(true);
			}
		});
		add(outdoorButton);
		
		clearButton.setVisible(false);
		clearButton.setBounds(440, 100, 400, 50);
		clearButton.setBorderPainted(false);
		clearButton.setContentAreaFilled(false);
		clearButton.setFocusable(false);
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					backMain();
			}
		});
		add(clearButton);
		
				
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {		//���콺�� �޴��ٸ� ������ ���콺�� ��ġ�� �����Ѵ�.
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {	//���� �޴��ٸ� ������ â�� ������ �� �ְ� �ϴ� ��
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation( x - mouseX, y - mouseY);
		}
		});
		add(menuBar);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDETH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);	//�ܼ� �̹����� ����� �� �̿�
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 50, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			//g.drawImage(gameInfoImage, 650, 250, null);
		}	
			
		paintComponents(g); // jfame�� jlabel�� �߰��� �ִ°��� �ǹ��Ѵ�.
		this.repaint();

	}
	
	public void selectTrack(int nowSelected) {
//		if(selectedMusic != null)
//			selectedMusic.close();
		
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
//		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
//		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected =  trackList.size() - 1;
		}else nowSelected --;
		selectTrack(nowSelected);
			}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected =  0;
		}else nowSelected ++;
		selectTrack(nowSelected);
			}
	
	public void gameStart(int nowSelected, String difficulty) {
//		if(selectedMusic != null)
//		selectedMusic.close();
//		
//		selectedMusic = new Music(trackList.get(nowSelected).getGameMusic(), true);
//		selectedMusic.start();
		
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		gamestartButton.setVisible(false);
		
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage(); // �̹�����
		backButton.setVisible(true);
		hintButton.setVisible(true);
		
		passwordButton.setVisible(true);
		
		isGameScreen = true;
		
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		gamestartButton.setVisible(true);
		clearButton.setVisible(false);
		outdoorButton.setVisible(false);

		background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage(); // �̹�����
		backButton.setVisible(false);
		hintButton.setVisible(false);
		passwordButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // �̹�����
		isMainScreen = true;
		selectTrack(0);		//��ó���� �뷡�� ù �뷡�� ���;ߵǼ�
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		gamestartButton.setVisible(true);
	}
	
}
