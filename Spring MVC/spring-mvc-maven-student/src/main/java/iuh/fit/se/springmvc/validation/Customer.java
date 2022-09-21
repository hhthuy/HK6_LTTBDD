package iuh.fit.se.springmvc.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Customer {
	//@CourseCode(value="TOPS", message="must start with TOPS")
	private String courseCode;
	
	@Pattern(regexp="^[a-zA-Z0-9]", message = "only 5 chars/digits")
	private String postalCode;
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	@NotNull(message ="is required")
	@Size(min=1, message = "is required")
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@NotNull(message="is required")
	@Min(value=0, message="must be less than or equal to 10")
	@Max(value=10, message="must be less than or equal to 10")
	private Integer freePasses;//We cannot validate NotNull with int
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
	
	

	
	
	
	

}
