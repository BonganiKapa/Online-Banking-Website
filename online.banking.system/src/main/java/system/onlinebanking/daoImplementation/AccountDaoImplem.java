package system.onlinebanking.daoImplementation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import system.onlinebanking.bean.AccountDetailBean;
import system.onlinebanking.dao.AccountDetailDAO;

public class AccountDaoImplem implements AccountDetailDAO{

	//@Override
	public AccountDetailBean getAcc(int accNum) {
		
		Connection conn = connectionFactory.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM client_account WHERE accNum = " + accNum);
			
			if(rs.next()) {
				
				AccountDetailBean acc = new AccountDetailBean();
				
				acc.setId(rs.getInt("account_index"));
				acc.setAccNum(rs.getInt("account_number"));
				acc.setBlnce(rs.getBigDecimal("balance"));
				//acc.

				return acc;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<AccountDetailBean> getAccDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public AccountDetailBean getAccByAccNum() {
		
		Connection connect = conn.getConnection();
		Connector conn = new Connector();
		
		return null;
	}

	@Override
	public boolean insertAcc() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAcc() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAcc() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigDecimal deposit(BigDecimal dpst) {
		BigDecimal amount;
		
		return null;
	}

	@Override
	public BigDecimal transfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal withdraw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal balance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDetailBean getAcc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal deposit() {
		// TODO Auto-generated method stub
		return null;
	}

	//public AccountDetailBean  
}
