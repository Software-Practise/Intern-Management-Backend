package com.example.api;

import com.example.model.EmployerModel;
import com.example.model.UserModel;
import com.example.services.EmployerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employer") // Change the mapping for the UserResource to "/api/user" ?
// Put stuff here similar to UserResource.java?
public class EmployerResource {

    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    private EmployerService employerService;

    @GetMapping("/employers")
    public ResponseEntity<List<EmployerModel>> getEmployer() {
        return ResponseEntity.ok().body(employerService.getEmployers());
    }

    @GetMapping("/employers/{empId}")
    public ResponseEntity<EmployerModel> getEmployer(@PathVariable Long empId) {
        return ResponseEntity.ok().body(employerService.getEmployer(empId));
    }


    // NEEDED??
    @DeleteMapping("/employers/delete/{employerId}")
    public String deleteEmployer(@PathVariable Long employerId) {
        return employerService.deleteEmployer(employerId);
    }

    @PostMapping("/employers/update")
    public String updateEmployer(@RequestBody EmployerModel employer) {
        return employerService.updateEmployer(employer);
    }

    @PostMapping("/employers/add")
    public ResponseEntity<?> addEmployer(@RequestBody EmployerModel employer) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/employer/save").toUriString());
        return ResponseEntity.created(uri).body(employerService.addEmployer(employer));
    }
}
