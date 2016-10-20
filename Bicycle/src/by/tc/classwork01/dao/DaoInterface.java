package by.tc.classwork01.dao;

import java.sql.SQLException;

public interface DaoInterface<T> {
	public void insert(T ob) throws SQLException;
	public void delete(T ob) throws SQLException;
	public  void update(T ob) throws SQLException;
	public void  softDelete(T ob)throws SQLException;
}
