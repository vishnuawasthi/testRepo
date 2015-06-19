/**
 * 
 */
package com.ziffi.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author vawasthi
 * 
 */
public class DoctorsMembershipForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8634544258805839532L;

	private Integer id;
	private String title;
	private String firstName;
	private String lastName;
	private String experience;
	private String discription;
	private String address;
	private String hospital;
	private String availableHours;
	private String fee;
	private String registrationNumber;
	private String email;
	private String contactNumber;
	//@NotNull(message="Please select the file")
	//@NotEmpty(message="Please select the file")
	private MultipartFile displayPicture;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}

	/**
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @param discription
	 *            the discription to set
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
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
	 * @return the hospital
	 */
	public String getHospital() {
		return hospital;
	}

	/**
	 * @param hospital
	 *            the hospital to set
	 */
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	/**
	 * @return the availableHours
	 */
	public String getAvailableHours() {
		return availableHours;
	}

	/**
	 * @param availableHours
	 *            the availableHours to set
	 */
	public void setAvailableHours(String availableHours) {
		this.availableHours = availableHours;
	}

	/**
	 * @return the fee
	 */
	public String getFee() {
		return fee;
	}

	/**
	 * @param fee
	 *            the fee to set
	 */
	public void setFee(String fee) {
		this.fee = fee;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the displayPicture
	 */
	public MultipartFile getDisplayPicture() {
		return displayPicture;
	}

	/**
	 * @param displayPicture the displayPicture to set
	 */
	public void setDisplayPicture(MultipartFile displayPicture) {
		this.displayPicture = displayPicture;
	}

}
