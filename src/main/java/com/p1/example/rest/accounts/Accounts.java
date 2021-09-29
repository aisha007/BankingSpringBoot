package com.p1.example.rest.accounts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {
		int acct_num, custid;
		String acc_type;
		String dateofopening;
		int Bal;
		String astatus;
		public Accounts(){
			
		}
		public Accounts(int acct_num, int custid, String acc_type, String dateofopening, int bal, String astatus) {
			super();
			this.acct_num = acct_num;
			this.custid = custid;
			this.acc_type = acc_type;
			this.dateofopening = dateofopening;
			Bal = bal;
			this.astatus = astatus;
		}
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getAcct_num() {
			return acct_num;
		}
		public void setAcct_num(int acct_num) {
			this.acct_num = acct_num;
		}
		public int getCustid() {
			return custid;
		}
		public void setCustid(int custid) {
			this.custid = custid;
		}
		public String getAcc_type() {
			return acc_type;
		}
		public void setAcc_type(String acc_type) {
			this.acc_type = acc_type;
		}
		public String getDateofopening() {
			return dateofopening;
		}
		public void setDateofopening(String dateofopening) {
			this.dateofopening = dateofopening;
		}
		public int getBal() {
			return Bal;
		}
		public void setBal(int bal) {
			Bal = bal;
		}
		public String getAstatus() {
			return astatus;
		}
		public void setAstatus(String astatus) {
			this.astatus = astatus;
		}
		@Override
		public String toString() {
			return "Accounts [acct_num=" + acct_num + ", custid=" + custid + ", acc_type=" + acc_type
					+ ", dateofopening=" + dateofopening + ", Bal=" + Bal + ", astatus=" + astatus + "]";
		}
		
		
		
}
