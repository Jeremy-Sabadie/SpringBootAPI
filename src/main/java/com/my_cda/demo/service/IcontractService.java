package com.my_cda.demo.service;

import com.my_cda.demo.model.entities.Contract;
import java.util.List;

public interface IcontractService {
    // Méthodes du CRUD pour les contrats
    Contract createContract(Contract contract);
    List<Contract> getAllContracts();
    Contract getContractById(int id);
    Contract updateContract(int id,Contract contract);


    Contract updateContract(Contract contract);

    void deleteContract(int id);
}
