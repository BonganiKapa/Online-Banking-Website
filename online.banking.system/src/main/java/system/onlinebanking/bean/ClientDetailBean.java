package system.onlinebanking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;


//@XmlRootElement
@Entity
@Table(name = "CLIENT_DETAILS" )
public class ClientDetailBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer clientIndex;
	private String firstName;
	private String lastName;
	private String idNum;
	private String address;
	private String phone;
	private String email;
	private String password;
	private String repassword;
	private String gender;
	
	
	

public ClientDetailBean(Integer clientIndex, String firstName, String lastName, String address, String phone,
			String email, String password, String repassword) {
		super();
		this.clientIndex = clientIndex;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
	}
	public ClientDetailBean() {
	}
	
	public ClientDetailBean(String firstName, String lastName, String idNum, String address, String phone, String email,
			String password, String repassword, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNum = idNum;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.gender = gender;
	}
	@Id
	@Column(name = "CLIENT_INDEX")
	public Integer getClientIndex() {
		return clientIndex;
	}
	public void setClientIndex(Integer clientIndex) {
		this.clientIndex = clientIndex;
	}
	
	@Column(name = "NAME", length = 50)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "SURNAME", length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "ID_NUMBER", length = 20)
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
	@Column(name = "ADDRESS", length = 50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "PHONE", length = 20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "EMAIL", length = 20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "PASSWORD", length = 10)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "PASSWORD", length = 10)
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
