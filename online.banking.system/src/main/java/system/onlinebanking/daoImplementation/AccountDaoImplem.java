package system.onlinebanking.daoImplementation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import system.onlinebanking.bean.AccountDetailBean;
import system.onlinebanking.calculations.Deposit;
import system.onlinebanking.dao.AccountDetailDAO;
import system.onlinebanking.model.DBConnector;


//@SuppressWarnings("unchecked")
public class AccountDaoImplem implements AccountDetailDAO{

	
	//@Override
	//Getting new Account if Doesn't exist
	public AccountDetailBean getAcc(int accNum) {
		
		DBConnector dbcon = new DBConnector();
		Connection con = dbcon.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM client_account WHERE accNum = " + accNum);
			
			if(rs.next()) {
				
				AccountDetailBean acc = new AccountDetailBean();
				
				acc.setId(rs.getInt("account_index"));
				acc.setAccNum(rs.getInt("account_number"));
				acc.setBlnce(rs.getBigDecimal("balance"));
				acc.setTaHistory(rs.getBigDecimal("transactions"));
				
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
	//Get client by Account Number
	public AccountDetailBean getAccByAccNum(String accNum) {
		
		DBConnector dbcon = new DBConnector();
		Connection con = dbcon.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client_account WHERE accNum = ?");
			ps.setString(1, accNum);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return getAcc();
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//@Override
	public boolean insertAcc(AccountDetailBean accBean) {
		
		DBConnector dbcon = new DBConnector();
		Connection con = dbcon.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO client_account VALUES (?,?,?,?,?,?,?,?)");
			ps.setInt(1, accBean.getId());
			ps.setString(2, accBean.getType());
			ps.setInt(3, accBean.getAccNum());
			ps.setFloat(4, accBean.getBlnce());
			ps.setBigDecimal(5, accBean.getWithdraw());
			ps.setBigDecimal(6, accBean.getDpst());
			ps.setBigDecimal(7, accBean.getTf());
			ps.setBigDecimal(8, accBean.getTaHistory());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				return true;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	//@Override
	public boolean updateAcc(AccountDetailBean accBean) {
		
		DBConnector dbcon = new DBConnector();
		Connection con = dbcon.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE client_account SET accType=? WHERE id=? ");
			ps.setString(1, accBean.getType());
			ps.setInt(2, accBean.getId());
			
		}
		catch (SQLException ex) {
	        ex.printStackTrace();
	    }

		return false;
	}

	//@Override
	public boolean deleteAcc() {
		// TODO Auto-generated method stub
		return false;
	}

	public BigDecimal deposit(Deposit dpst) throws SQLException {
		
		DBConnector dbcon = new DBConnector();
		Connection con = dbcon.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE client_account SET deposit=? WHERE id=?");
		ps.getInt(1, dpst.getDpst());
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
	public AccountDetailBean getAccByAccNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertAcc() {
		// TODO Auto-generated method stub
		return false;
	}

}
