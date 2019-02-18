package fr.B4D.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import fr.B4D.bot.B4D;

public class JPanel_Reglage extends JPanel {

	private static final long serialVersionUID = -4135111440537713705L;
	
	public final int width = 635;
	public final int height = 125;

	private Point topLeft, bottomRight;
	
	private JLabel lblXY_GameFrame = new JLabel("X:Y");
	private JLabel lblLH_GameFrame = new JLabel("LxH");
	private JLabel lblXY_ChatFrame = new JLabel("X:Y");
	private JLabel lblLH_ChatFrame = new JLabel("LxH");
	private JLabel lblXY_ChatBar = new JLabel("X:Y");
	private JLabel lblXY_Minimap = new JLabel("X:Y");

	private B4D b4d;
	
	/**
	 * Create the panel.
	 */
	public JPanel_Reglage(B4D b4d) {
		this.b4d = b4d;
				
		setBackground(new Color(33,43,53));
		setLayout(null);
		setVisible(false);

		JPanel panel_GameFrame = new JPanel();
		panel_GameFrame.setLayout(null);
		panel_GameFrame.setBorder(new LineBorder(new Color(46, 139, 87), 3));
		panel_GameFrame.setBackground(Color.LIGHT_GRAY);
		panel_GameFrame.setBounds(10, 10, 150, 105);
		add(panel_GameFrame);
		
		JLabel lbl_GameFrame = new JLabel("Zone de jeu");
		lbl_GameFrame.setOpaque(true);
		lbl_GameFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_GameFrame.setForeground(Color.WHITE);
		lbl_GameFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_GameFrame.setBackground(new Color(46, 139, 87));
		lbl_GameFrame.setBounds(0, 0, 150, 25);
		panel_GameFrame.add(lbl_GameFrame);
		
		lblXY_GameFrame = new JLabel("X:Y");
		lblXY_GameFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblXY_GameFrame.setForeground(Color.DARK_GRAY);
		lblXY_GameFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXY_GameFrame.setBackground(Color.GRAY);
		lblXY_GameFrame.setBounds(0, 25, 150, 25);
		panel_GameFrame.add(lblXY_GameFrame);
		
		lblLH_GameFrame = new JLabel("LxH");
		lblLH_GameFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblLH_GameFrame.setForeground(Color.DARK_GRAY);
		lblLH_GameFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLH_GameFrame.setBackground(Color.GRAY);
		lblLH_GameFrame.setBounds(0, 50, 150, 25);
		panel_GameFrame.add(lblLH_GameFrame);
		
		JButton button_GameFrame = new JButton("Modifier");
		button_GameFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B4D.mouse.getPoints(
					"Cliquez dans le coin supp�rieur gauche",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/ZoneHautGauche.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							topLeft = MouseInfo.getPointerInfo().getLocation();
						}
					},
					"Cliquez dans le coin inf�rieur droit",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/ZoneBasDroite.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							bottomRight = MouseInfo.getPointerInfo().getLocation();
							
							int width = bottomRight.x - topLeft.x;
							int height = bottomRight.y - topLeft.y;
							int realWidth = height * 1157 / 927;
							b4d.getConfiguration().setGameFrame(new Rectangle((width - realWidth)/2, topLeft.y, realWidth, height));
							
							ActualiserInfos();
						}
					});
