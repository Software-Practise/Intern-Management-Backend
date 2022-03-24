package com.example.api;

import java.util.List;

import com.example.model.Application;
import com.example.model.UserModel;
import com.example.services.StudentService;
import com.example.services.StudentServiceImplementation;
import com.example.services.UserService;
import com.example.model.Comment;

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

@RestController
@RequestMapping("/api/student")
public class StudentResource {

    @Autowired
    private StudentServiceImplementation studentService;

    @Autowired
    private UserService userService;

    protected final Log log = LogFactory.getLog(getClass());

    @GetMapping("/students")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<UserModel>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping("/faculty/{nwid}/students")
    @PreAuthorize("hasAnyRole('ROLE_FACULTY', 'ROLE_ADMIN')")
    public ResponseEntity<List<UserModel>> getStudentsByFaculty(@PathVariable String nwid) {
        return ResponseEntity.ok().body(studentService.getStudentByFaculty(nwid));
    }

    @GetMapping("/students/{nwId}")
    public ResponseEntity<UserModel> getStudentById(@PathVariable String nwId) {
        return ResponseEntity.ok().body(studentService.getStudent(nwId));
    }

    @GetMapping("/students/{nwId}/a{appId}")
    public ResponseEntity<Application> getApplicationByAppId(@PathVariable String nwId, @PathVariable Long appId){
        return ResponseEntity.ok().body(studentService.getApplicationById(nwId, appId));
    }

    @PostMapping("/students/comment/{nwId}")
    public void addComment(@PathVariable String nwId, @RequestBody Comment comm){
        studentService.addComment(nwId, comm);
        userService.saveUser(userService.getUser(nwId));
    }

    
}
