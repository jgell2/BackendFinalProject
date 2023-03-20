package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.City;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


//controller used to view cities listed in the cities table 
@Validated
@RequestMapping("/view-cities")
@OpenAPIDefinition(info = @Info(title = "Cities Get Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface ViewCitiesController {
  
  //documentation for the HTTP codes for the get operation for cities
  // @formatter:off
  @Operation(
      summary = "Returns a list of Cities",
      description = "Returns a list of all Cities in the cities table",
      responses = {
          @ApiResponse(responseCode = "200", description = "A List of cities is returned.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation =Band.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No cities were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      }
      )
  
  //get mapping runs the fetch cities method and returns all cities in the cities table
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<City> fetchCities();

}
