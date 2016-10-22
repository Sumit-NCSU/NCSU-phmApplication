package com.model;

public class PersonDTO {

	private int personId;
	private String personName;
	private String username;
	private String password;
	private String address;
	private String dob;
	private String gender;

	/**
	 * default constructor
	 */
	public PersonDTO() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param personId
	 *            the person ID
	 * @param personName
	 *            the person name
	 * @param username
	 *            the user name
	 * @param password
	 *            the password
	 * @param address
	 *            the address
	 * @param dob
	 *            the date of birth
	 * @param gender
	 *            the gender
	 */
	public PersonDTO(int personId, String personName, String username, String password, String address, String dob,
			String gender) {
		this.personId = personId;
		this.personName = personName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
}