//		        LocalConfiguration.ZoneDeJeu.Location = GetPoint(Images.Images.Item(0), "Cliquer dans le coin supp�rieur gauche de la fen�tre de jeu.")
//		        Dim CurrentPosition As Point = GetPoint(Images.Images.Item(1), "Cliquer dans le coin inf�rieur droit de la fen�tre de jeu, puis appuyez sur '+'. (Ne pas fermer cette fenetre)")
//
//		        LocalConfiguration.ZoneDeJeu.Height = CurrentPosition.Y - LocalConfiguration.ZoneDeJeu.Location.Y
//		        LocalConfiguration.ZoneDeJeu.Width = LocalConfiguration.ZoneDeJeu.Height * 1157 / 927
//		        LocalConfiguration.ZoneDeJeu.Location = New Point((Screen.PrimaryScreen.Bounds.Width - LocalConfiguration.ZoneDeJeu.Width) / 2, LocalConfiguration.ZoneDeJeu.Location.Y)
			}
		});
		button_GameFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_GameFrame.setBackground(UIManager.getColor("Button.background"));
		button_GameFrame.setBounds(5, 75, 140, 25);
		panel_GameFrame.add(button_GameFrame);
		
		JPanel panel_ChatFrame = new JPanel();
		panel_ChatFrame.setLayout(null);
		panel_ChatFrame.setBorder(new LineBorder(new Color(46, 139, 87), 3));
		panel_ChatFrame.setBackground(Color.LIGHT_GRAY);
		panel_ChatFrame.setBounds(165, 10, 150, 105);
		add(panel_ChatFrame);
		
		JLabel lbl_ChatFrame = new JLabel("Zone de chat");
		lbl_ChatFrame.setOpaque(true);
		lbl_ChatFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ChatFrame.setForeground(Color.WHITE);
		lbl_ChatFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ChatFrame.setBackground(new Color(46, 139, 87));
		lbl_ChatFrame.setBounds(0, 0, 150, 25);
		panel_ChatFrame.add(lbl_ChatFrame);
		
		lblXY_ChatFrame = new JLabel("X:Y");
		lblXY_ChatFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblXY_ChatFrame.setForeground(Color.DARK_GRAY);
		lblXY_ChatFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXY_ChatFrame.setBackground(Color.GRAY);
		lblXY_ChatFrame.setBounds(0, 25, 150, 25);
		panel_ChatFrame.add(lblXY_ChatFrame);

		lblLH_ChatFrame = new JLabel("LxH");
		lblLH_ChatFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblLH_ChatFrame.setForeground(Color.DARK_GRAY);
		lblLH_ChatFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLH_ChatFrame.setBackground(Color.GRAY);
		lblLH_ChatFrame.setBounds(0, 50, 150, 25);
		panel_ChatFrame.add(lblLH_ChatFrame);
		
		JButton button_ChatFrame = new JButton("Modifier");
		button_ChatFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B4D.mouse.getPoints(
					"Cliquez dans le coin supp�rieur gauche de la zone de chat",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/ChatHautGauche.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							topLeft = MouseInfo.getPointerInfo().getLocation();
						}
					},
					"Cliquez dans le coin inf�rieur droit de la zone de chat",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/ChatBasDroite.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							bottomRight = MouseInfo.getPointerInfo().getLocation();
							b4d.getConfiguration().setChatFrame(new Rectangle(topLeft.x, topLeft.y, bottomRight.x - topLeft.x, bottomRight.y - topLeft.y));
							ActualiserInfos();
						}
					});		
			}
		});
		button_ChatFrame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_ChatFrame.setBackground(UIManager.getColor("Button.background"));
		button_ChatFrame.setBounds(5, 75, 140, 25);
		panel_ChatFrame.add(button_ChatFrame);
		
		JPanel panel_Barre_Chat = new JPanel();
		panel_Barre_Chat.setLayout(null);
		panel_Barre_Chat.setBorder(new LineBorder(new Color(46, 139, 87), 3));
		panel_Barre_Chat.setBackground(Color.LIGHT_GRAY);
		panel_Barre_Chat.setBounds(320, 10, 150, 80);
		add(panel_Barre_Chat);
		
		JLabel lbl_ChatBar = new JLabel("Barre de chat");
		lbl_ChatBar.setOpaque(true);
		lbl_ChatBar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ChatBar.setForeground(Color.WHITE);
		lbl_ChatBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ChatBar.setBackground(new Color(46, 139, 87));
		lbl_ChatBar.setBounds(0, 0, 150, 25);
		panel_Barre_Chat.add(lbl_ChatBar);
		
		lblXY_ChatBar = new JLabel("X:Y");
		lblXY_ChatBar.setHorizontalAlignment(SwingConstants.CENTER);
		lblXY_ChatBar.setForeground(Color.DARK_GRAY);
		lblXY_ChatBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXY_ChatBar.setBackground(Color.GRAY);
		lblXY_ChatBar.setBounds(0, 25, 150, 25);
		panel_Barre_Chat.add(lblXY_ChatBar);
		
		JButton button_ChatBar = new JButton("Modifier");
		button_ChatBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 B4D.mouse.getPoint(
					"Cliquez dans la barre de chat",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/ChatBarre.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							b4d.getConfiguration().setChatBar(MouseInfo.getPointerInfo().getLocation());
							ActualiserInfos();
						}
					});
			}
		});
		button_ChatBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_ChatBar.setBackground(UIManager.getColor("Button.background"));
		button_ChatBar.setBounds(5, 50, 140, 25);
		panel_Barre_Chat.add(button_ChatBar);
		
		JPanel panel_Minimap = new JPanel();
		panel_Minimap.setBounds(475, 10, 150, 80);
		add(panel_Minimap);
		panel_Minimap.setLayout(null);
		panel_Minimap.setBorder(new LineBorder(new Color(46, 139, 87), 3));
		panel_Minimap.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbl_Minimap = new JLabel("Minimap");
		lbl_Minimap.setOpaque(true);
		lbl_Minimap.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Minimap.setForeground(Color.WHITE);
		lbl_Minimap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Minimap.setBackground(new Color(46, 139, 87));
		lbl_Minimap.setBounds(0, 0, 150, 25);
		panel_Minimap.add(lbl_Minimap);

		lblXY_Minimap = new JLabel("X:Y");
		lblXY_Minimap.setHorizontalAlignment(SwingConstants.CENTER);
		lblXY_Minimap.setForeground(Color.DARK_GRAY);
		lblXY_Minimap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXY_Minimap.setBackground(Color.GRAY);
		lblXY_Minimap.setBounds(0, 25, 150, 25);
		panel_Minimap.add(lblXY_Minimap);
		
		JButton button_Minimap = new JButton("Modifier");
		button_Minimap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B4D.mouse.getPoint(
					"Cliquez sur la minimap",
					new ImageIcon(Toolkit.getDefaultToolkit().getImage(JFrame_B4D.class.getResource("/fr/B4D/images/Minimap.png"))),
					new MouseAdapter() {
						public void mousePressed(MouseEvent e) {
							b4d.getConfiguration().setMinimap(MouseInfo.getPointerInfo().getLocation());
							ActualiserInfos();
						}
					});
			}
		});
		button_Minimap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_Minimap.setBackground(UIManager.getColor("Button.background"));
		button_Minimap.setBounds(5, 50, 140, 25);
		panel_Minimap.add(button_Minimap);
		
		ActualiserInfos();
	}
	
	  /**************/
	 /** METHODES **/
	/**************/
	
	public void ActualiserInfos() {
		if(b4d.getConfiguration().getGameFrame() != null) {
			this.lblXY_GameFrame.setText(b4d.getConfiguration().getGameFrame().x + ":" + b4d.getConfiguration().getGameFrame().y);
			this.lblLH_GameFrame.setText(b4d.getConfiguration().getGameFrame().width + "x" + b4d.getConfiguration().getGameFrame().height);
		}else {
			this.lblXY_GameFrame.setText("X:Y");
			this.lblLH_GameFrame.setText("LxH");
		}
		
		if(b4d.getConfiguration().getChatFrame() != null) {
			this.lblXY_ChatFrame.setText(b4d.getConfiguration().getChatFrame().x + ":" + b4d.getConfiguration().getChatFrame().y);
			this.lblLH_ChatFrame.setText(b4d.getConfiguration().getChatFrame().width + "x" + b4d.getConfiguration().getChatFrame().height);
		}else {
			this.lblXY_ChatFrame.setText("X:Y");
			this.lblLH_ChatFrame.setText("LxH");
		}
		
		if(b4d.getConfiguration().getChatBar() != null)
			this.lblXY_ChatBar.setText(b4d.getConfiguration().getChatBar().x + ":" + b4d.getConfiguration().getChatBar().y);
		else
			this.lblXY_ChatBar.setText("X:Y");
		
		if(b4d.getConfiguration().getMinimap() != null)
			this.lblXY_Minimap.setText(b4d.getConfiguration().getMinimap().x + ":" + b4d.getConfiguration().getMinimap().y);
		else
			this.lblXY_Minimap.setText("X:Y");
	}
}