package com.swcguild.simplebank.persistence;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import java.util.List;

public interface SimpleBankDAO {
	
	public void addAccountHolder(AccountHolder accountHolder);
        
        public void updateAccountHolder(AccountHolder accountHolder);
	
	public AccountHolder getAccountHolderById(int id);
        
        public List<AccountHolder> getAllAccountHolders();
	
	public void addAccount(Account account);
	
	public void updateAccount(Account account);
	
	public Account getAccountById(int id);
        
        public List<Account> getAccountsByAccountHolderId(int id);
	
	public void addDepositWithdrawal(DepositWithdrawal depositWithdrawal);
	
	public DepositWithdrawal getDepositWithdrawalById(int id);
        
        public List<DepositWithdrawal> getDepositsWithdrawalsByAccountId(int id);
	
	public void addTransfer(Transfer transfer);
	
	public Transfer getTransferById(int id);
        
        public List<Transfer> getTransfersByToAccountId(int id);
        
        public List<Transfer> getTransfersByFromAccountId(int id);

}
