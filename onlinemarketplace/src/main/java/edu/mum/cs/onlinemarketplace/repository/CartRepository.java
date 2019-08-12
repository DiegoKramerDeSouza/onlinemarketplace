package edu.mum.cs.onlinemarketplace.repository;

import edu.mum.cs.onlinemarketplace.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
