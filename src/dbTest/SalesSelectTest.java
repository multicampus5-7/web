package dbTest;

import db.Db;
import db.Sales;
import db.SalesDb;

public class SalesSelectTest {
	public static void main(String[] args) {
		Db<String, Sales> db = new SalesDb("db", "db");
		String name = "aa";
		Sales sales = null;
		try {
			sales = db.select(name);
			System.out.println(sales);
		} catch (Exception e) {
			System.out.println("select error");
			e.printStackTrace();
		}
	}
}
