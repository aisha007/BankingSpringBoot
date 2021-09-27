package com.p1.example.rest.customer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
		Integer custid; 
		String cname; 
		String dob; 
		String mail_id;
		public Customer(){
			
		}
		public Customer(int custid, String cname, String dob, String mail_id) {
			this.custid = custid;
			this.cname = cname;
			this.dob = dob;
			this.mail_id = mail_id;
		}
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer getCustid() {
			return custid;
		}
		public void setCustid(int custid) {
			this.custid = custid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getMail_id() {
			return mail_id;
		}
		public void setMail_id(String mail_id) {
			this.mail_id = mail_id;
		}
		@Override
		public String toString() {
			return "Product [custid=" + custid + ", cname=" + cname + ", dob=" + dob + ", mail_id=" + mail_id + "]";
		}
	    
}
