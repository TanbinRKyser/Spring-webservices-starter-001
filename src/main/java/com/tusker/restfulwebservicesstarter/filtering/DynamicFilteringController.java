package com.tusker.restfulwebservicesstarter.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DynamicFilteringController {

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean2 someBean2 = new SomeBean2( 1, "name", "title", "details" );


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "name", "title" );

        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue( someBean2 );
        mappingJacksonValue.setFilters( provider );

        return mappingJacksonValue;
    }
    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveListBean(){
        List<SomeBean2> someBean2List = List.of(
                new SomeBean2( 2, "name2", "title2", "details2" ),
                new SomeBean2( 3, "name3", "title3", "details3" )
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept( "title", "details" );

        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue( someBean2List );
        mappingJacksonValue.setFilters( provider );

        return mappingJacksonValue;
    }
}
