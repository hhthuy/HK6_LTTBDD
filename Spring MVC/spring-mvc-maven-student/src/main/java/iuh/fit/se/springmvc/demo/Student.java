package iuh.fit.se.springmvc.demo;


public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	

	public Student() {
	}

	
	public Student(String firstName, String lastName, String country, String favoriteLanguage,
			String[] operatingSystems) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.favoriteLanguage = favoriteLanguage;
		this.operatingSystems = operatingSystems;
	}


	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	
}
