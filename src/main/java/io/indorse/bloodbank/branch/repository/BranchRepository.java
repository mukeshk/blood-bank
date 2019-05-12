package io.indorse.bloodbank.branch.repository;

import io.indorse.bloodbank.model.domain.BloodBankBranch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BranchRepository extends PagingAndSortingRepository<BloodBankBranch,Long> {
    /**
     * Find Branch by UUID
     * @param uuid Uniquely identifies the branch
     * @return Blood bank branch matching the UUID
     */
    public BloodBankBranch findByUuid(String uuid);
}
