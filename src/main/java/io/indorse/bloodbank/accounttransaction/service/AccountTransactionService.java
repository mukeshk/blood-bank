package io.indorse.bloodbank.accounttransaction.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;

public interface AccountTransactionService {
    /**
     * Create Account Transaction
     * @param accountTransaction Hold the transaction instance
     * @return Primary key - uniquely identifies the record.
     */
    public Long create(AccountTransaction accountTransaction);

    /**
     * Find the Account Transaction by UUID
     * @param uuid Uniquely identifies the record
     * @return Returns the account transaction.
     */
    public AccountTransaction findByUUID(String uuid);

    /**
     * Loads all the account transactions
     * @return List of transactions
     */
    public Iterable<AccountTransaction> findAll();
}
