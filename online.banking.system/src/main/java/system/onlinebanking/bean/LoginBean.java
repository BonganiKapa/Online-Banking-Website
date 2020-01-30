package system.onlinebanking.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_DETAILS" )
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
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
	
	

}
