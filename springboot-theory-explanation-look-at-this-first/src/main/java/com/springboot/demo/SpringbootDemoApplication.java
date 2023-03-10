package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.demo.sub1.SpringComponent;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootDemoApplication.class, args);
//	
	
		
		
		
		
	// SPRING BOOT -> concept are similar that's the there in spring, in addition -> spring boot helps us to quickly get started with the development aur kuch jada offer nahi krti spring boot 
		
	// what's the reason of introducing spring boot
	// earlier when the spring boot was not there
	//tab 
	// hota yeh tha ki hmko bhot configurations krni padti thi
	//spring app bnane k liye
	// jese lets say we're using hibernate 
	// toh uska apne ko sessionfactory vgera sab declare krna padta hh manually
	// mtlb configuration bhot jada tha + manually krna padta tha sab
	// example -> componentScan, dispatcherServlet, dataSource and session factory in hibernate/jpa 
	// toh isko automate krne k liye 
	// SPRING BOOT WAS INTRODUCTED
	
	
	
	// BENEFITS OF USING SPRING BOOT over SPRING 
	// 1. AutoConfiguration -> spring boot autoconfigure.jar file sab khud hi kr deti hh
			// jese apan agar spring-boot-starter-web dependency add krenge toh spring boot automatically sab tomcat server, dispatcher servlet, + other things sab kuch set kr deta using springbootautoconfig.jar  
	// 2. SpringBoot Starters
			// earlier we used to add multiple dependencies and maintain compatiable version
			// so springBoot starters are built to solve this problem
			// it basically groups multiple dependencies into one 
					//for example
					// rather than adding 
							// 1. spring mvc
							// spring orm
							// hibernate 
							// ......
					// these all dependency why do we create one that can manage these
				// for that springboot provides us with a dependency that contains multiple dependency  ---> spring-boot-starter-web,spring-boot-starter-test, spring-boot-starter-data-jpa, spring-boot-starter-security    -> this will manage all these dependencies with their compatible versions

			// there's one most important dependency -> spring-boot-starter-parent (PARENT DEPENDENCY) which comes by default and is added at the top or parent level
				// it does a lot of stuff behind the scenes
				// if we look closely we'll not see any versions specified with other spring-boot-starter-dependency in pom.xml file
				// coz whatever version is specified for parent dependency will also apply for the other starter dependencies
				// ---->
					// provides default configuration for the springboot application
							// java version -> default is 1.8
							// will provide maven plugins as well
							// dependency versions
	// 3. EMBEDDED SERVER
		// we don't need to download webserver to run our appliacation
		// spring boot provides us with 3 web servers
		// 1. TOMCAT -- by default
		// 2. JETTY 
		// 3. UNDERTOW
		// we also don't need to run web server explicitly in the production
		// as the .war file (the whole project) will automatically contain the same
		// so this download, setting up webserver and Deployin in that web server STEP GETS ELIMINATED WIHT THE HELP OF SPRING BOOT
		// we just need to package the app with .jar or .war file
		// and that's it
		// and this also means
		// we can directly run our app with single command from CMD as everthing is packed into app thanks to spring boot
		// so we got 2 ways to do that
				// 1. using java -jar command
					// go to project directory
					// first package the app to a jar file  (java must be installed on system)
						// using mvnw package (mvnw is maven wrapper)
					// navigate to target folder
					// java -jar jarfilename.jar
				// 2. using spring boot maven plugin
					// go to project directory
					// and simple run
					// mvn spring-boot:run
//		4. Spring Boot CLI
//		5.  Spring Boot Actuator
		
	
	
	//SPRING BOOT EXECUTION PROCESS
	
	// main() -> firstly main method run hota hh then 
	// run() static method call hota hh joki return krta hh ApplicaitonContext ka obj i.e. nothing but SPRING IOC container
	
			// what the run method does internally -> it performs bootstraping of our spring boot application
				// 1. StopWatch starts -> identify the time taken to bootstrap th esprign boot app
				//2. prepares environment ->  prepares the environment to run our spring boot app (dev, staging , prod, qa)
				//3. print banner - Spring boot logo prints out on console
				//4. start the IOC container - starts the IOC applicationContext container
				// 5. refresh context
				// 6. trigger runners (ApplicationRunner or CommandLineRunner)
				// 7. return applicationContext reference (Spring IOC Container reference will be returned)
	
	
	// TYPES of SPRING BOOT APPLICATIONS
		//1. DEFAULT 
				// if we have spring-boot-starter dependency(doesn't contain inbuilt tomcat server) in a classpath then the spring boot application comes under DEFAULT category
		//2. SERVLET
				// if we have spring-boot-starter-web  dependency in a classpath then the spring boot application comes under SERVLET category 
		//3. REACTIVE
				// if we have spring-boot-starter-webflux  dependency in a classpath then the spring boot application comes under REACTIVE category 
		// and these three dependencies are very important
	
	
	//ANNOTATION - nothing but an interface 
	
	// 1. @SpringBootApplication -> should be placed on the class that is starting the spring boot applicaiotn or you can say Starter class (which has a main method)
					// it internally contains -> @SpringBootConfiguraiton, @EnableAutoConfiguration, @ComponentScan
				// and @SpringBootConfiguration interally contains @Configuration annotation
	
				// there are 3 types of configuration that we can do
				// XML based configuration, java based configuration & Annotation based configuration
		
	
	///////////// AND WE USE @Configuration annotation to make a class as spring java based configuration class and we can then define the beans inside of that class //////////////////////
			// check SpringConfig.java file
	
			//@Component Annotation -> adding @Component annotation to a class will make it a spring component (or BEAN) and this make @componentScan annotation to look for the spring components easier
	
			// @ComponentScan -> to scan spring components (which is nothing but a BEAN) with in a base package
				// as this @springbootApplication annotation internally contains @componentScan annotation 
				// we can get all the spring components with in that package 
				// for com.springboot.demo (base package) we have @SpringBootAnnotation
				// so we can now get all the spring components from all the directories/packages inside of it like in sub1 & sub package
	
	
		// this run methods returns us the applicationContext which is nothing but Spring IOC container		
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(SpringbootDemoApplication.class, args);
			
		// now we can get the spring component or spring bean using getBean method
		SpringComponent component = applicationContext.getBean(SpringComponent.class);
		
		//we call the get message method
		System.out.println(component.getMessage());
		// this means @ComponentScan inside of @SpringBootApplication successfully scanned the SpringComponent class as we declared it as @component
		
	
		
		//now we've got the idea of how spring works and what is @SpringBootApplicatoin, @EnableAutoConfigurtion, @Component, @ComponentScan annotation
		
		
	}
}
