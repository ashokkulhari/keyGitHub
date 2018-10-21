package com.key.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Iterator;
import java.util.Set;

import com.key.model.AclConfig;
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
	
	
	public static boolean  validateUserPermission(User accountUser,String path) {
		
		boolean isValidPermission =false;
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
					Set<AclConfig>  aclConfigs  = permissionSet.getAuthority().getAclConfigs();
					
					for (Iterator iterator = aclConfigs.iterator(); iterator.hasNext();) {
						AclConfig aclConfig = (AclConfig) iterator.next();
						System.out.println("aclConfig   "+aclConfig.getPath());
						if(aclConfig.getPath().toLowerCase().startsWith(path.toLowerCase())){
							System.out.println("Has access to page ...");
							if(permissionSet.getPermission().getPermissionId().intValue() >= aclConfig.getMinPermission().intValue() ){
								System.out.println("Has permission to perform action ...");
								isValidPermission=true;
								break;
							}else{
								System.out.println("User does not have proper permission...");
							}
						}
						
					}
					if(isValidPermission){
						break;
					}
				}
				if(isValidPermission){
					break;
				}
			}
			if(isValidPermission){
				break;
			}
		}
		
		return isValidPermission;
	}
}
