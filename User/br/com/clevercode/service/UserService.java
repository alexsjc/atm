package br.com.clevercode.service;


import java.util.List;

import br.com.clevercode.model.User;

public interface UserService {
	
	User findById(Long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);
	
	String operacaoSaque(double saque,double saldo);
}