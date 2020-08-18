package dbTest;

import java.util.ArrayList;

import db.Db;
import db.Pos;
import db.PosDb;

public class PosSelectAllTest {
	public static void main(String[] args) {
		Db<String, Pos> db = new PosDb("db", "db");
		ArrayList<Pos> aList = new ArrayList<Pos>();

		try {
			aList = db.selectAll();
			for (Pos pos : aList) {
				System.out.println(pos);
			}
			
		} catch (Exception e) {
			System.out.println("select All error");
			e.printStackTrace();
		}
	}
}
