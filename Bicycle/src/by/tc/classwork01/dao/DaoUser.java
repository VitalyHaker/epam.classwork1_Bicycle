package by.tc.classwork01.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.tc.classwork01.database.DB;
import by.tc.classwork01.entity.User;

public class DaoUser implements DaoInterface<User> {

	private DB db;

	public DaoUser(DB db) {
		this.db = db;
	}

	@Override
	public void insert(User ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn()
				.prepareStatement("insert into " + ob.getClass().getSimpleName()
						+ " (login,password,role,passport, date_order,delete_status, FIO, phone)"
						+ " values(?,?,?,?,?,?,?,?)");

		ps.setString(1, ob.getLogin());
		ps.setString(2, ob.getPassword());
		ps.setInt(3, ob.getRole());
		ps.setString(4, ob.getPassport());
		ps.setString(5, ob.getDate_order());
		ps.setInt(6, ob.getDelete_status());
		ps.setString(7, ob.getFIO());
		ps.setInt(8, ob.getPhone());
		ps.execute();
	}

	@Override
	public void update(User ob) throws SQLException {
		PreparedStatement ps = (PreparedStatement) db.getCn()
				.prepareStatement("update " + ob.getClass().getSimpleName()
						+ " set  role=?, FIO=?, phone=?, date_order=?, delete_status=? " + "where user_id="
						+ ob.getUser_id());
		ps.setInt(1, ob.getRole());
		ps.setString(2, ob.getFIO());
		ps.setInt(3, ob.getPhone());
		ps.setString(4, ob.getDate_order());
		ps.setInt(5, ob.getDelete_status());
		System.out.println(ps);
		ps.execute();

	}

	@Override
	public void softDelete(User ob) throws SQLException {
		db.update("delete from " + ob.getClass().getSimpleName() + " where user_id=" + ob.getUser_id());
	}

	@Override
	public void delete(User ob) throws SQLException {
		db.update("update " + ob.getClass().getSimpleName() + " set delete_status=1  where user_id="
				+ ob.getUser_id());
	}

	public User getClients(ResultSet rs)
			throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		return new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("password"), rs.getInt("role"),
				rs.getString("passport"), rs.getString("date_order"), rs.getInt("delete_status"), rs.getString("FIO"),
				rs.getInt("phone"));
	}

}
