package com.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key.model.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{
	Group findByGroupName(String groupName);
}
