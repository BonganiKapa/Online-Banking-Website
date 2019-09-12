package system.onlinebanking.bean;

import system.onlinebanking.enums.Gender;

public class ClientDetailBean {

	
	private Integer clientIndex;
	private String firstName;
	private String lastName;
	private String idNum;
	private String address;
	private String phone;
	private String email;
	private String password;
	private String repassword;
	private Gender gender;
	
	
	
	public ClientDetailBean(Integer clientIndex, String firstName, String lastName, String idNum, String address,
			String phone, String email, String password, String repassword, Gender gender) {
		super();
		this.clientIndex = clientIndex;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNum = idNum;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.repassword = password;
		this.gender = gender;
	}
	public Integer getClientIndex() {
		return clientIndex;
	}
	public void setClientIndex(Integer clientIndex) {
		this.clientIndex = clientIndex;
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
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	
}
