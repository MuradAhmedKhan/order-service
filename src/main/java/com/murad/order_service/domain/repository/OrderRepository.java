package com.murad.order_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murad.order_service.domain.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}