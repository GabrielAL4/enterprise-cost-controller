package br.com.enterprise.costcontroller.repository;


import br.com.enterprise.costcontroller.Model.Issuer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
@Transactional
public interface IssuerRepository extends JpaRepository<Issuer, Integer> {
    @Query("SELECT i FROM Issuer i")
    List<Issuer> findAllCosts();
}
