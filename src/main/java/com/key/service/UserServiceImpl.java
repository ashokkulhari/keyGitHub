package com.key.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.key.model.Group;
import com.key.model.User;
import com.key.repository.CompanyRepository;
import com.key.repository.GroupRepository;
import com.key.repository.UserRepository;
import com.key.util.CommonUtils;

@Service//("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private GroupRepository groupRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(NOT_ACTIVATED_USER);
        user.setKeyword(randomWord());
        Timestamp currentTimestamp = CommonUtils.getCurrentTimestamp();
        user.setAuditInsertDate(currentTimestamp);
        Group userGroup = groupRepository.findByGroupName("Administrator");
        user.setGroups(new HashSet<Group>(Arrays.asList(userGroup)));
        user.setCompany(companyRepository.findByCompanyName("test"));
		userRepository.save(user);

//		mailService.sendActivationMail(user);
	}

	@Override
	public User updateUser(User user) {
		User newUser = findUserByEmail(user.getEmail());
		if(newUser != null) {
			newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(newUser);
		}

		return newUser;
	}

	@Override
	public User resetPass(User user){
		User newUser = findUserByEmail(user.getEmail());
		if(newUser != null) {
			String passwd = randomWord();
			newUser.setPassword(bCryptPasswordEncoder.encode(passwd));
			userRepository.save(newUser);
//			mailService.sendNewPasswordMail(newUser, passwd);
		}

		return newUser;
	}

	@Override
	public String extractUsername(String authHeader) {
		byte[] decodedBytes = Base64.getDecoder().decode(authHeader.split(" ")[1]);
		String decodedUsername = new String(decodedBytes).split(":")[0];
		
		String decodedpass = new String(decodedBytes).split(":")[1];
		
System.out.println(decodedUsername +"  decodedpass = " +decodedpass);
		return new String(decodedUsername);
	}

	@Override
	public User activateUser(User userToActivate) {
		User user = userRepository.findByEmail(userToActivate.getEmail());
		if(    user != null
		    && user.getKeyword().equals(userToActivate.getKeyword()))
		{
			user.setActive(ACTIVATED_USER);
			userRepository.save(user);
		}

		return user;
	}

	@Override
	public User deleteUser(String username) {
		User user = userRepository.findByEmail(username);
		if(user != null) {
			user.setActive(NOT_ACTIVATED_USER);
			userRepository.save(user);
		}

		return user;
	}

//	@Override
	public String randomWord() {
		return RandomStringUtils.randomAlphabetic(16);
	}

}
