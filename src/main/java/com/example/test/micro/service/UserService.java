package com.example.test.micro.service;


import com.example.test.micro.stubs.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {

    private static List<User> userList = new ArrayList<>();
    private static int usercount=3;
    static {
        userList.add(new User(1,"adam",new Date()));
        userList.add(new User(2,"eve",new Date()));
        userList.add(new User(3,"jack",new Date()));

    }

    public List<User> findAll(){
        return userList;
    }

    public User saveUser(User user){
        if(user.getId()==null){
            user.setId((++usercount));
        }
        userList.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : userList){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id){
        Iterator<User> iterator= userList.iterator();
        while (iterator.hasNext()){
            User user =iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
