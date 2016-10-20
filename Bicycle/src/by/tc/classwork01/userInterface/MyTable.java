package by.tc.classwork01.userInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class MyTable extends JTable {
	public MyTable(ResultSet rs) {
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dtm.addColumn(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				Vector v = new Vector();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					v.add(rs.getString(i));
				}
				dtm.addRow(v);
			}
			setModel(dtm);
			setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
