package io.indorse.bloodbank.branch.controller;

import io.indorse.bloodbank.branch.mapper.BranchMapper;
import io.indorse.bloodbank.branch.service.BranchService;
import io.indorse.bloodbank.common.exception.RecordNotFoundException;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.BloodBankBranchDTO;
import io.indorse.bloodbank.model.dto.BloodBankBranchListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
@ControllerAdvice
public class BranchController {

    @Autowired
    private BranchService branchService;

    /**
     * Create new Branch
     * @param branchDTO Holds the branch details.
     * @return UUID uniquely identifies the branch.
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody BloodBankBranchDTO branchDTO){
        BloodBankBranch branch = BranchMapper.mapNewInstance(branchDTO);
        branch.setUuid(UUID.randomUUID().toString());
        branchService.create(branch);
        return ResponseEntity.ok(branch.getUuid());

    }

    /**
     * Find the Branch
     * @param uuid Uniquely identifies the branch
     * @return Branch details.
     */
    @GetMapping("/{uuid}")
    public ResponseEntity<BloodBankBranchDTO> findById(@PathVariable("uuid") String uuid){
        BloodBankBranch branch = branchService.findByUUID(uuid);
        if(branch==null){
            throw new RecordNotFoundException("branch record not found for uuid:="+ uuid);
        }
        BloodBankBranchDTO branchDTO = BranchMapper.map(branch);
        return ResponseEntity.ok(branchDTO);
    }

    /**
     * Find All branches
     * @return List of branch
     */
    @GetMapping("/")
    public List<BloodBankBranchListDTO> findAll(){
        Iterable<BloodBankBranch> branches = branchService.findAll();
        List<BloodBankBranchListDTO> branchRecords = new ArrayList<>();
        for (BloodBankBranch branch:branches) {
            branchRecords.add(BranchMapper.mapToListModel(branch));
        }
        return branchRecords;
    }
}
