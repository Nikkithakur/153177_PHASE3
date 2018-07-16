package com.cg.mypaymentapp.repo;

import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo {

public boolean save(Customer customer) throws Exception  ;
	
	public Customer findOne(String mobileNo);
	
}
