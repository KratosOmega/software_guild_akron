package com.swcguild.simplebank.persistence;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import java.util.List;
import static junit.framework.Assert.assertTrue;

public class SimpleBankDaoTest extends TestCase {

    @Autowired
    protected SimpleBankDAO dao;
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "test-application-context.xml");
        dao = (SimpleBankDAO) ctx.getBean("simpleBankDAO");
    }

    @Override
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
        cleanupTemplate = null;
    }

    public void testAccountHolderPutGet() {
        AccountHolder holder = new AccountHolder();
        assertTrue(holder.getId() == 0);
        holder.setName("Johnny Test");
        dao.addAccountHolder(holder);
        System.out.println("New ID = " + holder.getId());
        assertTrue(holder.getId() != 0);
        AccountHolder newHolder = dao.getAccountHolderById(holder.getId());
        assertTrue(newHolder.getName().equals(holder.getName()));
        assertTrue(newHolder.getId() == holder.getId());
    }

    public void testAccountHolderUpdate() {
        AccountHolder holder = new AccountHolder();
        assertTrue(holder.getId() == 0);
        holder.setName("Johnny Test");
        dao.addAccountHolder(holder);
        System.out.println("New ID = " + holder.getId());
        assertTrue(holder.getId() != 0);
        AccountHolder newHolder = dao.getAccountHolderById(holder.getId());
        assertTrue(newHolder.getName().equals(holder.getName()));
        assertTrue(newHolder.getId() == holder.getId());
        holder.setName("UPDATE");
        dao.updateAccountHolder(holder);
        newHolder = dao.getAccountHolderById(holder.getId());
        assertTrue(newHolder.getName().equals(holder.getName()));
        assertTrue(newHolder.getId() == holder.getId());
    }

    public void testGetAllAccountHolders() {
        AccountHolder holder = new AccountHolder();
        assertTrue(holder.getId() == 0);
        holder.setName("Johnny Test");
        dao.addAccountHolder(holder);

        AccountHolder holder2 = new AccountHolder();
        assertTrue(holder2.getId() == 0);
        holder2.setName("Johnny Test2");
        dao.addAccountHolder(holder2);

        List<AccountHolder> holders = dao.getAllAccountHolders();
        assertTrue(holders.size() == 2);
    }

    public void testAccountPutGet() {
        // create a known account holder
        AccountHolder holder = new AccountHolder();
        holder.setName("AccountPutGet Test");
        dao.addAccountHolder(holder);

        Account account = new Account();
        assertTrue(account.getAccountHolderId() == 0);
        account.setAccountHolderId(holder.getId());
        account.setBalance(34.65);
        dao.addAccount(account);
        Account newAccount = dao.getAccountById(account.getId());
        assertTrue(newAccount.getId() == account.getId());
        assertTrue(newAccount.getAccountHolderId() == account
                .getAccountHolderId());
        assertTrue(newAccount.getBalance() == account.getBalance());
    }

    public void testAccountGetByAccountHolderId() {
        // create a known account holder
        AccountHolder holder = new AccountHolder();
        holder.setName("ByAcctHldrId Test");
        dao.addAccountHolder(holder);

        Account account = new Account();
        assertTrue(account.getAccountHolderId() == 0);
        account.setAccountHolderId(holder.getId());
        account.setBalance(34.65);
        dao.addAccount(account);

        Account account2 = new Account();
        assertTrue(account2.getAccountHolderId() == 0);
        account2.setAccountHolderId(holder.getId());
        account2.setBalance(42.42);
        dao.addAccount(account2);

        List<Account> accts = dao.getAccountsByAccountHolderId(holder.getId());
        assertTrue(accts.size() == 2);
    }

    public void testDepositWithdrawalPutGet() {
        // create a known account holder
        AccountHolder holder = new AccountHolder();
        holder.setName("AccountPutGet Test");
        dao.addAccountHolder(holder);

        // create a known account
        Account account = new Account();
        account.setAccountHolderId(holder.getId());
        account.setBalance(45.99);
        dao.addAccount(account);

        DepositWithdrawal dw = new DepositWithdrawal();
        dw.setAccountId(account.getId());
        dw.setAmount(42.00);
        dw.setNote("This is just a test deposit");
        dao.addDepositWithdrawal(dw);
        DepositWithdrawal newDw = new DepositWithdrawal();
        newDw = dao.getDepositWithdrawalById(dw.getId());
        assertTrue(newDw.getId() != 0);
        assertTrue(newDw.getId() == dw.getId());
        assertTrue(newDw.getAmount() == dw.getAmount());
        assertTrue(newDw.getNote().equals(dw.getNote()));

        System.out.println(sdf.format(newDw.getDate()));
    }

    public void testGetDepositWithdrawalByAcctId() {
        // create a known account holder
        AccountHolder holder = new AccountHolder();
        holder.setName("AccountPutGet Test");
        dao.addAccountHolder(holder);

        // create a known account
        Account account = new Account();
        account.setAccountHolderId(holder.getId());
        account.setBalance(45.99);
        dao.addAccount(account);

        DepositWithdrawal dw = new DepositWithdrawal();
        dw.setAccountId(account.getId());
        dw.setAmount(42.00);
        dw.setNote("This is just a test deposit");
        dao.addDepositWithdrawal(dw);

        DepositWithdrawal dw2 = new DepositWithdrawal();
        dw2.setAccountId(account.getId());
        dw2.setAmount(53.00);
        dw2.setNote("This is a 2nd test deposit");
        dao.addDepositWithdrawal(dw2);

        List<DepositWithdrawal> dws = dao.getDepositsWithdrawalsByAccountId(account.getId());
        assertTrue(dws.size() == 2);
    }

    public void testTransferPutGet() {
        // create a known from account holder
        AccountHolder fromHolder = new AccountHolder();
        fromHolder.setName("From Account Holder");
        dao.addAccountHolder(fromHolder);

        // create a known from account
        Account fromAccount = new Account();
        fromAccount.setAccountHolderId(fromHolder.getId());
        fromAccount.setBalance(45.99);
        dao.addAccount(fromAccount);

        // create a known to account holder
        AccountHolder toHolder = new AccountHolder();
        toHolder.setName("To Account Holder");
        dao.addAccountHolder(toHolder);

        // create a known to account
        Account toAccount = new Account();
        toAccount.setAccountHolderId(toHolder.getId());
        toAccount.setBalance(77.99);
        dao.addAccount(toAccount);

        // create and test a transfer
        Transfer transfer = new Transfer();
        transfer.setFromAccount(fromAccount.getId());
        transfer.setToAccount(toAccount.getId());
        transfer.setAmount(102.54);
        dao.addTransfer(transfer);

        assertTrue(transfer.getId() != 0);

        Transfer newTransfer = dao.getTransferById(transfer.getId());
        System.out.println(sdf.format(newTransfer.getDate()));

        assertTrue(newTransfer.getId() == transfer.getId());
        assertTrue(newTransfer.getFromAccount() == transfer.getFromAccount());
        assertTrue(newTransfer.getToAccount() == transfer.getToAccount());
        assertTrue(newTransfer.getAmount() == transfer.getAmount());
    }

    public void testGetTransferByToAcct() {
        // create a known from account holder
        AccountHolder fromHolder = new AccountHolder();
        fromHolder.setName("From Account Holder");
        dao.addAccountHolder(fromHolder);

        // create a known from account
        Account fromAccount = new Account();
        fromAccount.setAccountHolderId(fromHolder.getId());
        fromAccount.setBalance(45.99);
        dao.addAccount(fromAccount);

        // create a known to account holder
        AccountHolder toHolder = new AccountHolder();
        toHolder.setName("To Account Holder");
        dao.addAccountHolder(toHolder);

        // create a known to account
        Account toAccount = new Account();
        toAccount.setAccountHolderId(toHolder.getId());
        toAccount.setBalance(77.99);
        dao.addAccount(toAccount);

        // create first transfer
        Transfer transfer = new Transfer();
        transfer.setFromAccount(fromAccount.getId());
        transfer.setToAccount(toAccount.getId());
        transfer.setAmount(102.54);
        dao.addTransfer(transfer);

        // create second transfer
        Transfer transfer2 = new Transfer();
        transfer2.setFromAccount(fromAccount.getId());
        transfer2.setToAccount(toAccount.getId());
        transfer2.setAmount(42.42);
        dao.addTransfer(transfer2);

        List<Transfer> transfers = dao.getTransfersByToAccountId(toAccount.getId());
        assertTrue(transfers.size() == 2);
    }

    public void testGetTransferByTFromAcct() {
        // create a known from account holder
        AccountHolder fromHolder = new AccountHolder();
        fromHolder.setName("From Account Holder");
        dao.addAccountHolder(fromHolder);

        // create a known from account
        Account fromAccount = new Account();
        fromAccount.setAccountHolderId(fromHolder.getId());
        fromAccount.setBalance(45.99);
        dao.addAccount(fromAccount);

        // create a known to account holder
        AccountHolder toHolder = new AccountHolder();
        toHolder.setName("To Account Holder");
        dao.addAccountHolder(toHolder);

        // create a known to account
        Account toAccount = new Account();
        toAccount.setAccountHolderId(toHolder.getId());
        toAccount.setBalance(77.99);
        dao.addAccount(toAccount);

        // create first transfer
        Transfer transfer = new Transfer();
        transfer.setFromAccount(fromAccount.getId());
        transfer.setToAccount(toAccount.getId());
        transfer.setAmount(1020.99);
        dao.addTransfer(transfer);

        // create second transfer
        Transfer transfer2 = new Transfer();
        transfer2.setFromAccount(fromAccount.getId());
        transfer2.setToAccount(toAccount.getId());
        transfer2.setAmount(4200.42);
        dao.addTransfer(transfer2);

        List<Transfer> transfers = dao.getTransfersByFromAccountId(fromAccount.getId());
        assertTrue(transfers.size() == 2);
    }

    public void testTransfer_InvalidFromAccount() {
        try {
            // create and test a transfer
            Transfer transfer = new Transfer();
            transfer.setFromAccount(-1);
            transfer.setToAccount(26);
            transfer.setAmount(102.54);
            dao.addTransfer(transfer);
            assertTrue("This test should have thrown an exception but it didn't - test fails.", false);
        } catch (Exception e) {
            assertTrue("Expected exception - test passes.", true);
        }
    }

    public void testUpdateAccount() {
        // create a known account holder
        AccountHolder holder = new AccountHolder();
        holder.setName("UpdateAccount Test");
        dao.addAccountHolder(holder);

        Account account = new Account();
        account.setAccountHolderId(holder.getId());
        account.setBalance(34.65);
        dao.addAccount(account);
        account.setBalance(55.55);
        dao.updateAccount(account);

        Account newAccount = dao.getAccountById(account.getId());
        assertTrue(newAccount.getId() == account.getId());
        assertTrue(newAccount.getAccountHolderId() == account
                .getAccountHolderId());
        assertTrue(newAccount.getBalance() == account.getBalance());
    }
}
