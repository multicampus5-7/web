package dbTest;

import db.Db;
import db.Pos;
import db.PosDb;

public class PosUpdateTest {
	public static void main(String[] args) {
		Db<String, Pos> db = new PosDb("db", "db");
		Pos pos = new Pos("불고기버거", 10, 8000, "");

		try {
			db.update(pos);
		} catch (Exception e) {
			System.out.println("update error");
			e.printStackTrace();
		}
	}
}
