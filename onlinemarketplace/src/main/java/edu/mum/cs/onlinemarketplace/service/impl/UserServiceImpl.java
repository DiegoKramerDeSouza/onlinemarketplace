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

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }



    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
