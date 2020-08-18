package dbTest;

import db.Db;
import db.Pos;
import db.PosDb;

public class PosInsertTest {
	public static void main(String[] args) {
		Db<String, Pos> db = new PosDb("db", "db");
		Pos pos = new Pos("temp¹ö°Å", 1, 100, "");

		try {
			db.insert(pos);
		} catch (Exception e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
	}
}
