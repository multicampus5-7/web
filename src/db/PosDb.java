package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PosDb extends Db<String, Pos> {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	public PosDb(String dbid, String dbpwd) {
		super(dbid, dbpwd);
	}

	@Override
	public void insert(Pos v) throws Exception {
		Connection con = null;
		con = getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("INSERT INTO POS VALUES(?,?,?,?)");
			psmt.setString(1, v.getName());
			psmt.setInt(2, v.getStock());
			psmt.setInt(3, v.getPrice());
			psmt.setString(4, v.getImg());
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
			pstmt = con.prepareStatement("DELETE FROM POS WHERE NAME=?");
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
	public void update(Pos v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE POS SET PRICE=?, IMG=?, STOCK=? WHERE NAME=?");
			pstmt.setInt(1, v.getPrice());
			pstmt.setString(2, v.getImg());
			pstmt.setInt(3, v.getStock());
			pstmt.setString(4, v.getName());

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
	public Pos select(String k) throws Exception {
		Pos p = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM POS WHERE NAME=?");
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				int stock = rset.getInt("STOCK");
				String img = rset.getString("IMG");

				p = new Pos(name, stock, price, img);
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
	public ArrayList<Pos> selectAll() throws Exception {
		ArrayList<Pos> alist = new ArrayList<Pos>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM POS");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				int stock = rset.getInt("STOCK");
				String img = rset.getString("IMG");

				Pos p = new Pos(name, stock, price, img);
				alist.add(p);
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
