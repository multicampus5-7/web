package dbTest;

import db.Db;
import db.Sales;
import db.SalesDb;

public class SalesDeleteTest {
	public static void main(String[] args) {
		Db<String, Sales> db = new SalesDb("db", "db");
		String name = "ss";
		try {
			db.delete(name);
		} catch (Exception e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
	}
}
