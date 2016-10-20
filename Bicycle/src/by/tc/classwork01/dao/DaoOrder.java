package by.tc.classwork01.dao;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.entity.Order;

public class DaoOrder implements DaoInterface<Order> {
	private DB db;

	public DaoOrder(DB db) {
		this.db = db;
	}

	@Override
	public void insert(Order ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn()
				.prepareStatement("insert into " + ob.getClass().getSimpleName()
						+ "( user_id, bike_id, bike_name, price, term, status_payment, total_cost) "
						+ "values(?,?,?,?,?,?,?)");
	
		ps.setInt(1, ob.getUser_id());
		ps.setInt(2, ob.getBike_id());
		ps.setString(3, ob.getBike_name());
		ps.setInt(4, ob.getPrice());
		ps.setInt(5, ob.getTerm());
		ps.setString(6, ob.getStatus_payment());
		ps.setInt(7, ob.getTotal_cost());
		ps.execute();

	}

	@Override
	public void delete(Order ob) throws SQLException {

		db.update("update " + ob.getClass().getSimpleName() + " set delete_status=1 where order_id="
				+ ob.getOrder_id());

	}

	@Override
	public void update(Order ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn().prepareStatement(
				"update " + ob.getClass().getSimpleName() + " set status_payment=? where order_id=" + ob.getOrder_id());
		ps.setString(1, ob.getStatus_payment());
		ps.execute();

	}

	@Override
	public void softDelete(Order ob) throws SQLException {
		db.update("delete from " + ob.getClass().getSimpleName() + " where order_id=" + ob.getOrder_id());

	}

}
