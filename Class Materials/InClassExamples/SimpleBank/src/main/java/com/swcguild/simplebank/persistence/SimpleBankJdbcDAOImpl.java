package com.swcguild.simplebank.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.swcguild.simplebank.domain.Account;
import com.swcguild.simplebank.domain.AccountHolder;
import com.swcguild.simplebank.domain.DepositWithdrawal;
import com.swcguild.simplebank.domain.Transfer;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Uncomment if configuration is moved to annotation driven
//@Repository("simpleBankDAO")
public class SimpleBankJdbcDAOImpl implements SimpleBankDAO {

    private static final String SQL_INSERT_ACCOUNT_HOLDER =
            "insert into account_holders (name) values (?)";
    private static final String SQL_UPDATE_ACCOUNT_HOLDER = 
            "update account_holders set name = ? where id = ?";
    private static final String SQL_SELECT_ACCOUNT_HOLDER_BY_ID =
            "select id, name from account_holders where id = ?";
    private static final String SQL_SELECT_ALL_ACCOUNT_HOLDERS = 
            "select id, name from account_holders";
    private static final String SQL_INSERT_ACCOUNT =
            "insert into accounts (account_holder_id, balance) values (?, ?)";
    private static final String SQL_UPDATE_ACCOUNT =
            "update accounts set account_holder_id = ?, balance = ? where id = ?";
    private static final String SQL_SELECT_ACCOUNT_BY_ID =
            "select id, account_holder_id, balance from accounts where id = ?";
    private static final String SQL_SELECT_ACCOUNT_BY_ACCOUNT_HOLDER_ID =
            "select id, account_holder_id, balance from accounts where account_holder_id = ?";
    private static final String SQL_INSERT_DEPOSIT_WITHDRAWAL =
            "insert into deposits_withdrawals (account_id, amount, note) values (?, ?, ?)";
    private static final String SQL_SELECT_DEPOSIT_WITHDRAWAL_BY_ID =
            "select id, account_id, amount, note, date from deposits_withdrawals where id = ?";
    private static final String SQL_SELECT_DEPOSIT_WITHDRAWAL_BY_ACCOUNT_ID = 
            "select id, account_id, amount, note, date from deposits_withdrawals where account_id = ?";
    private static final String SQL_INSERT_TRANSFER =
            "insert into transfers (from_account_id, to_account_id, amount) values (?, ?, ?)";
    private static final String SQL_SELECT_TRANSFER_BY_ID =
            "select id, from_account_id, to_account_id, amount, date from transfers where id = ?";
    private static final String SQL_SELECT_TRANSFER_BY_TO_ACCOUNT_ID = 
            "select id, from_account_id, to_account_id, amount, date from transfers where to_account_id = ?";
    private static final String SQL_SELECT_TRANSFER_BY_FROM_ACCOUNT_ID = 
            "select id, from_account_id, to_account_id, amount, date from transfers where from_account_id = ?";
    
//    Uncomment if configuration is moved to annotation driven    
//    @Autowired
//    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public SimpleBankJdbcDAOImpl() {
    }

//    public SimpleBankJdbcDAOImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    // Comment out if configuration is moved to annotation driven
    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void addAccountHolder(AccountHolder accountHolder) {
        jdbcTemplate.update(SQL_INSERT_ACCOUNT_HOLDER,
                accountHolder.getName());

        //accountHolder.setId(jdbcTemplate.queryForInt("select LAST_INSERT_ID()"));
        accountHolder.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }
    
    public void updateAccountHolder(AccountHolder accountHolder) {
        jdbcTemplate.update(SQL_UPDATE_ACCOUNT_HOLDER, 
                accountHolder.getName(), 
                accountHolder.getId());
    }

    public AccountHolder getAccountHolderById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_ACCOUNT_HOLDER_BY_ID,
                new ParameterizedRowMapper<AccountHolder>() {
            public AccountHolder mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountHolder holder = new AccountHolder();
                holder.setId(rs.getInt("id"));
                holder.setName(rs.getString("name"));
                return holder;
            }
        },
                id);
    }

    public List<AccountHolder> getAllAccountHolders() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ACCOUNT_HOLDERS,
                new ParameterizedRowMapper<AccountHolder>() {
            public AccountHolder mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountHolder holder = new AccountHolder();
                holder.setId(rs.getInt("id"));
                holder.setName(rs.getString("name"));
                return holder;
            }
        });
    }

    public void addAccount(Account account) {
        jdbcTemplate.update(this.SQL_INSERT_ACCOUNT, account.getAccountHolderId(), account.getBalance());
        account.setId(jdbcTemplate.queryForInt("select LAST_INSERT_ID()"));
    }

    public Account getAccountById(int id) {
        return jdbcTemplate.queryForObject(this.SQL_SELECT_ACCOUNT_BY_ID,
                new ParameterizedRowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rownum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setAccountHolderId(rs.getInt("account_holder_id"));
                account.setBalance(rs.getDouble("balance"));
                return account;
            }
        }, id);
    }

    public List<Account> getAccountsByAccountHolderId(int id) {
        return jdbcTemplate.query(SQL_SELECT_ACCOUNT_BY_ACCOUNT_HOLDER_ID,
                new ParameterizedRowMapper<Account>() {
            public Account mapRow(ResultSet rs, int rownum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setAccountHolderId(rs.getInt("account_holder_id"));
                account.setBalance(rs.getDouble("balance"));
                return account;
            }
        }, id);

    }

    public void updateAccount(Account account) {
        jdbcTemplate.update(SQL_UPDATE_ACCOUNT, account.getAccountHolderId(), account.getBalance(), account.getId());
    }

    public void addDepositWithdrawal(DepositWithdrawal depositWithdrawal) {
        jdbcTemplate.update(this.SQL_INSERT_DEPOSIT_WITHDRAWAL, depositWithdrawal.getAccountId(), depositWithdrawal.getAmount(), depositWithdrawal.getNote());
        depositWithdrawal.setId(jdbcTemplate.queryForInt("select LAST_INSERT_ID()"));
    }

    public DepositWithdrawal getDepositWithdrawalById(int id) {
        return jdbcTemplate.queryForObject(this.SQL_SELECT_DEPOSIT_WITHDRAWAL_BY_ID,
                new ParameterizedRowMapper<DepositWithdrawal>() {
            public DepositWithdrawal mapRow(ResultSet rs, int rownum) throws SQLException {
                DepositWithdrawal dw = new DepositWithdrawal();
                dw.setId(rs.getInt("id"));
                dw.setAccountId(rs.getInt("account_id"));
                dw.setAmount(rs.getDouble("amount"));
                dw.setNote(rs.getString("note"));
                dw.setDate(rs.getTimestamp("date"));

                return dw;
            }
        },
                id);
    }

    public List<DepositWithdrawal> getDepositsWithdrawalsByAccountId(int id) {
                    return jdbcTemplate.query(SQL_SELECT_DEPOSIT_WITHDRAWAL_BY_ACCOUNT_ID,
                new ParameterizedRowMapper<DepositWithdrawal>() {
            public DepositWithdrawal mapRow(ResultSet rs, int rownum) throws SQLException {
                DepositWithdrawal dw = new DepositWithdrawal();
                dw.setId(rs.getInt("id"));
                dw.setAccountId(rs.getInt("account_id"));
                dw.setAmount(rs.getDouble("amount"));
                dw.setNote(rs.getString("note"));
                dw.setDate(rs.getTimestamp("date"));

                return dw;
            }
        },
                id);

    }

    public void addTransfer(Transfer transfer) {
        jdbcTemplate.update(this.SQL_INSERT_TRANSFER,
                transfer.getFromAccount(),
                transfer.getToAccount(),
                transfer.getAmount());
        transfer.setId(jdbcTemplate.queryForInt("select LAST_INSERT_ID()"));
    }

    public Transfer getTransferById(int id) {
        return jdbcTemplate.queryForObject(this.SQL_SELECT_TRANSFER_BY_ID,
                new ParameterizedRowMapper<Transfer>() {
            public Transfer mapRow(ResultSet rs, int rownum) throws SQLException {
                Transfer transfer = new Transfer();
                transfer.setId(rs.getInt("id"));
                transfer.setFromAccount(rs.getInt("from_account_id"));
                transfer.setToAccount(rs.getInt("to_account_id"));
                transfer.setAmount(rs.getDouble("amount"));
                transfer.setDate(rs.getTimestamp("date"));
                return transfer;
            }
        },
                id);
    }

    public List<Transfer> getTransfersByToAccountId(int id) {
        return jdbcTemplate.query(SQL_SELECT_TRANSFER_BY_TO_ACCOUNT_ID,
                new ParameterizedRowMapper<Transfer>() {
            public Transfer mapRow(ResultSet rs, int rownum) throws SQLException {
                Transfer transfer = new Transfer();
                transfer.setId(rs.getInt("id"));
                transfer.setFromAccount(rs.getInt("from_account_id"));
                transfer.setToAccount(rs.getInt("to_account_id"));
                transfer.setAmount(rs.getDouble("amount"));
                transfer.setDate(rs.getTimestamp("date"));
                return transfer;
            }
        },
                id);
    }

    public List<Transfer> getTransfersByFromAccountId(int id) {
        return jdbcTemplate.query(SQL_SELECT_TRANSFER_BY_FROM_ACCOUNT_ID,
                new ParameterizedRowMapper<Transfer>() {
            public Transfer mapRow(ResultSet rs, int rownum) throws SQLException {
                Transfer transfer = new Transfer();
                transfer.setId(rs.getInt("id"));
                transfer.setFromAccount(rs.getInt("from_account_id"));
                transfer.setToAccount(rs.getInt("to_account_id"));
                transfer.setAmount(rs.getDouble("amount"));
                transfer.setDate(rs.getTimestamp("date"));
                return transfer;
            }
        },
                id);
    }
}
