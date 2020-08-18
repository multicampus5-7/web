package dbTest;

import db.Db;
import db.Pos;
import db.PosDb;

public class PosDeleteTest {
	public static void main(String[] args) {
		Db<String, Pos> db = new PosDb("db", "db");
		String name = "temp¹ö°Å";

		try {
			db.delete(name);
		} catch (Exception e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
	}
}
