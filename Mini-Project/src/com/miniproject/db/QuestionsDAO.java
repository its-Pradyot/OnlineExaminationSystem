package com.miniproject.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miniproject.model.Question;

public class QuestionsDAO {

	public static int insertQuestion(Question q) {

		int status = 0;

		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("insert into questions values (?,?,?,?,?,?,?)");
		try {
			ps.setInt(1, q.getId());
			ps.setString(2, q.getQuestion());
			ps.setString(3, q.getOption1());
			ps.setString(4, q.getOption2());
			ps.setString(5, q.getOption3());
			ps.setString(6, q.getOption4());
			ps.setString(7, q.getAnswer());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.closeConnection();

		return status;
	}

	public static int updateQuestion(Question q) {
		int status = 0;
		MyDBConnection db = new MyDBConnection();

		try {
			PreparedStatement ps = db.getPreparedStatement(
					"update questions set question=?,option1=?,option2=?,option3=?,option4=?,answer=? where id=?");
			
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getOption1());
			ps.setString(3, q.getOption2());
			ps.setString(4, q.getOption3());
			ps.setString(5, q.getOption4());
			ps.setString(6, q.getAnswer());
			ps.setInt(7, q.getId());
			status = ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		db.closeConnection();
		return status;

	}

	public static int deleteQuestion(int id) {
		int status = 0;
		MyDBConnection db = new MyDBConnection();

		PreparedStatement ps = db.getPreparedStatement("delete from questions where id = ?");
		try {
			ps.setInt(1, id);

			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConnection();
		return id;

	}

	public static ArrayList<Question> getAllQuestions() {
		ArrayList<Question> list = new ArrayList<Question>();
		MyDBConnection db = new MyDBConnection();
		PreparedStatement ps = db.getPreparedStatement("select * from questions");
		ResultSet rs;
		try {
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));

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
