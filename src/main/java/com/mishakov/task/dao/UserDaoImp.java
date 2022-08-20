package com.mishakov.task.dao;


import com.mishakov.task.models.User;
import com.mishakov.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private  EntityManager entityManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserDaoImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User newUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return entityManager.find(User.class, user.getId());
    }

    @Override
    public User showByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));
    }

    @Override
    public User oneUser(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
        return entityManager.find(User.class, user.getId());
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
