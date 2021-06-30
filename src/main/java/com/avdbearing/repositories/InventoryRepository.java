package com.avdbearing.repositories;


import com.avdbearing.domain.core.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
