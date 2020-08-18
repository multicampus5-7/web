package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Db<K, V> {
	private String url;
	private String dbid;
	private String dbpwd;

	public Db() {
	}

	public Db(String dbid, String dbpwd) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Nou Found");
		}
		this.url = "jdbc:oracle:thin:@192.168.0.26:1521:xe";
		this.dbid = dbid;
		this.dbpwd = dbpwd;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbid, dbpwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not connected!");
		}
		return con;
	}

	public void close(ResultSet rset) {
		if (rset != null)
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	abstract public void insert(V v) throws Exception;

	abstract public void delete(K k) throws Exception;

	abstract public void update(V v) throws Exception;

	abstract public V select(K k) throws Exception;

	abstract public ArrayList<V> selectAll() throws Exception;
}
