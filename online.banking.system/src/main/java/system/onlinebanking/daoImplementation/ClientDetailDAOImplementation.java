package system.onlinebanking.daoImplementation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import system.onlinebanking.bean.ClientDetailBean;
import system.onlinebanking.bean.ClientLogin;
import system.onlinebanking.dao.ClientDetailDAO;

public class ClientDetailDAOImplementation implements ClientDetailDAO{
	
	@Autowired
	DataSource ds;
	
	@Autowired
	JdbcTemplate jdbc;
	

	//@Override
	public void register(ClientDetailBean clientBean) {
		String sql = "INSERT INTO client_account values ?,?,?,?,?,?,?,?";
		
		jdbc.update(sql, new Object[] {clientBean.getClientIndex(), clientBean.getFirstName(), clientBean.getLastName(),
				clientBean.getIdNum(), clientBean.getGender(), clientBean.getPhone(), clientBean.getEmail(), clientBean.getPassword(), clientBean.getRepassword()});
		
	}

	//@Override
	public ClientDetailBean validateClient(ClientLogin login) {
		
		String sql = "SELECT * FROM client_account WHERE client = '" + login.getClientName() + "' AND password '" + login.getPassword() + "'";
		
		return null;
	}
	
	

}
