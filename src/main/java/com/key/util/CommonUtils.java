package com.key.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Iterator;
import java.util.Set;

import com.key.model.Group;
import com.key.model.PermissionSet;
import com.key.model.Role;
import com.key.model.User;

public class CommonUtils {

	
	public static Timestamp getCurrentTimestamp() {
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		Timestamp  currentTimestamp = new Timestamp(timeStampMillis);
		return currentTimestamp;
	}
	
	
	public static void  validateUserPermission(User accountUser) {
		Set<Group> groups = accountUser.getGroups();
		Iterator iter1 = groups.iterator();
		while (iter1.hasNext()) {
			Group usergroup = (Group) iter1.next();
			Set<Role> roles = usergroup.getRoles();
			
			Iterator iter2 = roles.iterator();
			while (iter2.hasNext()) {
				Role role =(Role)iter2.next();
				Set<PermissionSet> permissionSets = role.getPermissionSets();
				Iterator iter3 = permissionSets.iterator();
				while (iter3.hasNext()) {
					PermissionSet permissionSet =(PermissionSet)iter3.next();
					System.out.println("Page : "+permissionSet.getAuthority().getAuthorityName() +" permission:"+permissionSet.getPermission().getPermissionName());
				}	
			}
		}
	}
}
