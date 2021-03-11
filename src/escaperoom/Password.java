package escaperoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Password extends JFrame {


	private JPanel contentPane = new JPanel();
	private JPasswordField passwordField = new JPasswordField();

	private JButton clearButton = new JButton("Clear");
	private JButton pwInputButton = new JButton("PassWord Input");
	private boolean bLoginCheck;

	public Password() {

		setTitle("PassWord");
		setSize(Main.PWSCREEN_WIDETH, Main.PWSCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("AlternateGothic2 BT", Font.BOLD, 20));
		passwordField.setForeground(Color.RED);
		passwordField.setBounds(12, 10, 362, 50);
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordCheck();
			}
		});
		contentPane.add(passwordField);

		clearButton.setBackground(Color.BLACK);
		clearButton.setFont(new Font("AlternateGothic2 BT", Font.BOLD, 25));
		clearButton.setForeground(Color.RED);
		clearButton.setBounds(12, 70, 147, 33);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			}
		});
		contentPane.add(clearButton);

		pwInputButton.setForeground(Color.RED);
		pwInputButton.setFont(new Font("AlternateGothic2 BT", Font.BOLD, 25));
		pwInputButton.setBackground(Color.BLACK);
		pwInputButton.setBounds(183, 70, 191, 33);
		pwInputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordCheck();
			}
		});
		contentPane.add(pwInputButton);

	}

	public void passwordCheck() {
	
		if (EscapeRoomMain.nowSelected == 0  && new String(passwordField.getPassword()).equals(EscapeRoomMain.trackList.get(0).getPassword())) {
			JOptionPane.showMessageDialog(null, "Success");
			bLoginCheck = true;
			EscapeRoomMain.outdoorButton.setVisible(true);
			dispose();
		}else if (EscapeRoomMain.nowSelected == 1  && new String(passwordField.getPassword()).equals(EscapeRoomMain.trackList.get(1).getPassword())) {
			JOptionPane.showMessageDialog(null, "Success");
			bLoginCheck = true;
			EscapeRoomMain.outdoorButton.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}
	}
}
