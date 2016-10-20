package by.tc.classwork01.userInterface;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableFrame extends JFrame{
	 public TableFrame() {
	        try
	        {
	            this.getContentPane().setLayout(new BorderLayout());
	            JTable dbTable = new JTable();
	            JScrollPane pane = new JScrollPane();
	            pane.getViewport().add(dbTable);
	            this.getContentPane().add(pane, BorderLayout.CENTER);
	 
	            Vector values = getDataFromDB();

	            Vector header = new Vector();
	            header.add("Количество в категории");
	            header.add("Максимальная цена");
	            header.add("Минимальная цена");
	            
	            DefaultTableModel dtm = (DefaultTableModel)dbTable.getModel();
	            dtm.setDataVector(values, header);
	            this.setSize(640, 480);
	            this.setVisible(true);
	            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }
	    }