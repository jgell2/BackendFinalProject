package com.promineotech.bands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

//class with main method that runs the spring app
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class StartApplication {

  
  public static void main(String[] args) {
    SpringApplication.run(StartApplication.class, args);

  }

}
