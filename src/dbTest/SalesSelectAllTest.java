package dbTest;

import java.util.ArrayList;

import db.Db;
import db.Sales;
import db.SalesDb;

public class SalesSelectAllTest {
	public static void main(String[] args) {
		Db<String, Sales> db = new SalesDb("db", "db");
		ArrayList<Sales> aList = new ArrayList<Sales>();

		try {
			aList = db.selectAll();
			for (Sales sales : aList) {
				System.out.println(sales);
			}
			
		} catch (Exception e) {
			System.out.println("select All error");
			e.printStackTrace();
		}
	}
}
