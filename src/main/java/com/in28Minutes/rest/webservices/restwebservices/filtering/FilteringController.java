package com.in28Minutes.rest.webservices.restwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public Resource retrieveResource(){
        return new Resource("v1", "v2", "v3");
    }

    @GetMapping("/filtering-list")
    public List<Resource> retrieveResourceList(){
        return Arrays.asList(new Resource("v11", "v21", "v31"),
                             new Resource("v12", "v22", "v32"));
    }
}
