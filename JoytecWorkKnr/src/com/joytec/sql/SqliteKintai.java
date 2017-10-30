package com.joytec.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.joytec.Consts.Constants;
import com.joytec.src.beans.GWork;

/**
 * Servlet implementation class SqliteKintai
 */
@WebServlet("/SqliteKintai")
public class SqliteKintai {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SqliteKintai() {
		super();
	}

	public ArrayList<GWork> getKintai(String employeeCd) throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(Constants.DbConnection);
			stmt = conn.createStatement();

			String sql = "SELECT EmployeeCd, BusinessDay, WorkStart, WorkEnd FROM GWork WHERE EmployeeCd = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// パラメータセット
			// 社員番号
			pstmt.setString(1, employeeCd);

			// SQL実行
			rs = pstmt.executeQuery();

			ArrayList<GWork> list = new ArrayList<GWork>();

			while (rs.next()) {

				String businessDay = rs.getString("BusinessDay");
				String workStart = rs.getString("WorkStart");
				String workEnd = rs.getString("WorkEnd");
				list.add(new GWork(employeeCd, businessDay, workStart, workEnd));
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
