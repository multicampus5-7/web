package dbTest;

import db.Db;
import db.Sales;
import db.SalesDb;

public class SalesUpdateTest {
	public static void main(String[] args) {
		Db<String, Sales> db = new SalesDb("db", "db");
		Sales sales = new Sales("aa", 800, 80000);
		try {
			db.update(sales);
		} catch (Exception e) {
			System.out.println("update error");
			e.printStackTrace();
		}
	}
}
