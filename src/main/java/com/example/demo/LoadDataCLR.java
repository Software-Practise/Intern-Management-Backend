package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

import com.example.model.EmployerModel;
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

        EmployerModel steveJ = new EmployerModel(new Random().nextLong(),"Steve", "Jobs", "stevej", "4312", "Apple St.", "Washington", "3223", "6234568383", "stevejobs@aol.com", "Yapple");
        UserModel travoltaj = new UserModel(new Random().nextLong(),"John", "Travolta", "travoltaj", "1234", new ArrayList<>());
        UserModel smithw = new UserModel( new Random().nextLong(),"Will", "Smith", "smithw", "1234", new ArrayList<>());
        UserModel carryj = new UserModel(new Random().nextLong(),"Jim", "Carry", "carryj", "1234", new ArrayList<>());
        UserModel reynoldsr = new UserModel(new Random().nextLong(),"Ryan", "Reynolds", "reynoldsr", "1234", new ArrayList<>());
        UserModel cavillh = new UserModel(new Random().nextLong(),"Henry", "Cavill", "cavillh", "cavillh@nwmissouri.edu","Computer science", "1234", new ArrayList<>(), new ArrayList<>(), "800 University Drive","Maryville", "Missouri", "64468", "(660) 123 4567", "Computer Science", "Undergraduate");
        //UserModel cavillh = new UserModel(new Random().nextLong(),"Henry", "Cavill", "cavillh", "1234", new ArrayList<>(), "800 University Drive","Maryville", "Missouri", "64468", "(660) 123 4567", "Computer Science", "In Progress", "Undergraduate", "This is an offer Letter", smithw.getNwId(), 456789, 23456789, steveJ);
        //UserModel cavillh = new UserModel(new Random().nextLong(),"Henry", "Cavill", "cavillh", "cavillh@nwmissouri.edu","Computer science", "1234", new ArrayList<>(), "800 University Drive","Maryville", "Missouri", "64468", "(660) 123 4567", "Computer Science", "In Progress", "Undergraduate", "This is an offer Letter", smithw.getNwId(), 456789, 23456789, steveJ);
            try {
                if(userService.getUsers().size() == 0) {

                userService.saveEmployer(steveJ);
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_USER"));
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_FACULTY"));
                userService.saveRole(new Role(new Random().nextLong(), "ROLE_ADMIN"));

                userService.saveUser(travoltaj);
                userService.saveUser(smithw);
                userService.saveUser(carryj);
                userService.saveUser(reynoldsr);
                userService.saveUser(cavillh);


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
                userService.addRoleToUser("cavillh", "ROLE_FACULTY");


                for(UserModel x : userService.getUsers()) {
                    logger.error(x.getNwId() + " has " + x.getRoles().size() + " Role");
                }

            } catch (Exception e) {

                logger.info("Unable to save users");
                logger.info(e);

            }

            
        

        
			
        
    }
    
}
