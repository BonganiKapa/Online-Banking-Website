package system.onlinebanking.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import system.onlinebanking.calculations.Balance;
import system.onlinebanking.calculations.Deposit;
import system.onlinebanking.calculations.Transfer;
import system.onlinebanking.calculations.Withdrawals;

@Entity
@Table(name = "Client_Account")
public class AccountDetailBean implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_index")
	private int id;

	@ManyToOne
	@JoinColumn(name = "client_index")
	private ClientDetailBean cdb;

	@Column(name = "type")
	private String type;

	@Column(name = "account_number")
	private int accNum;

	@Column(name = "balance")
	private Balance blnce;

	@Column(name = "withdrawals")
	private Withdrawals withdraw;

	@Column(name = "deposit")
	private Deposit dpst;

	@Column(name = "transfer")
	private Transfer tf;

	@Column(name = "transactions")
	private BigDecimal taHistory;

	public AccountDetailBean() {
		super();
	}
	

	public AccountDetailBean(int id, ClientDetailBean cdb, String type, int accNum, Balance blnce,
			Withdrawals withdraw, Deposit dpst, Transfer tf, BigDecimal taHistory) {
		super();
		this.id = id;
		this.cdb = cdb;
		this.type = type;
		this.accNum = accNum;
		this.blnce = blnce;
		this.withdraw = withdraw;
		this.dpst = dpst;
		this.tf = tf;
		this.taHistory = taHistory;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClientDetailBean getCdb() {
		return cdb;
	}

	public void setCdb(ClientDetailBean cdb) {
		this.cdb = cdb;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public Balance getBlnce() {
		return blnce;
	}

	public void setBlnce(Balance blnce) {
		this.blnce = blnce;
	}

	public Withdrawals getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Withdrawals withdraw) {
		this.withdraw = withdraw;
	}

	public Deposit getDpst() {
		return dpst;
	}

	public void setDpst(Deposit dpst) {
		this.dpst = dpst;
	}

	public Transfer getTf() {
		return tf;
	}

	public void setTf(Transfer tf) {
		this.tf = tf;
	}

	public BigDecimal getTaHistory() {
		return taHistory;
	}

	public void setTaHistory(BigDecimal taHistory) {
		this.taHistory = taHistory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNum;
		result = prime * result + ((blnce == null) ? 0 : blnce.hashCode());
		result = prime * result + ((cdb == null) ? 0 : cdb.hashCode());
		result = prime * result + ((dpst == null) ? 0 : dpst.hashCode());
		result = prime * result + id;
		result = prime * result + ((taHistory == null) ? 0 : taHistory.hashCode());
		result = prime * result + ((tf == null) ? 0 : tf.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((withdraw == null) ? 0 : withdraw.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDetailBean other = (AccountDetailBean) obj;
		if (accNum != other.accNum)
			return false;
		if (blnce == null) {
			if (other.blnce != null)
				return false;
		} else if (!blnce.equals(other.blnce))
			return false;
		if (cdb == null) {
			if (other.cdb != null)
				return false;
		} else if (!cdb.equals(other.cdb))
			return false;
		if (dpst == null) {
			if (other.dpst != null)
				return false;
		} else if (!dpst.equals(other.dpst))
			return false;
		if (id != other.id)
			return false;
		if (taHistory == null) {
			if (other.taHistory != null)
				return false;
		} else if (!taHistory.equals(other.taHistory))
			return false;
		if (tf == null) {
			if (other.tf != null)
				return false;
		} else if (!tf.equals(other.tf))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (withdraw == null) {
			if (other.withdraw != null)
				return false;
		} else if (!withdraw.equals(other.withdraw))
			return false;
		return true;
	}

	
}
