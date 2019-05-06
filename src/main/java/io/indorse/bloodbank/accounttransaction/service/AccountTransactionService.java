package io.indorse.bloodbank.accounttransaction.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.dto.AccountTransactionDTO;

public interface AccountTransactionService {
    public Long create(AccountTransaction accountTransaction);
    public AccountTransaction findByUUID(String uuid);
    public Iterable<AccountTransaction> findAll();
}
