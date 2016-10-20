package by.tc.classwork01.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.entity.Bike;
import by.tc.classwork01.entity.User;

public class DaoBike implements DaoInterface<Bike> {

	private DB db;

	public DaoBike(DB db) {
		this.db = db;
	}

	@Override
	public void insert(Bike ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn().prepareStatement(
				"insert into " + ob.getClass().getSimpleName()
						+ " (price, photo, category, bike_name, delete_status)"
						+ " values(?,?,?,?,?)");

		ps.setInt(1, ob.getPrice());
		ps.setString(2, ob.getPhoto());
		ps.setString(3, ob.getCategory());
		ps.setString(4, ob.getBike_name());
		ps.setInt(5, ob.getDelete_status());
		ps.execute();
	}

	@Override
	public void update(Bike ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn().prepareStatement(
				"update " + ob.getClass().getSimpleName()
						+ " set price=?, photo=?, category=?, bike_name=?, delete_status=?"
						+ " where bike_id=" + ob.getBike_id());
		ps.setInt(1, ob.getPrice());
		ps.setString(2, ob.getPhoto());
		ps.setString(3, ob.getCategory());
		ps.setString(3, ob.getBike_name());
		ps.setInt(4, ob.getDelete_status());
		ps.execute();

	}

	@Override
	public void softDelete(Bike ob) throws SQLException {
		db.update("delete from " + ob.getClass().getSimpleName()
				+ " where bike_id=" + ob.getBike_id());
				
	}

	@Override
	public void delete(Bike ob) throws SQLException {
		db.update("update " + ob.getClass().getSimpleName()
				+ " set delete_status=1  where bike_id=" + ob.getBike_id());
		
	}
	
	public ArrayList<Bike> selectAll() throws SQLException {
        ArrayList<Bike> tmp = new ArrayList<Bike>();
        ResultSet rs = this.db.query("SELECT * FROM bike");
        while (rs.next()) {
            tmp.add(new Bike(rs.getInt("bike_id"),
                    rs.getString("photo"), rs.getInt("price"),
                    rs.getString("category"),rs.getString("bike_name"),
                    rs.getInt("delete_status")));
        }
        return tmp;
    }
}
