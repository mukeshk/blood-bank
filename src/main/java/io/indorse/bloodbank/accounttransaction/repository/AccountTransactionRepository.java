package io.indorse.bloodbank.accounttransaction.repository;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountTransactionRepository extends PagingAndSortingRepository<AccountTransaction,Long> {
    /**
     * Find Account Transaction by UUID
     * @param uuid Uniquely identifies the transaction record.
     * @return Account Transaction instance.
     */
    public AccountTransaction findByUuid(String uuid);
}
