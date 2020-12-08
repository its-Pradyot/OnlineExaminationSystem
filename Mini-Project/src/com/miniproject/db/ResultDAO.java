package com.miniproject.db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.model.Question;
import com.miniproject.model.Result;

public class ResultDAO {
	
	public static int saveResult(Result result) {
		
		int status = 0;

		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("insert into results values (?,?,?)");
		
		try {
			ps.setString(1, result.getName());
			ps.setInt(2, result.getMarks());
			ps.setInt(3, result.getTotal());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);		
		}finally {
			db.closeConnection();
		}
		return status;
		
	}
		
		
		public static ArrayList<Result> getResult() {
			ArrayList<Result> list = new ArrayList<Result>();
			MyDBConnection db = new MyDBConnection();
			PreparedStatement ps = db.getPreparedStatement("select * from results");
			ResultSet rs;
			try {
				rs = ps.executeQuery();

				while (rs.next()) {
					list.add(new Result(rs.getString(1), rs.getInt(2), rs.getInt(3)));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.closeConnection();
			}

			return list;

		}
	

}
