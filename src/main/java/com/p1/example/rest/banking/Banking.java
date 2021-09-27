package com.p1.example.rest.banking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banking {
	int trn_num, acc_num;
	String dateoftrn;
	int amount;

	public Banking() {
		
	}

	public Banking(int trn_num, int acc_num, String dateOftrn, int amount) {
		this.trn_num = trn_num;
		this.acc_num = acc_num;
		this.dateoftrn = dateOftrn;
		this.amount = amount;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTrn_num() {
		return trn_num;
	}

	public void setTrn_num(int trn_num) {
		this.trn_num = trn_num;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}

	public String getDateoftrn() {
		return dateoftrn;
	}

	public void setDateoftrn(String dateoftrn) {
		this.dateoftrn = dateoftrn;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Banking [trn_num=" + trn_num + ", acc_num=" + acc_num + ", dateOftrn=" + dateoftrn + ", amount=" + amount
				+ "]";
	}

}
