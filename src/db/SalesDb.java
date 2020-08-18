package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SalesDb extends Db<String, Sales> {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	public SalesDb(String dbid, String dbpwd) {
		super(dbid, dbpwd);
	}

	@Override
	public void insert(Sales v) throws Exception {
		Connection con = null;
		con = getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("INSERT INTO SALES VALUES(?,?,?)");
			psmt.setString(1, v.getName());
			psmt.setInt(2, v.getAmount());
			psmt.setInt(3, v.getPrice());

			psmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psmt);
			close(con);
		}
	}

	@Override
	public void delete(String k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("DELETE FROM SALES WHERE NAME=?");
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}

	}

	@Override
	public void update(Sales v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE SALES SET PRICE=?, AMOUNT=? WHERE NAME=?");
			pstmt.setInt(1, v.getPrice());
			pstmt.setInt(2, v.getAmount());
			pstmt.setString(3, v.getName());

			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public Sales select(String k) throws Exception {
		Sales p = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM SALES WHERE NAME=?");
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				String name = rset.getString(1);
				int amount = rset.getInt(2);
				int price = rset.getInt(3);

				p = new Sales(name, amount, price);
			}
			if (p == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("no such component");
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return p;
	}

	@Override
	public ArrayList<Sales> selectAll() throws Exception {
		ArrayList<Sales> alist = new ArrayList<Sales>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM SALES");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String name = rset.getString(1);
				int amount = rset.getInt(2);
				int price = rset.getInt(3);

				Sales s = new Sales(name, amount, price);
				alist.add(s);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}

		return alist;
	}

}
