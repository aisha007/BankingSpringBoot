package com.p1.example.rest.account_ctg;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account_ctg {
	private String acctype;
	private String accname;
	public Account_ctg(String acctype, String accname) {
		super();
		this.acctype = acctype;
		this.accname = accname;
	}
	public Account_ctg()
	{
		
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	@Override
	public String toString() {
		return "Account_Ctg [acctype=" + acctype + ", accname=" + accname + "]";
	}
	


}
