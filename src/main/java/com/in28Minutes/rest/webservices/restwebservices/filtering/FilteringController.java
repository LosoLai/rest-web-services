package com.in28Minutes.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveResource(){
        List<Resource> resource = Arrays.asList(new Resource("v1", "v2", "v3"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                                            .filterOutAllExcept("field1", "field2");

        return generateMapping(filter, resource);
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveResourceList(){
        List<Resource> list = Arrays.asList(new Resource("v11", "v21", "v31"),
                                            new Resource("v12", "v22", "v32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field3");

        return generateMapping(filter, list);
    }

    private MappingJacksonValue generateMapping(SimpleBeanPropertyFilter filter, List<Resource> resource){
        FilterProvider filters = new SimpleFilterProvider().addFilter("ResourceFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(resource);
        mapping.setFilters(filters);

        return mapping;
    }
}
