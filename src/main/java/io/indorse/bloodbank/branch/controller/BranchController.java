package io.indorse.bloodbank.branch.controller;

import io.indorse.bloodbank.account.mapper.AccountMapper;
import io.indorse.bloodbank.branch.mapper.BranchMapper;
import io.indorse.bloodbank.branch.service.BranchService;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.BloodBankAccountDTO;
import io.indorse.bloodbank.model.dto.BloodBankBranchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public void create(BloodBankBranchDTO branchDTO){
        BloodBankBranch branch = BranchMapper.mapNewInstance(branchDTO);
        branch.setUuid(UUID.randomUUID().toString());
        branchService.create(branch);
    }

    @GetMapping("/{uuid}")
    public BloodBankBranchDTO findById(String uuid){
        BloodBankBranch branch = branchService.findByUUID(uuid);
        if(branch==null){
            //404
        }
        BloodBankBranchDTO branchDTO = BranchMapper.map(branch);
        return branchDTO;
    }

    @GetMapping("/")
    public List<BloodBankBranchDTO> findAll(){
        Iterable<BloodBankBranch> branches = branchService.findAll();
        List<BloodBankBranchDTO> branchRecords = new ArrayList<>();
        for (BloodBankBranch branch:branches) {
            branchRecords.add(BranchMapper.map(branch));
        }
        return branchRecords;
    }
}