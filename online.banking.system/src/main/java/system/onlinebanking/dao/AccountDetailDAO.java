package system.onlinebanking.dao;

import java.math.BigDecimal;
import java.util.Set;

import system.onlinebanking.bean.AccountDetailBean;

public interface AccountDetailDAO {
	
	AccountDetailBean getAcc();
	
	Set<AccountDetailBean> getAccDetails();
	AccountDetailBean getAccByAccNum();
	boolean insertAcc();
	boolean updateAcc();
	boolean deleteAcc();
	BigDecimal deposit();
	BigDecimal transfer();
	BigDecimal withdraw();
	BigDecimal balance();

	

}
