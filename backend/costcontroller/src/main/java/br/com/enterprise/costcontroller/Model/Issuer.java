package br.com.enterprise.costcontroller.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int issuer_COD;
    public String issuerName;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public IssuerType issuerType;
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Cost> generatedCosts;

    public int getId(){
        return this.issuer_COD;
    }

    public String getIssuerName(){
        return this.issuerName;
    }

    public void setIssuerName(String name){
        this.issuerName = name;
    }

}
