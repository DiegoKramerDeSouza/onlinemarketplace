package edu.mum.cs.onlinemarketplace.repository;

import edu.mum.cs.onlinemarketplace.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {

    //@Query("SELECT o FROM UserOrder o WHERE o.seller = :id")
    List<UserOrder> findOrderBySellerId(@Param("id") Long id);
}
