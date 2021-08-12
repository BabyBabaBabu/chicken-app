package me.kitaa.chickenapp.chickenapp.buyer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long>{
    
    @Query("SELECT b FROM Buyer b WHERE b.Email = ?1")
    Optional<Buyer> findBuyerByEmail(String Email);
}