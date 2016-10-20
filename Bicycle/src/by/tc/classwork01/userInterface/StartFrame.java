package by.tc.classwork01.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.database.WorkDB;

public class StartFrame extends JFrame {
	private final static Logger logger = Logger.getRootLogger();
	private JPanel panel;
	private JLabel labelUrl, labelPassword, labelLogin;
	private JTextField tfLogin, tfUrl;
	private JPasswordField pf;
	private JButton create, delete, connect;

	public StartFrame() {
		setSize(280, 150);
		setTitle("StartFrame");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void action() {
         create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WorkDB.create("jdbc:mysql://"+tfUrl.getText()+"/", tfLogin.getText(),String.valueOf( pf.getPassword()));
					JOptionPane.showMessageDialog(panel, "Create ok", "Message", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					logger.error("База данных не создана.", e1);
					JOptionPane.showMessageDialog(panel, "Create no "+e1, "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
         delete.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				try {
 					WorkDB.delete("jdbc:mysql://"+tfUrl.getText()+"/", tfLogin.getText(),String.valueOf( pf.getPassword()));
 					JOptionPane.showMessageDialog(panel, "Delete ok", "Message", JOptionPane.INFORMATION_MESSAGE);
 				} catch (SQLException e1) {
 					logger.error("База данных не удалена.", e1);
 					JOptionPane.showMessageDialog(panel, "Delete no "+e1, "Error", JOptionPane.ERROR_MESSAGE);
 				} catch (ClassNotFoundException e1) {
 					
 					e1.printStackTrace();
 				}
 				
 			}
 		});
         connect.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				try {
 					DB db= new DB ("jdbc:mysql://"+tfUrl.getText()
 							+"/"+WorkDB.NAME_DB,tfLogin.getText(),
 							pf.getText());
 					new InquiryFrame(db);
 					dispose();
 					
 				} catch (SQLException e1) {
 					logger.error("Соединение с базой данных не установлено.", e1);
 					JOptionPane.showMessageDialog(panel, "This database isn't installed\n"+e1, "Error", JOptionPane.ERROR_MESSAGE);
 				} catch (ClassNotFoundException e1) {
 					JOptionPane.showMessageDialog(panel, "This database isn't installed\n"+e1, "Error", JOptionPane.ERROR_MESSAGE);
 				} 
 				
 			}
 		});
	}

	private void initComponents() {
		panel = new JPanel();
		labelUrl = new JLabel("URL  ");
		labelLogin = new JLabel("Login");
		labelPassword = new JLabel("Pass ");
		tfUrl = new JTextField("localhost", 20);
		tfLogin = new JTextField("root", 20);
		pf = new JPasswordField("root", 20);
		create = new JButton("create");
		delete = new JButton("delete");
		connect = new JButton("connect");

		panel.add(labelUrl);
		panel.add(tfUrl);
		panel.add(labelLogin);
		panel.add(tfLogin);
		panel.add(labelPassword);
		panel.add(pf);
		panel.add(create);
		panel.add(delete);
		panel.add(connect);
		add(panel);
	}
}
