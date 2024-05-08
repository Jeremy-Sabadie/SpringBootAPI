package com.my_cda.demo.repository;

import com.my_cda.demo.model.entities.Contract;
import java.util.List;

public interface IContractRepository {
    // Méthodes du CRUD pour les contrats
    Contract createContract(Contract contract);
    List<Contract> getAllContracts();
    Contract getContractById(int id);
    Contract updateContract(int id,Contract contract);
    void deleteContract(int id);
}
