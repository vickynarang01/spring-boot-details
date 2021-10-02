package com.example.test.micro.controller;

import com.example.test.micro.versioning.Name;
import com.example.test.micro.versioning.PersonV1;
import com.example.test.micro.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("v1/person")
   public PersonV1 getPerson(){
       return new PersonV1("Bob Charlie");
   }

   @GetMapping("/v2/person")
   public PersonV2 getPerson2(){
       return new PersonV2(new Name("Bob","Charlie"));
   }

   //Request Parameter versioning
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


    //Header Versioning
    @GetMapping(value = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1("Bob Charlie");
    }

    //Accept Header versioninng
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producerV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }



}

