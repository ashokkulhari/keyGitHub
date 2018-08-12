package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer>{

}
