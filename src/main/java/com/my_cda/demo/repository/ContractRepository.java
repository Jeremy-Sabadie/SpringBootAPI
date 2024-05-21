package com.my_cda.demo.repository;

import com.my_cda.demo.model.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
/**
 * Repository class for managing Contract entities.
 */
@Repository
public class ContractRepository implements IContractRepository {

    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Creates a new contract.
     *
     * @param contract the contract to be created
     * @return the created contract
     */
    @Override
    public Contract createContract(Contract contract) {
        entityManager.persist(contract);
        return contract;
    }
    /**
     * Retrieves all contracts.
     *
     * @return a list of all contracts
     */
    @Override
    public List<Contract> getAllContracts() {
        Query query = entityManager.createQuery("SELECT c FROM Contract c");
        return query.getResultList();
    }
    /**
     * Retrieves a contract by its ID.
     *
     * @param id the ID of the contract to retrieve
     * @return the contract with the specified ID, or null if not found
     */
    @Override
    public Contract getContractById(int id) {
        return entityManager.find(Contract.class, id);
    }
    /**
     * Updates an existing contract.
     *
     * @param id the ID of the contract to update
     * @param contract the updated contract information
     * @return the updated contract
     */
    @Override
    public Contract updateContract(int id,Contract contract) {
        entityManager.merge(contract);
        return contract;
    }
    /**
     * Deletes a contract by its ID.
     *
     * @param id the ID of the contract to delete
     */
    @Override
    public void deleteContract(int id) {
        Contract contract = getContractById(id);
        if (contract != null) {
            entityManager.remove(contract);
        }
    }
}
