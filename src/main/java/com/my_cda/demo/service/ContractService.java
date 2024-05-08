package com.my_cda.demo.service;

import com.my_cda.demo.model.entities.Contract;
import com.my_cda.demo.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractService implements IcontractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.createContract(contract);
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.getAllContracts();
    }

    @Override
    public Contract getContractById(int id) {
        return contractRepository.getContractById(id);
    }



    @Override
    public Contract updateContract(int id, Contract contract) {
        return contractRepository.updateContract(id,contract);
    }

    @Override
    public Contract updateContract(Contract contract) {
        return null;
    }

    @Override
    public void deleteContract(int id) {
        contractRepository.deleteContract(id);
    }
}
