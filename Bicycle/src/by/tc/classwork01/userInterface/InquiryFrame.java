package by.tc.classwork01.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import by.tc.classwork01.database.DB;

public class InquiryFrame extends JFrame {
	private final static Logger logger = Logger.getRootLogger();
	private JPanel panel;
	private JLabel labelLogin;
	private JButton enter, cancel;
	private DB db;
	public InquiryFrame(DB db) {
        this.db = db;
        setSize(500, 100);
        setTitle("InquiryFrame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        action();
        setResizable(false);
        setVisible(true);

    }

	private void initComponents() {
        panel = new JPanel();
        labelLogin = new JLabel("Do you want to make a report on the number"
        			+ " of products in each category BICYCLE?");
        enter = new JButton("Yes");
        cancel = new JButton("No");
        panel.add(labelLogin);
        panel.add(enter);
        panel.add(cancel);
        add(panel);
    }

    private void action() {
        enter.addActionListener(new ActionListener() {
	        	
     @Override
            public void actionPerformed(ActionEvent e) {
/*    	 	public Vector getDataFromDB() throws Exception {
    	        Vector result = new Vector();
    	        
    	        String query = "SELECT COUNT(category), MIN(price), MAX(price) FROM bike GROUP BY category;";
    	        ResultSet resultSet = stmt.executeQuery(query);
    	        String p1, p2, p3;
    	        
    	        while(resultSet.next())
    	        {
       	            Vector element = new Vector();
    	            p1 = resultSet.getString(1);
    	            p2 = resultSet.getString(2);
    	            p3 = resultSet.getString(3);
    	            element.add(p1);
    	            element.add(p2);
    	            element.add(p3);
    	            result.add(element);
    	        }
    	        resultSet.close();
    	 
    	        return result;
    	    }*/
    	 	try {
                 ResultSet rs = db.query("SELECT COUNT(category), MIN(price), MAX(price) FROM bike GROUP BY category;");
                 System.out.println("Количество в категории | " + "Максимальная цена | " + "Минимальная цена");
                 while (rs.next()) {
                     int count_category = rs.getInt("COUNT(category)");
                     int min_price = rs.getInt("MIN(price)");
                     int max_price = rs.getInt("MAX(price)");
                     System.out.println("           " + count_category + "                     " + min_price + "                  " + max_price);
                    }
                    JOptionPane.showMessageDialog(panel, "See the query result in the command line.");
                } catch (SQLException ex) {
                	logger.error("Ошибка при запросе к базе данных.", ex);
                    JOptionPane.showMessageDialog(panel,
                            "Error in database\n" + ex, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
     		}
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(panel, "We advise you to print the report next time !!!");
                dispose();
            }
        });
    }
}
