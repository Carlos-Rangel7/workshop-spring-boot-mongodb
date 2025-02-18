package com.carlosrangel.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosrangel.workshopmongo.domain.User;
import com.carlosrangel.workshopmongo.dto.UserDTO;
import com.carlosrangel.workshopmongo.repository.UserRepository;
import com.carlosrangel.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		Optional<User> obj = repo.findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
		repo.deleteById(id);
	}
	
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
