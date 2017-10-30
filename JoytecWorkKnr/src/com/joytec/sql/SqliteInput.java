package com.joytec.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.joytec.Consts.Constants;

/**
 * Servlet implementation class SqliteIndex
 */
@WebServlet("/SqliteInput")
public class SqliteInput {

	@SuppressWarnings("resource")
	public boolean inputUpdate(String employeeCd, String businessDay, String workStart, String workEnd)
			throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			conn = DriverManager.getConnection(Constants.DbConnection);
			stmt = conn.createStatement();

			String sql = null;
			PreparedStatement pstmt = null;

			sql = "SELECT EmployeeCd, BusinessDay, WorkStart, WorkEnd FROM GWork WHERE EmployeeCd = ? AND BusinessDay = ?";
			pstmt = conn.prepareStatement(sql);

			// パラメータセット
			// 社員番号
			pstmt.setString(1, employeeCd);
			// 日付
			pstmt.setString(2, businessDay);

			// SQL実行
			rs = pstmt.executeQuery();

			if (rs.next()) {

				sql = "UPDATE GWork SET EmployeeCd = ?, BusinessDay = ?, WorkStart = ?, WorkEnd = ? "
						+ "WHERE EmployeeCd = ? AND BusinessDay  = ?";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, employeeCd);
				pstmt.setString(2, businessDay);
				pstmt.setString(3, workStart);
				pstmt.setString(4, workEnd);
				pstmt.setString(5, employeeCd);
				pstmt.setString(6, businessDay);

				// 実行
				pstmt.executeUpdate();

			} else {

				sql = "INSERT INTO GWork(EmployeeCd, BusinessDay, WorkStart, WorkEnd) VALUES(?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, employeeCd);
				pstmt.setString(2, businessDay);
				pstmt.setString(3, workStart);
				pstmt.setString(4, workEnd);
				// 実行
				pstmt.executeUpdate();

			}

			return true;

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
		return false;
	}

}
