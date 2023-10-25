package br.com.enterprise.costcontroller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enterprise.costcontroller.Model.Issuer;
import br.com.enterprise.costcontroller.exceptions.InvalidEntryException;
import br.com.enterprise.costcontroller.exceptions.NotFoundException;
import br.com.enterprise.costcontroller.repository.IssuerRepository;

@Service
public class IssuerService {
    @Autowired
    IssuerRepository repository;
    public List<Issuer> findAll() {
        return repository.findAllCosts();
    }

    public Issuer get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Issuer not found"));
    }
    public Issuer save(Issuer issuer) {
        return repository.save(issuer);
    }

    public void delete(int id) {
        Issuer issuer = repository.findById(id).orElseThrow(() -> new NotFoundException("issuer not found"));
        repository.delete(issuer);
    }

    public Issuer update(Issuer issuerToUpdate, int issuerId) {
        Issuer oldIssuer = this.get(issuerId);
        if (issuerToUpdate.getId() != (issuerId)) {
            throw new InvalidEntryException("The id from the body can't be different from the id from the request");
        }

        return repository.save(mergeNotNullParamsForUpdate(oldIssuer, issuerToUpdate));
    }

    private Issuer mergeNotNullParamsForUpdate(Issuer oldissuer, Issuer newIssuer) {
        if (newIssuer.getValue() == 0.0) {
            newIssuer.setValue(oldissuer.getValue());
        }

        if (newIssuer.getDueDate() == null) {
            newIssuer.setDueDate(oldissuer.getDueDate());
        }

        if (newIssuer.getCostName() == null) {
            newIssuer.setCostName(oldissuer.getCostName());
        }

        if (newIssuer.getApprovalPhase() == null) {
            newIssuer.setApprovalPhase(oldissuer.getApprovalPhase());
        }

        if (newIssuer.getPayDate() == null) {
            newIssuer.setPayDate(oldissuer.getPayDate());
        }

        if (newIssuer.getInvoiceNumber() == 0) {
            newIssuer.setInvoiceNumber(oldissuer.getInvoiceNumber());
        }

        return newIssuer;
    }
}
