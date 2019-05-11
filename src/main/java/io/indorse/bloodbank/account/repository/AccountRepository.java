package io.indorse.bloodbank.account.repository;

import io.indorse.bloodbank.model.domain.BloodBankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<BloodBankAccount,Long> {
    /**
     * Find Blood Bank Account instance by UUID
     * @param uuid Uniquely identifies the account
     * @return BloodBankAccount entity
     */
    public BloodBankAccount findByUuid(String uuid);

    /**
     * Find Blood Bank Account instance by email
     * @param email Holds the emailId
     * @return BloodBankAccount entity matching the email.
     */
    public BloodBankAccount findByEmail(String email);
}
