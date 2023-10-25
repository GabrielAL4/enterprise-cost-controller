package br.com.enterprise.costcontroller.Model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Cost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int cost_COD;
    public String costName;
    public Double costValue;
    @ManyToOne(cascade = {CascadeType.ALL})
    public Issuer issuer;
    public int invoiceNumber;
    public ApprovalPhase approvalPhase;
    public boolean isPayed;
    public Date dueDate;
    public Date payDate;

    public int getId() {
        return this.cost_COD;
    }
    public Double getValue() {
        return this.costValue;
    }
    public void setValue(double value) {
        this.costValue = value;
    }
    public String getCostName() {
        return this.costName;
    }
    public void setCostName(String name) {
        this.costName = name;
    }
    public ApprovalPhase getApprovalPhase() {
        return this.approvalPhase;
    }
    public void setApprovalPhase(ApprovalPhase approval) {
        this.approvalPhase = approval;
    }
}