package com.example.api;

import java.net.URI;
import java.util.List;

import com.example.model.UserModel;
import com.example.services.FacultyService;
import com.example.services.FacultyServiceImplementation;
import com.example.services.StudentService;
import com.example.services.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/faculty")
public class FacultyResource {

    @Autowired
    private FacultyService facultyService;

    @Autowired UserService userService;

    protected final Log log = LogFactory.getLog(getClass());

    @GetMapping("/facultys")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<UserModel>> getFaculty() {
        return ResponseEntity.ok().body(facultyService.getFaculty());
    }
/*
    @GetMapping("/faculty/{nwid}/students")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<UserModel>> getStudentsByFaculty(@PathVariable String nwid) {
        return ResponseEntity.ok().body(facultyService.getStudentByFaculty(nwid));
    }
*/
    @GetMapping("/faculty/{facId}")
    public ResponseEntity<UserModel> getFacultyById(@PathVariable String facId) {
        return ResponseEntity.ok().body(facultyService.getFaculty(facId));
    }

    ////   POTENTIAL ERRORS HERE
    ////   POTENTIAL ERRORS HERE 
    ////   PORTENTIAL ERRORS HERE 
    @PostMapping("/faculty/add")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @DeleteMapping("/faculty/delete/{facId}")
    public String deleteUser(@PathVariable String facId){
        return facultyService.deleteFaculty(facId);
    }
    @PostMapping("/faculty/update")
    public String updateUser(@RequestBody UserModel user){
        return facultyService.updateFaculty(user);
    }
    @GetMapping("/faculty/f{fName}")
    public ResponseEntity<List<UserModel>> getFacultyByfName(@PathVariable String fName){
        return ResponseEntity.ok().body(facultyService.getFacultyByfName(fName));
    }

    @GetMapping("/faculty/l{lName}")
    public ResponseEntity<List<UserModel>> getFacultyBylName(@PathVariable String lName){
        return ResponseEntity.ok().body(facultyService.getFacultyBylName(lName));
    }
    @GetMapping("/faculty/e{email}")
    public ResponseEntity<UserModel> getFacultyByEmail(@PathVariable String email){
        return ResponseEntity.ok().body(facultyService.getFacultyByEmail(email));
    }
    @GetMapping("/faculty/d{dept}")
    public ResponseEntity<List<UserModel>> getFacultyByDept(@PathVariable String dept){
        return ResponseEntity.ok().body(facultyService.getFacultyByDept(dept));
    }

}
