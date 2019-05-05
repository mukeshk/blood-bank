package io.indorse.bloodbank.branch.repository;

import io.indorse.bloodbank.model.domain.BloodBankBranch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BranchRepository extends PagingAndSortingRepository<BloodBankBranch,Long> {
    public BloodBankBranch findByUuid(String uuid);
}
