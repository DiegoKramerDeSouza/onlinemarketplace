package edu.mum.cs.onlinemarketplace.service.impl;

import edu.mum.cs.onlinemarketplace.domain.Address;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.repository.AddressRepository;
import edu.mum.cs.onlinemarketplace.repository.ProductRepository;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.repository.UserRepository;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;


    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        return null;
    }



    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return user.get();
        return null;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> findAllFollowers(Long sid) {
        return userRepository.findFollowersById(sid);
    }

    @Override

    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }



    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
