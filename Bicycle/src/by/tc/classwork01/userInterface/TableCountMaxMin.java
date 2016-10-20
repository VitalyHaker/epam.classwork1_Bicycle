package by.tc.classwork01.userInterface;


import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.userInterface.MyTable;

public class TableCountMaxMin extends JFrame{
	
	private final static Logger logger = Logger.getRootLogger();
    private DB db;

	public TableCountMaxMin(DB db) {
		
    	this.db = db;
        setSize(500, 100);
        setTitle("TableCountMaxMinFrame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setResizable(false);
        setVisible(true);
        initComponents();
    }

    public  void initComponents() {
        JPanel panel = new JPanel();
        add(panel);
        createTable();

    }

    public void createTable() {
        try {
        	ResultSet rs = db.query("SELECT COUNT(category), MIN(price), MAX(price) FROM bike GROUP BY category;");
            new MyTable(rs) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            };
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error creating table\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

