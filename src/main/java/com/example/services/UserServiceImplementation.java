package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.model.EmployerModel;
import com.example.model.Role;
import com.example.model.UserModel;
import com.example.repository.ApplicationRepository;
import com.example.repository.EmployerRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    // @Autowired
    // BCryptPasswordEncoder passwordEncoder;

    protected final Log log = LogFactory.getLog(getClass());

    //@Autowired
    PasswordEncoder passwordEncoder;

    public UserServiceImplementation(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    

    @Override
    public UserDetails loadUserByUsername(String nwId) throws UsernameNotFoundException {
        UserModel user = userRepository.findBynwId(nwId);
        if (user == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in database " + nwId);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getNwId(), user.getPassword(), authorities);
    }

    @Override
    public void addRoleToUser(String nwId, String roleName) {
        UserModel user = userRepository.findBynwId(nwId);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        log.info("Add role " + roleName +" to user " +nwId);
        for (Role x : user.getRoles())
            log.info(user.getNwId() + " : " + x.getName());
        userRepository.save(user);
    }

    @Override
    public UserModel getUser(String nwId) {
        // TODO Auto-generated method stub
        log.info("Retrieve user from database");
        return userRepository.findBynwId(nwId);
    }

    @Override
    public List<UserModel> getUsers() {
        // TODO Auto-generated method stub
        log.info("Retrieve all users from database");
        return userRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        // TODO Auto-generated method stub
        log.info("Saving new role to the database");
        return roleRepository.save(role);
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        // TODO Auto-generated method stub
        try {
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        } catch (Exception e){
            log.error("Failed to encode password " + e);

        }
        
        log.info("Saving new User "+ userModel.getNwId() +" to the database");
        return userRepository.save(userModel);
    }

    @Override
    public EmployerModel saveEmployer(EmployerModel employer) {
        // TODO Auto-generated method stub
        return employerRepository.save(employer);
    }



    public void clearDB() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        employerRepository.deleteAll();
        applicationRepository.deleteAll();
        }

}
