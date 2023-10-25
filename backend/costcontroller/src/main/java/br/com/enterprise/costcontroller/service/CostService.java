package br.com.enterprise.costcontroller.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enterprise.costcontroller.Model.Cost;
import br.com.enterprise.costcontroller.exceptions.InvalidEntryException;
import br.com.enterprise.costcontroller.exceptions.NotFoundException;
import br.com.enterprise.costcontroller.repository.CostRepository;

import java.util.List;

@Service
public class CostService {
    @Autowired
    CostRepository repository;
    public List<Cost> findAll() {
        return repository.findAllCosts();
    }

    public Cost get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cost not found"));
    }
    public Cost save(Cost cost) {
        return repository.save(cost);
    }

    public void delete(int id) {
        Cost cost = repository.findById(id).orElseThrow(() -> new NotFoundException("Cost not found"));
        repository.delete(cost);
    }

    public Cost update(Cost costToUpdate, int costId) {
        Cost oldCost = this.get(costId);
        if (costToUpdate.getId() != (costId)) {
            throw new InvalidEntryException("The id from the body can't be different from the id from the request");
        }

        return repository.save(mergeNotNullParamsForUpdate(oldCost, costToUpdate));
    }

    private Cost mergeNotNullParamsForUpdate(Cost oldCost, Cost newCost) {
        if (newCost.getValue() == 0.0) {
            newCost.setValue(oldCost.getValue());
        }

        if (newCost.getDueDate() == null) {
            newCost.setDueDate(oldCost.getDueDate());
        }

        if (newCost.getCostName() == null) {
            newCost.setCostName(oldCost.getCostName());
        }

        if (newCost.getApprovalPhase() == null) {
            newCost.setApprovalPhase(oldCost.getApprovalPhase());
        }

        if (newCost.getPayDate() == null) {
            newCost.setPayDate(oldCost.getPayDate());
        }

        if (newCost.getInvoiceNumber() == 0) {
            newCost.setInvoiceNumber(oldCost.getInvoiceNumber());
        }

        return newCost;
    }
}
