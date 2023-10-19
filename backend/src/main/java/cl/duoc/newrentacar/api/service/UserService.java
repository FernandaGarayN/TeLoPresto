package cl.duoc.newrentacar.api.service;


import cl.duoc.newrentacar.api.repository.UserRepository;
import cl.duoc.newrentacar.api.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean login(String email,String password){
        Optional<UserEntity>userEntity=userRepository.findByEmail(email);
        if (userEntity.isPresent()){
            UserEntity user=userEntity.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
}
