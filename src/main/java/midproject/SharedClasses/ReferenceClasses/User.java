package midproject.SharedClasses.ReferenceClasses;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String userType;
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthdate;
	private String age;
	private String gender;
	private String personWithDisability;
	private String email;
	private String contactNumber;
	private String username;
	private String password;
	private String confirmPassword;
	private String street;
	private String additionalAddressDetails;
	private String city;
	private String province;
	private String zip;

	public User (){

	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPersonWithDisability(String personWithDisability) {
		this.personWithDisability = personWithDisability;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword){this.confirmPassword = confirmPassword;}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Constructor for creating a UserInformation object with all available details.
	 *
	 * @param userId                   The unique identifier for the user.
	 * @param userType                 The type of the user (e.g., admin, customer).
	 * @param firstName                The first name of the user.
	 * @param lastName                 The last name of the user.
	 * @param middleName               The middle name of the user.
	 * @param birthdate                The birthdate of the user.
	 * @param age                      The age of the user.
	 * @param gender                   The gender of the user.
	 * @param personWithDisability     Indicates if the user has a disability.
	 * @param email                    The email address of the user.
	 * @param contactNumber            The contact number of the user.
	 * @param username                 The username used for authentication.
	 * @param password                 The password used for authentication.
	 * @param street                   The street address of the user.
	 * @param additionalAddressDetails Additional details about the address.
	 * @param city                     The city of residence of the user.
	 * @param province                 The province of residence of the user.
	 * @param zip                      The ZIP code of the user's location.
	 */
	public User (String userId, String userType,
						   String firstName, String lastName,
						   String middleName, String birthdate,
						   String age, String gender,
						   String personWithDisability,
						   String email, String contactNumber,
						   String username, String password, String confirmPassword,
						   String street, String additionalAddressDetails,
						   String city, String province, String zip) {
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.birthdate = birthdate;
		this.age = age;
		this.gender = gender;
		this.personWithDisability = personWithDisability;
		this.email = email;
		this.contactNumber = contactNumber;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.street = street;
		this.additionalAddressDetails = additionalAddressDetails;
		this.city = city;
		this.province = province;
		this.zip = zip;
	}

	/**
	 * Getter for the user ID.
	 *
	 * @return The user ID.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Setter for the user type.
	 *
	 * @param userType The type of the user.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * Getter for the user type.
	 *
	 * @return The type of the user.
	 */
	// Getter for userType
	public String getUserType() {
		return this.userType;
	}

	/**
	 * Getter for the first name of the user.
	 *
	 * @return The first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for the last name of the user.
	 *
	 * @return The last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter for the middle name of the user.
	 *
	 * @return The middle name of the user.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Getter for the birthdate of the user.
	 *
	 * @return The birthdate of the user.
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * Getter for the age of the user.
	 *
	 * @return The age of the user.
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Setter for the age of the user.
	 *
	 * @param age The age to set for the user.
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Getter for the gender of the user.
	 *
	 * @return The gender of the user.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Getter for whether the user has a disability.
	 *
	 * @return A string indicating whether the user has a disability.
	 */
	public String getPersonWithDisability() {
		return personWithDisability;
	}

	/**
	 * Getter for the email address of the user.
	 *
	 * @return The email address of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getter for the contact number of the user.
	 *
	 * @return The contact number of the user.
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Getter for the username used for authentication.
	 *
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter for the password used for authentication.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Getter for the confirmation password used for authentication.
	 *
	 * @return The password of the user.
	 */

	public String getConfirmPassword(){return  confirmPassword;}

	/**
	 * Getter for the street address of the user.
	 *
	 * @return The street address of the user.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Getter for additional details about the address of the user.
	 *
	 * @return Additional details about the address of the user.
	 */
	public String getAdditionalAddressDetails() {
		return additionalAddressDetails;
	}

	/**
	 * Setter for additional details about the address of the user.
	 *
	 * @param additionalAddressDetails Additional details to set for the address of the user.
	 */
	public void setAdditionalAddressDetails(String additionalAddressDetails) {
		this.additionalAddressDetails = additionalAddressDetails;
	}

	/**
	 * Getter for the city of residence of the user.
	 *
	 * @return The city of residence of the user.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Getter for the province of residence of the user.
	 *
	 * @return The province of residence of the user.
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Getter for the ZIP code of the user's location.
	 *
	 * @return The ZIP code of the user's location.
	 */
	public String getZip() {
		return zip;
	}

    public boolean isArchived() { return isArchived();
    }
}