package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.GroupCode;
@Repository
public interface GroupCodeRepository extends JpaRepository<GroupCode, Integer>{

}
