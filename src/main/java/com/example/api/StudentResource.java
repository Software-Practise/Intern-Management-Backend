package com.example.api;

import java.net.URI;
import java.util.List;

import com.example.model.Application;
import com.example.model.EmployerModel;
import com.example.model.UserModel;
import com.example.services.StudentService;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    protected final Log log = LogFactory.getLog(getClass());

    @GetMapping("/students")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<UserModel>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping("/faculty/{nwid}/students")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<Application>> getStudentsByFaculty(@PathVariable String nwid) {
        return ResponseEntity.ok().body(studentService.getStudentByFaculty(nwid));
    }

    @GetMapping("/students/{nwId}")
    public ResponseEntity<UserModel> getStudentById(@PathVariable String nwId) {
        return ResponseEntity.ok().body(studentService.getStudent(nwId));
    }
    
    @PostMapping("/students/{nwId}/addApplication")
    public ResponseEntity<?> addApplication(@PathVariable String nwId,@RequestBody NewApplication newApplication) {
        //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/{nwId}/addApplication").toUriString());
        //return ResponseEntity.created(uri).body(studentService.addApplication(nwId, application));
        EmployerModel employer = studentService.saveEmployer(newApplication.getEmployer());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/{nwId}/addApplication").toUriString());
        return ResponseEntity.created(uri).body(studentService.addApplication(nwId, employer.getId(), newApplication.getApplication()));
        //return ResponseEntity.created(uri).body(employer);
    }


    // @PostMapping("/students/{nwId}/addEmployerToApplication/{appId}")
    // public ResponseEntity<?> addEmployerToApplication(@PathVariable String nwId, @PathVariable Long appId, @RequestBody EmployerModel employer) {
    //     URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/{nwId}/addEmployerToApplication/{appId}").toUriString());
    //     return ResponseEntity.created(uri).body(studentService.addEmployerToStudent(nwId, appId, employer));
    // }

    @PostMapping("/students/{nwId}/dropApplication/{appId}")
    public ResponseEntity<?> dropApplication(@PathVariable String nwId, @PathVariable Long appId) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/{nwId}/dropApplication/{appId}").toUriString());
        return ResponseEntity.created(uri).body(studentService.dropApplication(appId, nwId));
        
    }

    @PostMapping("/students/{nwId}/setStatus/{appId}")
    public ResponseEntity<?> sertStatus(@PathVariable String nwId, @PathVariable Long appId, @RequestBody String status) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/{nwId}/setStatus/{appId}").toUriString());
        return ResponseEntity.created(uri).body(studentService.setStatus(appId, nwId, status));
        
    }

    @GetMapping("/students/application")
    public ResponseEntity<?> getAllApplications(){
        return ResponseEntity.ok().body(studentService.getAllApplications());
    }
}

@Data
class NewApplication {
    @JsonProperty("application")
    Application application;

    @JsonProperty("employer")
    EmployerModel employerModel;

    public Application getApplication() {
        return application;
    }

    public EmployerModel getEmployer() {
        return employerModel;
    }
 
}
