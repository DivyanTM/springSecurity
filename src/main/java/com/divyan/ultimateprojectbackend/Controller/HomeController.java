package com.divyan.ultimateprojectbackend.Controller;


import com.divyan.ultimateprojectbackend.Model.Student;
import com.divyan.ultimateprojectbackend.Service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class HomeController {
    final
    StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String helloWorld(){
        return "visitor";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/user")
    public String User(){
        return "user";
    }
    @RequestMapping("/visitor")
    public String Visitor(){
        return "visitor";
    }
}
