package com.ECommerceWeb.website.repository;

import com.ECommerceWeb.website.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
