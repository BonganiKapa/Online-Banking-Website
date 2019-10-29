package system.onlinebanking.calculations;

import java.math.BigDecimal;

import system.onlinebanking.bean.AccountDetailBean;


public class Deposit extends AccountDetailBean {

	BigDecimal balance;
	BigDecimal transaction;
	public int getDeposit(BigDecimal amount) {
		
		@SuppressWarnings("unchecked")
		if(amount != 0) {
			balance = balance + amount;
			transaction = amount;
		}
		return amount;
	}
}