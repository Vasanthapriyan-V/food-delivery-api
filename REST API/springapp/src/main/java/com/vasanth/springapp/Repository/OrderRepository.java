package com.vasanth.springapp.Repository;

import com.vasanth.springapp.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // List<OrderEntity> findByRestaurantId(Long restaurantId);

    @Query("SELECT o FROM OrderEntity o WHERE o.user.id = :userId")
List<OrderEntity> findByUserId(@Param("userId") Long userId);


}
