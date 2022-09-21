package jdbc;
/**
 * MVC WEB App with JDBC
 *Todo List Student
� Create table sql: Create database web_student_tracker
� Create Student.java
� Create StudentDBUtil.java (add, delete, update...)
� Create StudentControllerServlet.java(MVC Servlet)
� Create JSP page: list-students.jsp
 */
//1. Create Student.java
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String imageUrl;

	public Student(int id, String firstName, String lastName, String email, String imageUrl) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imageUrl = imageUrl;
	}

	public Student(String firstName, String lastName, String email, String imageUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", imageUrl=" + imageUrl + "]";
	}
	
	

}
