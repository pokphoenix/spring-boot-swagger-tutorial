package com.poktest.swagger.swaggertutorial.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(value = "UserController",description = "show user")
public class UserController {
    @GetMapping
    public List<User> getUsers(){
        return Arrays.asList(
                new User("Sam",2000l),
                new User("Peter",1000l)
        );
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") final String userName ){
        return new User(userName,1000l);
    }


    private class User{

        @ApiModelProperty(notes = "name of the user")
        private String userName;

        @ApiModelProperty(notes = "salary of the user")
        private Long salary;

        public User(String userName, Long salary) {
            this.userName = userName;
            this.salary = salary;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
