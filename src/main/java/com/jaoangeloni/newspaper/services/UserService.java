package com.jaoangeloni.newspaper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaoangeloni.newspaper.domain.User;
import com.jaoangeloni.newspaper.dto.LoginDTO;
import com.jaoangeloni.newspaper.dto.UserDTO;
import com.jaoangeloni.newspaper.repository.UserRepository;
import com.jaoangeloni.newspaper.services.exception.InvalidPasswordException;
import com.jaoangeloni.newspaper.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User findByEmail(String email) {
		Optional<User> obj = repo.findByEmail(email);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User login(LoginDTO obj) {
        Optional<User> userOpt = repo.findByEmail(obj.getEmail());

        User user = userOpt.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));

        if (!user.getSenha().equals(obj.getSenha())) {
			System.out.println("a");
            throw new InvalidPasswordException("Senha inválida");
        }

        return user;
    }
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail(), objDto.getSenha());
	}
}
