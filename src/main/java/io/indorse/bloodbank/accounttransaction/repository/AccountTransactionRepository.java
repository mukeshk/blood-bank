package io.indorse.bloodbank.accounttransaction.repository;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountTransactionRepository extends PagingAndSortingRepository<AccountTransaction,Long> {
    public AccountTransaction findByUuid(String uuid);
}
