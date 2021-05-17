package com.poletaiev.core.model;

/**
 * Created by andrey on 17.05.2021.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}