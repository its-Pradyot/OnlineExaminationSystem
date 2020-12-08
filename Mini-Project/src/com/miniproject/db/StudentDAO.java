package com.miniproject.db;
import com.miniproject.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class StudentDAO {

	public static int insertStudent(Student student) {

		int status = 0;

		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("insert into student1 values (?,?,?,?)");
		try {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getUsername());
			ps.setString(4, student.getPassword());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return status;
	}
	
	public static boolean getStudentById(Student s) {
		boolean status = false;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db
					.getPreparedStatement("select name, password from student1 where username = ? and password = ?");

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
	
	

	public static int updateStudent(Student student) {
		int status = 0;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db.getPreparedStatement("update student1 set name=?,username=?,password=? where id=?");
			
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getUsername());
			ps.setString(3, student.getPassword());
			ps.setInt(4, student.getId());
			
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

		PreparedStatement ps = db.getPreparedStatement("delete from student1 where id = ?");
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

	public static boolean validateStudent(String username, String password) {
		boolean status = false;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db
					.getPreparedStatement("select name, password from student1 where name = ? and password = ?");

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
	
	public static boolean checkStudentExist(String username) {
		
		boolean status = false;
		
		MyDBConnection db = new MyDBConnection();
		 PreparedStatement ps = db.getPreparedStatement("select * from student1 where username = ?");
		 try {
			ps.setString(1, username);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

	public static ArrayList<Student> getAllStudents() {
		ArrayList<Student> list = new ArrayList<Student>();
		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("select * from student1");
		ResultSet rs;
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

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

		PreparedStatement ps = db.getPreparedStatement("select name from student1 where id = ?");
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
