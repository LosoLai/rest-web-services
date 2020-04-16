package com.in28Minutes.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("ResourceFilter")
public class Resource {
    private String field1;
    private String field2;
    private String field3;

    public Resource(String v1, String v2, String v3) {
        field1 = v1;
        field2 = v2;
        field3 = v3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
