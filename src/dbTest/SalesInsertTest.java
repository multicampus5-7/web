package dbTest;

import db.Db;
import db.Sales;
import db.SalesDb;

public class SalesInsertTest {
	public static void main(String[] args) {
		Db<String, Sales> db = new SalesDb("db", "db");
		Sales sales = new Sales("ss", 800, 80000);
		try {
			db.insert(sales);
		} catch (Exception e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
	}
}
