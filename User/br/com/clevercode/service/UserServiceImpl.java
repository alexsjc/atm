package br.com.clevercode.service;

import java.util.List;

import br.com.clevercode.model.User;
import br.com.clevercode.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}
	
	private static  double[] getNotasDisponiveis() {
		return new double[] { 100, 50, 20, 10 };
	}
	
	public String operacaoSaque(double saque,double saldo) {
		final int INICIO = 0;
		 String retorno="";
		  retorno  =  saque<saldo ?  realizaOperacaoSaque(saque, INICIO,retorno) :
		   "Saldo insuficiente para completar operação.";
		  
		  return retorno;
	}
	
	private   String   realizaOperacaoSaque(Double value, int index,String retorno) {
		 
		if (value == getNotasDisponiveis()[index])
			return retorno + " R$ "+ getNotasDisponiveis()[index];
		if (value > getNotasDisponiveis()[index]) {
			retorno = retorno +" R$ " + getNotasDisponiveis()[index];
			 return  realizaOperacaoSaque(value - getNotasDisponiveis()[index], index,retorno);
		} 
		if (index < (getNotasDisponiveis().length - 1))
			  return realizaOperacaoSaque(value, ++index,retorno);
		return retorno;
		 
}
	
	 
	
	
	

}
