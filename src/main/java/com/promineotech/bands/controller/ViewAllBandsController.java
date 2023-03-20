package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bands.entity.Band;
import com.promineotech.bands.entity.Shows;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//controller used to view bands listed in the band table 
@Validated
@RequestMapping("/view-bands")
@OpenAPIDefinition(info = @Info(title = "Bands Get Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface ViewAllBandsController {
 
  //documentation for the HTTP codes for the get operation for bands
      // @formatter:off
      @Operation(
          summary = "Returns a list of Bands",
          description = "Returns a list of all Bands in the bands table",
          responses = {
              @ApiResponse(responseCode = "200", description = "A List of bands is returned.", 
                  content = @Content(mediaType = "application/json", 
                  schema = @Schema(implementation =Band.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameters are invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No bands were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          )
      
      //get mapping runs the fetch bands method and returns all bands in the bands table
      @GetMapping
      @ResponseStatus(code = HttpStatus.OK)
      List<Band> fetchBands();
      // @formatter:on
  }



