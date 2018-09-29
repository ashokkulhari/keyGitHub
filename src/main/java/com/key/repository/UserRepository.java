package com.key.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.key.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT e FROM User e WHERE e.email =:email")
	User findByEmail(@Param("email")  String email);

	
	@Query(value = "select a.authority_name from user u inner join user_group ug on (u.user_id=ug.user_user_id) "+
			" inner join group_role gr on (ug.group_group_id=gr.group_group_id) inner join "+
			" per_set_role psr on (gr.role_role_id=psr.role_role_id) inner join permission_set ps "
			+ "on (psr.per_set_per_set_id=ps.permission_set_id) "+
			" inner join authority a on (ps.authority_id =a.authority_id) where u.email=?1", nativeQuery = true)
	List<String> getAuthoritiesByEmail(String email);
}
