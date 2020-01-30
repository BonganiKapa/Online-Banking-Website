package system.onlinebanking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class BankBean {

	private static final long serialVersionUID = 1L;
	
	private int accId;
	private int blnce;
	private int dpst;
	private int wtdrw;
	private int trnsf;
	
	
	public BankBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "")
	public int getAccId() {
		return accId;
	}


	public void setAccId(int accId) {
		this.accId = accId;
	}

	@Column(name = "", length = 50)
	public int getBlnce() {
		return blnce;
	}


	public void setBlnce(int blnce) {
		this.blnce = blnce;
	}

	@Column(name = "", length = 50)
	public int getDpst() {
		return dpst;
	}


	public void setDpst(int dpst) {
		this.dpst = dpst;
	}

	@Column(name = "", length = 50)
	public int getWtdrw() {
		return wtdrw;
	}


	public void setWtdrw(int wtdrw) {
		this.wtdrw = wtdrw;
	}

	@Column(name = "", length = 50)
	public int getTrnsf() {
		return trnsf;
	}


	public void setTrnsf(int trnsf) {
		this.trnsf = trnsf;
	}
}
