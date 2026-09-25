package com.educandoweb.course.service;

import com.educandoweb.course.model.User;
import com.educandoweb.course.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user){
        if (user.getName() != null){
            entity.setName(user.getName());
        }

        if (user.getEmail() != null){
            entity.setEmail(user.getEmail());
        }

        if (user.getFone() != null){
            entity.setFone(user.getFone());
        }
    }

}