package me.kitaa.chickenapp.chickenapp.seller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query("SELECT s FROM Seller s WHERE s.Email = ?1")
    Optional<Seller> findSellerByEmail(String Email);
}