package com.my_cda.demo.controller;

import com.my_cda.demo.model.entities.Contract;
import com.my_cda.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final IContractService contractService;

    @Autowired
    public ContractController(IContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        contract.setId(id);
        return contractService.updateContract(contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
    }
}
