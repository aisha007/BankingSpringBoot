package com.p1.example;

import com.p1.example.registration.EurekaServer;
import com.p1.example.rest.account_ctg.Account_ctgServer;
import com.p1.example.rest.accounts.AccountsServer;
import com.p1.example.rest.banking.BankingServer;
import com.p1.example.rest.customer.CustomerServer;
//import com.p1.example.rest.subtraction.SubtractionServer;
import com.p1.example.web.WebServer;

public class Main {
	public static void main(String[] args) {

		String serverName = "";

		switch (args.length) {
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			return;
		}

		if (serverName.equals("eureka")) {
			EurekaServer.main(args);
		} else if (serverName.equals("customer")) {
			CustomerServer.main(args);
		} 
		else if (serverName.equals("accounts")) {
			AccountsServer.main(args);
		}
		else if (serverName.equals("banking")) {
			BankingServer.main(args);
		}
		else if (serverName.equals("account_ctg")) {
			Account_ctgServer.main(args);
		}
		else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
		}
	}
}
