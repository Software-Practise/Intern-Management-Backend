package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

import com.example.model.Role;
import com.example.model.UserModel;
import com.example.services.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration @ComponentScan({ "com.example.*" })
public class LoadDataCLR implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
	private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("COMMAND LINE RUNNER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        userService.clearDB();
            try {
                if(userService.getUsers().size() == 0) {
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_USER"));
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_FACULTY"));
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_ADMIN"));

                userService.saveUser(new UserModel(new Random().nextLong(),"John", "Travolta", "travoltaj", "1234", new ArrayList<>()));
                userService.saveUser(new UserModel( new Random().nextLong(),"Will", "Smith", "smithw", "1234", new ArrayList<>()));
                userService.saveUser(new UserModel(new Random().nextLong(),"Jim", "Carry", "carryj", "1234", new ArrayList<>()));
                userService.saveUser(new UserModel(new Random().nextLong(),"Ryan", "Reynolds", "reynoldsr", "1234", new ArrayList<>()));

                // userService.addRoleToUser("travoltaj", "ROLE_USER");
                // userService.addRoleToUser("smithw", "ROLE_FACULTY");
                // userService.addRoleToUser("carryj", "ROLE_ADMIN");
                // userService.addRoleToUser("carryj", "ROLE_USER");
                // userService.addRoleToUser("carryj", "ROLE_FACULTY");
                // userService.addRoleToUser("reynoldsr", "ROLE_USER");
                }
                
            } catch (Exception e) {
                logger.error("Unable to save users");
                logger.error(e);
            }

            try {

                userService.addRoleToUser("travoltaj", "ROLE_USER");
                userService.addRoleToUser("smithw", "ROLE_FACULTY");
                userService.addRoleToUser("carryj", "ROLE_ADMIN");
                userService.addRoleToUser("carryj", "ROLE_USER");
                userService.addRoleToUser("carryj", "ROLE_FACULTY");
                userService.addRoleToUser("reynoldsr", "ROLE_USER");

                for(UserModel x : userService.getUsers()) {
                    logger.error(x.getNwId() + " has " + x.getRoles().size() + " Role");
                }

            } catch (Exception e) {

                logger.info("Unable to save users");
                logger.info(e);

            }

            
        

        
			
        
    }
    
}
