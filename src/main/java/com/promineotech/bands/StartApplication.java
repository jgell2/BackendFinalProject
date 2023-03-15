package com.promineotech.bands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;


@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class StartApplication {

  
  public static void main(String[] args) {
    SpringApplication.run(StartApplication.class, args);

  }

}
