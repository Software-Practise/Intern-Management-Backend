package com.example.api;

import com.example.model.EmployerModel;
import com.example.model.UserModel;
import com.example.services.EmployerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employer") // Change the mapping for the UserResource to "/api/user" ?
// Put stuff here similar to UserResource.java?
public class EmployerResource {

    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    private EmployerService employerService;

    public ResponseEntity<List<EmployerModel>> getEmployer() {
        return ResponseEntity.ok().body(employerService.getEmployers());
    }

}
