package by.tc.classwork01.database;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.tc.classwork01.dao.DaoBike;
import by.tc.classwork01.dao.DaoUser;
import by.tc.classwork01.dao.DaoOrder;
import by.tc.classwork01.entity.Bike;
import by.tc.classwork01.entity.User;
import by.tc.classwork01.entity.Order;

public class WorkDB {
	private final static Logger logger = Logger.getRootLogger();
	public final static String NAME_DB = "bicycledb";

	public static void create(String url, String user, String password)
			throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
		DB db = new DB(url, user, password);
		db.update("create database " + NAME_DB + " DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci");
		db.update("use " + NAME_DB);
		db.update("CREATE table user (" + "user_id int auto_increment primary key,"
				+ " login varchar(64) not null unique, " + "password varchar(64) not null, " + "role int(1),"
				+ "passport varchar(15)," + "date_order varchar(64)," + "delete_status int(1)," + "FIO varchar(128),"
				+ "phone int)");
		
		DaoUser du = new DaoUser(db);

		du.insert(new User("Max85", "slovan456", 0, "MP6474572", "15.10.2016", 0, "Ivanov M.A.", 5263845));
		du.insert(new User("KarinaGirl", "loveyou", 0, "MP9104210", "16.10.2016", 0, "Patrick K.T.", 6401817));
		du.insert(new User("admin911", "001adminhelp", 1, "MP9547892", "18.10.2016", 0, "Pilin F.R.", 8042517));
		du.insert(new User("Star4567", "fghjksd", 0, "MP9547892", "16.10.2016", 0, "Korenko E.S.", 1251214));
		du.insert(new User("Valiysha", "1234Pobeda", 0, "MK9547892", "17.10.2016", 1, "Gorilina V.A.", 9119119));
		logger.debug("Таблица 'user' успешно добавлена в БД и заполнена.");
		
		db.update("CREATE table bike (" + "bike_id int auto_increment primary key," + " price int, "
				+ " photo varchar(64), " + "category enum('ChildBike', 'RoadBike', 'MountainBike'), " + " bike_name varchar(64), " + " delete_status int(1))");
		DaoBike dg = new DaoBike(db);
		dg.insert(new Bike(4, "child_bike1.jpg", "ChildBike", "Tornado_16", 0));
		dg.insert(new Bike(7, "road_bike04.jpg", "RoadBike", "Stels_28", 0));
		dg.insert(new Bike(6, "child_bike20.jpg", "ChildBike", "Vector_20", 0));
		dg.insert(new Bike(12, "112_bike1.jpg", "MountainBike", "Kellys_29", 0));
		dg.insert(new Bike(10, "119_bike1.jpg", "MountainBike", "Giant_26", 0));
		logger.debug("Таблица 'bike' успешно добавлена в БД и заполнена.");
		
		db.update(
				"CREATE table orders (" + "order_id int auto_increment primary key," 
		                + "user_id int," 
						+ "bike_id int,"
						+ "bike_name varchar(255)," + "price int," + "term int," 
						+ "status_payment enum('pay','no pay'),"
						+ "total_cost int," 
						+ "foreign key(user_id) references user(user_id),"
						+ "foreign key(bike_id) references bike(bike_id))");
		DaoOrder dor = new DaoOrder(db);
		/*dor.insert(new Order(1, 4, "Kellys_29", 12, 5, "pay", 60));
		dor.insert(new Order(2, 2, "Stels_28", 7, 2, "no pay", 14));
		dor.insert(new Order(3, 5, "Giant_26", 10, 3, "pay", 30));*/
		logger.debug("Таблица 'orders' успешно добавлена в БД и заполнена.");
		db.close();
	}

	public static void delete(String url, String user, String password) throws SQLException, ClassNotFoundException {
		DB db = new DB(url, user, password);
		db.update("drop database " + NAME_DB);
		db.close();
	}
}
