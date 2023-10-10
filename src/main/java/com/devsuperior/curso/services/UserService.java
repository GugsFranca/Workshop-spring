package com.devsuperior.curso.services;

import com.devsuperior.curso.entities.User;
import com.devsuperior.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj= repository.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return repository.save(obj);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }
    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        if (obj.getName() != null) {
            entity.setName(obj.getName());}

        if (obj.getEmail() != null) {
            entity.setEmail(obj.getEmail());}

        if (obj.getPhone() != null) {
            entity.setPhone(obj.getPhone());}
    }
}
