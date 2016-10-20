package by.tc.classwork01.userInterface;


import javax.swing.*;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.userInterface.MyTable;


public abstract class TablePanel extends JPanel  {
    protected DB db;
    protected JPanel panel;
    protected JScrollPane scroll;
    protected MyTable table;

    public TablePanel(DB db) {
        this.db = db;
        setSize(500, 500);
        setLayout(null);
        add(panel);
    }

    public void initComponents() {
        createTable();
        scroll = new JScrollPane(table);
        scroll.setBounds(20, 20, 680, 300);
        add(scroll);
    }

    public abstract void createTable();
	
}



