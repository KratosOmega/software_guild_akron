package com.swcguild.simplebank.persistence;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import com.swcguild.simplebank.service.SimpleBankService;
import java.util.List;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class SimpleBankServiceTest extends TestCase {

    protected SimpleBankService service;

    protected void setUp() throws Exception {
        super.setUp();
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "test-application-context.xml");
        service = (SimpleBankService) ctx.getBean("simpleBankService");
    }

    protected void tearDown() throws Exception {
        super.setUp();
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "test-application-context.xml");
        JdbcTemplate cleanupTemplate = (JdbcTemplate) ctx
                .getBean("jdbcTemplate");
        cleanupTemplate.execute("delete from deposits_withdrawals");
        cleanupTemplate.execute("delete from transfers");
        cleanupTemplate.execute("delete from accounts");
        cleanupTemplate.execute("delete from account_holders");
    }

    public void testCreateGetAccountHolder() {
        AccountHolder holder = new AccountHolder();
        holder.setName("CreateGet Holder");
        service.createAccountHolder(holder);
        assertTrue(holder.getId() != 0);
        AccountHolder newHolder = service.getAccountHolder(holder.getId());
        assertTrue(holder.getId() == newHolder.getId());
        assertTrue(holder.getName().equals(newHolder.getName()));
    }

    public void testGetAllAccountHolders() {
        AccountHolder holder = new AccountHolder();
        holder.setName("GetAll1 Holder");
        service.createAccountHolder(holder);

        AccountHolder holder2 = new AccountHolder();
        holder2.setName("GetAll2 Holder");
        service.createAccountHolder(holder2);

        List<AccountHolder> holders = service.getAllAccountHolders();
        assertTrue(holders.size() == 2);
    }

    public void testCreateGetAccount() {
        AccountHolder holder = new AccountHolder();
        holder.setName("SvcCrAcct Test");
        service.createAccountHolder(holder);
        Account acct = new Account();
        acct.setAccountHolderId(holder.getId());
        acct.setBalance(10.00);
        service.createAccount(acct);
        Account acct2 = service.getAccount(acct.getId());
        assertTrue(acct2.getBalance() == 10.00);
        assertTrue(acct2.getAccountHolderId() == acct.getAccountHolderId());
    }

    public void testGetAccountForAccountHolder() {
        AccountHolder holder = new AccountHolder();
        holder.setName("GetAccts Test");
        service.createAccountHolder(holder);
        Account acct = new Account();
        acct.setAccountHolderId(holder.getId());
        acct.setBalance(10.00);
        service.createAccount(acct);
        assertTrue(acct.getId() != 0);

        Account acct2 = new Account();
        acct2.setAccountHolderId(holder.getId());
        acct2.setBalance(20.00);
        service.createAccount(acct2);
        assertTrue(acct2.getId() != 0);

        List<Account> accts = service.getAccountsForAccountHolder(holder);
        assertTrue(accts.size() == 2);
    }

    public void testDepositFunds() {
        AccountHolder holder = new AccountHolder();
        holder.setName("ServiceDep Test");
        service.createAccountHolder(holder);
        Account acct = new Account();
        acct.setAccountHolderId(holder.getId());
        acct.setBalance(10.00);
        service.createAccount(acct);
        service.depositFunds(acct, 42.00, "This is a test deposit");
        assertTrue(acct.getBalance() == 52.00);

    }

    public void testWithdrawFunds() {
        AccountHolder holder = new AccountHolder();
        holder.setName("ServiceWd Test");
        service.createAccountHolder(holder);
        Account acct = new Account();
        acct.setAccountHolderId(holder.getId());
        acct.setBalance(42.00);
        service.createAccount(acct);
        service.withdrawFunds(acct, 10.00, "This is a test withdrawal");
        assertTrue(acct.getBalance() == 32.00);
    }

    public void testGetAllDepositsWithdrawalsForAccount() {
        AccountHolder holder = new AccountHolder();
        holder.setName("GetAllDW Test");
        service.createAccountHolder(holder);
        Account acct = new Account();
        acct.setAccountHolderId(holder.getId());
        acct.setBalance(10.00);
        service.createAccount(acct);
        service.depositFunds(acct, 42.00, "This is a test deposit");
        service.withdrawFunds(acct, 12.00, "This is a test withdrawal");
        List<DepositWithdrawal> dws = service.getAllDepsositsWithdrawalsForAccount(acct);
        assertTrue(dws.size() == 2);
    }

    public void testTransferFunds() {
        AccountHolder toAcctHolder = new AccountHolder();
        toAcctHolder.setName("XferTo Test");
        service.createAccountHolder(toAcctHolder);
        Account toAcct = new Account();
        toAcct.setAccountHolderId(toAcctHolder.getId());
        toAcct.setBalance(10.00);
        service.createAccount(toAcct);
        assertTrue(toAcct.getId() != 0);

        AccountHolder fromAcctHolder = new AccountHolder();
        fromAcctHolder.setName("XferFrom Test");
        service.createAccountHolder(fromAcctHolder);
        Account fromAcct = new Account();
        fromAcct.setAccountHolderId(fromAcctHolder.getId());
        fromAcct.setBalance(10.00);
        service.createAccount(fromAcct);
        assertTrue(fromAcct.getId() != 0);

        service.transferFunds(toAcct, fromAcct, 5.00);
        assertTrue(toAcct.getBalance() == 15.00);
        assertTrue(fromAcct.getBalance() == 5.00);

    }

    public void testGetAllIncomingOutgoingTransfersForAccount() {
        AccountHolder toAcctHolder = new AccountHolder();
        toAcctHolder.setName("XferTo Test");
        service.createAccountHolder(toAcctHolder);
        Account toAcct = new Account();
        toAcct.setAccountHolderId(toAcctHolder.getId());
        toAcct.setBalance(10.00);
        service.createAccount(toAcct);
        assertTrue(toAcct.getId() != 0);

        AccountHolder fromAcctHolder = new AccountHolder();
        fromAcctHolder.setName("XferFrom Test");
        service.createAccountHolder(fromAcctHolder);
        Account fromAcct = new Account();
        fromAcct.setAccountHolderId(fromAcctHolder.getId());
        fromAcct.setBalance(10.00);
        service.createAccount(fromAcct);
        assertTrue(fromAcct.getId() != 0);

        service.transferFunds(toAcct, fromAcct, 5.00);
        assertTrue(toAcct.getBalance() == 15.00);
        assertTrue(fromAcct.getBalance() == 5.00);

        service.transferFunds(toAcct, fromAcct, 3.00);
        assertTrue(toAcct.getBalance() == 18.00);
        assertTrue(fromAcct.getBalance() == 2.00);
        
        List<Transfer> inTransfers = service.getAllIncomingTransfersForAccount(toAcct);
        assertTrue(inTransfers.size() == 2);
        List<Transfer> outTransfers = service.getAllOutgoingTransfersForAccount(fromAcct);
        assertTrue(outTransfers.size() == 2);
        
        // Should not have any incoming transfers for the fromAcct
        inTransfers = service.getAllIncomingTransfersForAccount(fromAcct);
        assertTrue(inTransfers.size() == 0);
        // Should not have any outgoing transfers for the toAcct
        outTransfers = service.getAllOutgoingTransfersForAccount(toAcct);
        assertTrue(outTransfers.size() == 0);
    }
}
