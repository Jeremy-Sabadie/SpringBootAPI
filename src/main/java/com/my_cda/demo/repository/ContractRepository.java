package com.my_cda.demo.repository;

import com.my_cda.demo.model.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ContractRepository implements IContractRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Contract createContract(Contract contract) {
        entityManager.persist(contract);
        return contract;
    }

    @Override
    public List<Contract> getAllContracts() {
        Query query = entityManager.createQuery("SELECT c FROM Contract c");
        return query.getResultList();
    }

    @Override
    public Contract getContractById(int id) {
        return entityManager.find(Contract.class, id);
    }

    @Override
    public Contract updateContract(int id,Contract contract) {
        entityManager.merge(contract);
        return contract;
    }

    @Override
    public void deleteContract(int id) {
        Contract contract = getContractById(id);
        if (contract != null) {
            entityManager.remove(contract);
        }
    }
}
