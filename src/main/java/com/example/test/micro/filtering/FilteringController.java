package com.example.test.micro.filtering;

import com.example.test.micro.stubs.ExampleBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveBean(){
        ExampleBean exampleBean= new ExampleBean("1","2","3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("ExampleBeanFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(exampleBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }


}
