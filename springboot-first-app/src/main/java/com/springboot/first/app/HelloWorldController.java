package com.springboot.first.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

	//@Controller -> to make this class handle particular routes
	//@ResponseBody -> convert the java object to xml, json
	
	// we can define these 2 annotations is 1 
	// by using @RestController Annotation -> @Controller + @ResponseBody
	
	
	// now that we've added this annotation this class can now 
	// handle web requests
			//get 
			//post
			//put 
			//delete
	
	
	// In order to make a method as REST end point 
	// we need to use @GetMapping annotation  (@PostMapping, @PutMapping, @DeleteMapping is also there)
	// GET HTTP METHOD
	// and we can define the route or URI for it inside as 1st param
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!!!!!!";
	}
	// http://localhost:8080/hello-world
	
}
