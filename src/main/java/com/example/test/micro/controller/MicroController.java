package com.example.test.micro.controller;


import com.example.test.micro.exception.UserNotFoundExcpetion;
import com.example.test.micro.service.UserService;
import com.example.test.micro.stubs.HelloWorldBean;
import com.example.test.micro.stubs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class MicroController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String m1(){
        return "Hello SpringBoot 2.5.5 reload";
    }


    @GetMapping("/hello-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("Message Constructor");
    }

    @GetMapping("/hello/{id}")
    public HelloWorldBean helloWorldBean(@PathVariable String id){
        return new HelloWorldBean(String.format("Hello World %s",id));
    }


    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findOneUser(@PathVariable int id){
        //return userService.findOne(id);
        User user = userService.findOne(id);
        if(user==null){
            throw new UserNotFoundExcpetion("id ="+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@Valid @RequestBody User user){
       // return userService.saveUser(user);
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand((savedUser.getId())).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user=userService.deleteUser(id);
        if (user==null){
            throw new UserNotFoundExcpetion("id ="+id);
        }
    }



    @GetMapping("/hello-international")
    /*public String m2( @RequestHeader(name="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null, locale);
    }*/
    public String m2(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }


}
