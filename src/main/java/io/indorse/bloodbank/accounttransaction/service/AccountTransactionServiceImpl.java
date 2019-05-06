package io.indorse.bloodbank.accounttransaction.service;

import io.indorse.bloodbank.accounttransaction.repository.AccountTransactionRepository;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.dto.AccountTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountTransactionService")
public class AccountTransactionServiceImpl implements AccountTransactionService{

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Override
    public Long create(AccountTransaction accountTransaction) {
        accountTransactionRepository.save(accountTransaction);
        return accountTransaction.getId();
    }

    @Override
    public AccountTransaction findByUUID(String uuid) {
        return accountTransactionRepository.findByUuid(uuid);
    }

    @Override
    public Iterable<AccountTransaction> findAll() {
        return null;
    }
}
