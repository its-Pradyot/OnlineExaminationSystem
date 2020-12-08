package com.miniproject.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miniproject.model.Teacher;

/*
 * This DAO class provides CURD database operations for the table teacher in the database
 */
public class TeacherDAO {
	public static int insertStudent(Teacher teacher) {

		int status = 0;

		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("insert into teacher values (?,?,?)");
		try {
			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getName());
			ps.setString(3, teacher.getPassword());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return status;
	}

	public static int updateStudent(Teacher teacher) {
		int status = 0;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db.getPreparedStatement("update teacher set id=?, name=?,password=?");
			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getName());
			ps.setString(4, teacher.getPassword());
			status = ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return status;

	}

	public static int delete(int id) {
		int status = 0;
		MyDBConnection db = new MyDBConnection();

		PreparedStatement ps = db.getPreparedStatement("delete from teacher where id = ?");
		try {
			ps.setInt(1, id);

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return id;

	}

	public static boolean validate(String username, String password) {
		boolean status = false;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db
					.getPreparedStatement("select name, password from teacher where name = ? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return status;
	}

	public static List<Teacher> getAllStudents() {
		List<Teacher> list = new ArrayList<Teacher>();
		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("select * from teacher");
		ResultSet rs;
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return list;

	}

	public static String getStudentName(String username) {
		String name = null;
		MyDBConnection db = new MyDBConnection();

		PreparedStatement ps = db.getPreparedStatement("select name from teacher where id = ?");
		try {
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			} else {
				name = "Error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
