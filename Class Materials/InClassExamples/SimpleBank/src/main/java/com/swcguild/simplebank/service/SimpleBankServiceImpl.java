package com.swcguild.simplebank.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import com.swcguild.simplebank.persistence.SimpleBankDAO;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

// Uncomment if configuration is moved to annotation driven
//@Service("simpleBankService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SimpleBankServiceImpl implements SimpleBankService {

//  Uncomment if configuration is moved to annotation driven    
//    @Autowired
//    @Qualifier("simpleBankDAO")
    private SimpleBankDAO dao;

    public SimpleBankServiceImpl() {
    }
    

//    public SimpleBankServiceImpl(SimpleBankDAO dao) {
//        this.dao = dao;
//    }

    public SimpleBankDAO getDao() {
        return dao;
    }

    // Comment out if configuration is moved to annotation driven
    @Inject
    public void setDao(SimpleBankDAO dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void createAccountHolder(AccountHolder acctHolder) {
        dao.addAccountHolder(acctHolder);
    }
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void updateAccountHolder(AccountHolder acctHolder) {
        dao.updateAccountHolder(acctHolder);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AccountHolder getAccountHolder(int id) {
        return dao.getAccountHolderById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AccountHolder> getAllAccountHolders() {
        List<AccountHolder> holders = dao.getAllAccountHolders();
        return holders;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void createAccount(Account acct) {
        dao.addAccount(acct);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Account getAccount(int id) {
        return dao.getAccountById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Account> getAccountsForAccountHolder(AccountHolder holder) {
        return dao.getAccountsByAccountHolderId(holder.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void depositFunds(Account acct, double amount, String note) {
        // create the deposit record
        DepositWithdrawal dep = new DepositWithdrawal();
        dep.setAccountId(acct.getId());
        dep.setAmount(amount);
        dep.setNote(note);
        dao.addDepositWithdrawal(dep);

        // update the account balance
        acct.setBalance(acct.getBalance() + amount);
        dao.updateAccount(acct);

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void withdrawFunds(Account acct, double amount, String note) {
        depositFunds(acct, -amount, note);

    }
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public DepositWithdrawal getDepositWithdrawal(int id) {
        return dao.getDepositWithdrawalById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<DepositWithdrawal> getAllDepsositsWithdrawalsForAccount(Account account) {
        return dao.getDepositsWithdrawalsByAccountId(account.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transferFunds(Account toAcct, Account fromAcct, double amount) {
        // create transfer record
        Transfer transfer = new Transfer();
        transfer.setToAccount(toAcct.getId());
        transfer.setFromAccount(fromAcct.getId());
        transfer.setAmount(amount);
        dao.addTransfer(transfer);

        // update to account balance
        toAcct.setBalance(toAcct.getBalance() + amount);
        dao.updateAccount(toAcct);

        // update from account balance
        fromAcct.setBalance(fromAcct.getBalance() - amount);
        dao.updateAccount(fromAcct);
    }
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Transfer getTransfer(int id) {
        return dao.getTransferById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Transfer> getAllOutgoingTransfersForAccount(Account account) {
        return dao.getTransfersByFromAccountId(account.getId());
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Transfer> getAllIncomingTransfersForAccount(Account account) {
        return dao.getTransfersByToAccountId(account.getId());
    }
}
