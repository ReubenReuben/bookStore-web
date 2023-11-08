package com.ECommerceWeb.website.repository;

import com.ECommerceWeb.website.Entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Entity, Integer> {
}
