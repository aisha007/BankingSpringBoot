package com.p1.example.rest.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
		String acctype;
		String accname;
		public Account(){
			
		}
		public Account(String acctype, String accname) {
			
			this.acctype = acctype;
			this.accname = accname;
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
			return "Account [acctype=" + acctype + ", accname=" + accname + "]";
		}
		
		
		
		
		
		
		
		
}
