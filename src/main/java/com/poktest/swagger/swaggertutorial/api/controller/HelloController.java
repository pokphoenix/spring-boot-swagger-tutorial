package com.poktest.swagger.swaggertutorial.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
@Api(value = "pok",description = "show hello world")
public class HelloController {

    @ApiOperation(value="Return Pok Aha ")
    @ApiResponses(
        value={
            @ApiResponse(code=100,message = "100 is the message"),
            @ApiResponse(code=200,message = "Successfull Hello")
        }
    )
    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/create")
    public String helloAdd(@RequestBody final String hello){
        return hello;
    }

    @PutMapping("/edit")
    public String helloUpdate(@RequestBody final String hello){
        return hello;
    }

    @DeleteMapping("/del")
    public String helloDelete(@RequestBody final String hello){
        return hello;
    }

}
