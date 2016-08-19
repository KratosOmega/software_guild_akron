package com.swcguild.simplebank.service;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import java.util.List;

public interface SimpleBankService {
	
	public void createAccountHolder(AccountHolder acctHolder);
        
        public void updateAccountHolder(AccountHolder acctHolder);
	
	public AccountHolder getAccountHolder(int id);
        
        public List<AccountHolder> getAllAccountHolders();
	
	public void createAccount(Account acct);
	
	public Account getAccount(int id);
        
        public List<Account> getAccountsForAccountHolder(AccountHolder holder);
	
	public void depositFunds(Account acct, double amount, String note);
	
	public void withdrawFunds(Account acct, double amount, String note);
        
        public DepositWithdrawal getDepositWithdrawal(int id);
        
        public List<DepositWithdrawal> getAllDepsositsWithdrawalsForAccount(Account account);
	
	public void transferFunds(Account toAcct, Account fromAcct, double amount);
        
        public Transfer getTransfer(int id);
        
        public List<Transfer> getAllOutgoingTransfersForAccount(Account account);
        
        public List<Transfer> getAllIncomingTransfersForAccount(Account account);
}
