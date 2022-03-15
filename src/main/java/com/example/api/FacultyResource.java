package com.example.api;

import java.util.List;

import com.example.model.UserModel;
import com.example.services.FacultyService;
import com.example.services.FacultyServiceImplementation;
import com.example.services.StudentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty")
public class FacultyResource {

    @Autowired
    private FacultyService facultyService;

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
    
}
