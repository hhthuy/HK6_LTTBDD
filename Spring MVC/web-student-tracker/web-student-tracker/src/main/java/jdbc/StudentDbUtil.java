package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
//2. Create StudentDBUtil.java (add, delete, update...)
public class StudentDbUtil {
	private DataSource dataSource;
	// Contructor (Servelet nhan DataSource tu server sau đó gọi class
	// StudentDataUtil và bỏ resorce vao contructor để class này sd connection)
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			// không thực sự đóng nó .. chỉ đặt lại trong nhóm kết nối
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Tạo dl dsStudent
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// get a connection
			con = dataSource.getConnection();
			// create sql stattemnet
			String query = "select * from student order by lastName desc";
			stmt = con.createStatement();
			// execute query
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");
				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email, imageUrl);
				// add it to the list of student
				students.add(tempStudent);
			}
			return students;
		} finally {
			// close JDBC object
			close(con, stmt, rs);
		}
	}

	public void addStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// get a connection
			con = dataSource.getConnection();
			// create sql for INSERT
			String query = "insert into student (firstName, lastName, email, imageUrl) values (?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			// set the param values for the student
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getImageUrl());
			// execute sql insert
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}

	public void updateStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// get a connection
			con = dataSource.getConnection();
			// create sql UPDATE statemnet
			String query = "update student set firstName=?, lastName=?, email=?, imageUrl=? where id=?";
			stmt = con.prepareStatement(query);
			// set the param values for the student
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.setString(4, student.getImageUrl());
			stmt.setInt(5, student.getId());
			// execute sql update
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}
	
	public void deleteStudent(String theStudentId) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			//convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			// get a connection
			con = dataSource.getConnection();
			// create sql DELETE statemnet
			String query = "delete student where id=?";
			//prepare statement
			stmt = con.prepareStatement(query);
			// set the param values for the student
			stmt.setInt(1, studentId);
			// execute sql datele
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}
	
	public Student getStudent(String theStudentId) throws Exception {
		Student student = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int studentId;
		try {
			// convert student id to int
			studentId = Integer.parseInt(theStudentId);
			// get connection to database
			con = dataSource.getConnection();
			// crete sql to get selected student
			String query = "select * from student where id=?";
			// create prepared statement
			stmt = con.prepareStatement(query);
			// set params
			stmt.setInt(1, studentId);
			// excecute statement
			rs = stmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");
				// use the studentId during contructor
				student = new Student(studentId, firstName, lastName, email, imageUrl);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}
			return student;
		} finally {
			close(con, stmt, rs);
		}
	}
}
