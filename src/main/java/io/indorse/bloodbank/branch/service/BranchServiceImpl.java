package io.indorse.bloodbank.branch.service;

import io.indorse.bloodbank.branch.repository.BranchRepository;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("branchService")
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    public Long create(BloodBankBranch account){
        branchRepository.save(account);
        return account.getId();
    }

    public BloodBankBranch findByUUID(String uuid){
        return branchRepository.findByUuid(uuid);
    }

    public Iterable<BloodBankBranch> findAll(){
        return  branchRepository.findAll();
    }
}
