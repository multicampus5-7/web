package dbTest;

import db.Db;
import db.Pos;
import db.PosDb;

public class PosSelectTest {
	public static void main(String[] args) {
		Db<String, Pos> db = new PosDb("db", "db");
		Pos pos = null;
		String name = "불고기버거";
		
		try {
			pos = db.select(name);
			System.out.println(pos);
		} catch (Exception e) {
			System.out.println("select All error");
			e.printStackTrace();
		}
	}
}
