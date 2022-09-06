package me.dcal.Lermar.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.hibernate.mapping.Component;
import org.hibernate.type.BagType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javafx.scene.paint.Color;
import me.dcal.Lermar.control.permanences.Permanence;

public class RouletteView extends JFrame { 
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	JTable table;
	DefaultTableModel model;
	public RouletteView(Permanence perm) throws IOException{

	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(new Dimension((int) (dimension.width*0.9), (int) (dimension.height*0.9)));
		setTitle("LERMAR");

		add(createContainerWithMenu(perm), BorderLayout.NORTH);
		add(BackgroundContainer(), BorderLayout.WEST);
		add(createGameContainer(), BorderLayout.CENTER);
		add(createControleContainer(), BorderLayout.SOUTH);

		setLocationRelativeTo(null);

		pack();
		setVisible(true);
	}

	private JPanel createControleContainer() {
		JPanel panel = new JPanel();
		JButton bt = new JButton("Lancer");
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			   String str = event.getActionCommand();
			   model.addRow(new Object[]{
						1, 
						2,
						2,
						1,
						1
				});
			   System.out.println("Clicked = " + str);
			}
		 };
		 bt.setActionCommand("FirstButton");
		 bt.addActionListener(actionListener);
		panel.add(bt);
		panel.add(new JButton("Quitter"));
		return panel;
	}

	private JScrollPane createGameContainer() {
		// JButton bt = new JButton("hh");
		// JPanel panel = new JPanel();
		String[] columnNames = {"Coup","Num","Mises","Resultat","Bilan"};
		Object[][] data = {};

		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		JScrollPane wcrool = new JScrollPane(table);
		// bt.setSize(dimension.width/2, (int) (dimension.height*0.8));
		return wcrool;
	}

	private JLabel BackgroundContainer() throws IOException {
		ImageIcon background;

		background = new ImageIcon(ImageIO.read(new File("src/main/resources/fond_roulette.png")));
		background = new ImageIcon(background.getImage().getScaledInstance(dimension.width/2, (int) (dimension.height*0.8),Image.SCALE_DEFAULT));

		JLabel l = new JLabel(background);

		return l;
	}

	private static JMenuBar createContainerWithMenu(Permanence perm) {
		// JRootPane rootPane = new JRootPane();
		// rootPane.getContentPane().add(createLabel("", Color.PINK));
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createMenu("Jeu",perm, "Jouer", "Rechercher", "Quitter"));
		menuBar.add(createMenu("Méthodes", "Acoussur", "Osmose NAS", "Colonnes et douzaines","Thaïlandaise", "Express 20/24", "Ad Libitim"));
		menuBar.add(createMenu("Montantes", "NAS", "D'Alembert", "Contre d'Alembert", "Hollandaise", "Americaine", "Piquemouche", "Wells", "Contre Wells", "MIDAS", "A paliers", "Pascal"));
		menuBar.add(createMenu("Solveur", "Acoussur"));
		menuBar.add(createMenu("Permanences", "Création", "Saisie", "Effacement", "Duplication", "Fusion", "Visualisation"));
		menuBar.add(createMenu("Aide", "A propos", "Utilisation"));
		// rootPane.setJMenuBar(menuBar);
		return menuBar;
	}
  
	private static JMenu createMenu(String menuLabel,Permanence perm,  String... subMenuLabels) {
		JMenu menu = new JMenu(menuLabel);
		for (String subMenuLabel : subMenuLabels) {
			
			JMenuItem menuItem = new JMenuItem(subMenuLabel);
			if (subMenuLabel == "Jouer"){
				ActionListener actionListener = new ActionListener() {
					public void actionPerformed(ActionEvent event) {
					   String str = event.getActionCommand();
					//    JRootPane rootPane = new JRootPane();
					   JDialog jd = new JDialog();
					   jd.setLayout(new FlowLayout());
					   for (Path perma : perm.getPermanencesPath()){
						JLabel jLabel = new JLabel(perma.toString());
						jd.add(jLabel);


					   }
        				jd.setBounds(500, 300, 400, 300);
					//    JFrame jFrame = new JFrame();
					//    String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your message");
					//    JOptionPane.showMessageDialog( ,"Your message: "+str);
					   jd.setVisible(true);
					   
					   System.out.println("Clicked = " + str);
					}
				 };
				 menuItem.setActionCommand("FirstButton");
				 menuItem.addActionListener(actionListener);
			}
			menu.add(menuItem);
		}
		return menu;
	}

	private static JMenu createMenu(String menuLabel, String... subMenuLabels) {
		JMenu menu = new JMenu(menuLabel);
		for (String subMenuLabel : subMenuLabels) {
			
			JMenuItem menuItem = new JMenuItem(subMenuLabel);
			menu.add(menuItem);
		}
		return menu;
	}
  

}
