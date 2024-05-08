package com.my_cda.demo.ApiController;

import com.my_cda.demo.model.entities.Contract;
import com.my_cda.demo.model.entities.ContractRequestDTO;
import com.my_cda.demo.service.IcontractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final IcontractService contractService;

    @Autowired
    public ContractController(IcontractService contractService) {
        this.contractService = contractService;
    }

    // Endpoint pour récupérer tous les contrats
    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();
        return ResponseEntity.ok(contracts);
    }

    // Endpoint pour récupérer un contrat par son ID

    @GetMapping("/contract/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable int id) {
        Optional<Contract> contract = Optional.ofNullable(contractService.getContractById((int) id));
        return contract.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour créer un nouveau contrat
    @PostMapping    public ResponseEntity<Contract> createContract(@RequestBody ContractRequestDTO contractValues) {
        // Créer un nouveau contrat à partir des valeurs reçues dans la requête
        Contract newContract = new Contract();
        newContract.setType(contractValues.getType());
        newContract.setDuration(contractValues.getDuration());
        newContract.setEndDate(contractValues.getEndDate());
        newContract.setStartDate(contractValues.getStartDate());

        // Utiliser le service pour sauvegarder le contrat
        contractService.createContract(newContract);

        // Renvoyer une réponse avec le contrat créé et le code HTTP approprié
        return ResponseEntity.status(HttpStatus.CREATED).body(newContract);
    }

    // Endpoint pour mettre à jour un contrat existant
    // Endpoint pour mettre à jour un contrat existant
    @PutMapping("/contract/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable int id, @RequestBody Contract contract) {
        Contract updatedContract = contractService.updateContract(id, contract);
        return ResponseEntity.ok(updatedContract);
    }

    // Endpoint pour supprimer un contrat par son ID
    @DeleteMapping("/contract/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable int id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
