package com.joytec.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.joytec.Consts.Constants;

/**
 * Servlet implementation class SqliteLogin
 */
@WebServlet("/SqliteLogin")
public class SqliteLogin {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SqliteLogin() {
		super();
	}

	public String logInchk(String employeeCd, String pass) throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(Constants.DbConnection);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT EmployeeCd, EmployeeNm, Pass FROM MEmployeeInfo");

			while (rs.next()) {

				// 社員番号とパスを照合
				if (employeeCd.equals(rs.getString("EmployeeCd")) && pass.equals(rs.getString("Pass"))) {

					return rs.getString("EmployeeNm").toString();
				}
			}

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
