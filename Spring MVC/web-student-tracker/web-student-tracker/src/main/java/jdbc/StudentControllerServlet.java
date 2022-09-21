package jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * MVC with Servlets and JSP (Slide 20): StudentControllerServlet.java vaf 
 * Servlet implementation class StudentControllerServlet
 */
//3.Create StudentControllerServlet.java(MVC Servlet)
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;// lấy dl từ Tomcat server

	// init: khởi tạo đối tượng class studentDbUtil
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			if (theCommand == null)
				theCommand = "LIST";
			// route to the appropriate method
			//(Xử lý: Khi doGet được gọi thì tham số tên "command" trong jsp gửi cho chuỗi request values(?,?,?).Khi tham số đưuọc gửi về sẽ truyền cho doGet
			switch (theCommand) {
			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudent(request, response);
				break;
			case "LOAD":
				loadStudent(request, response);
				break;
			case "UPDATE":
				updateStudent(request, response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;
			default:
				listStudents(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students form db util
		List<Student> students = studentDbUtil.getStudents();
		// add students to the request(getStudents cho jsp không hiểu nên tạo STUDENT_LIST)
		request.setAttribute("STUDENT_LIST", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		// send to JSP page (view)
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String imageUrl = request.getParameter("imageUrl");
		// create a new student object
		Student student = new Student(firstName, lastName, email, imageUrl);
		// add the student to the database
		studentDbUtil.addStudent(student);
		// send back to main page (the student list)
		listStudents(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		String studentId = request.getParameter("studentId");
		// get student from database(db until)
		Student student = studentDbUtil.getStudent(studentId);
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", student);
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		// get student from database(db until)
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String imageUrl = request.getParameter("imageUrl");
		// update a new student object
		Student student = new Student(id, firstName, lastName, email, imageUrl);
		// add the student to the database
		studentDbUtil.updateStudent(student);
		// send back to the"list students" page
		listStudents(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		String theStudentId = request.getParameter("studentId");
		//detele the student to the database
		studentDbUtil.deleteStudent(theStudentId);
		// send back to the"list students" page
		listStudents(request, response);
	}

}
