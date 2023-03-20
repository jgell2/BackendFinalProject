package com.promineotech.bands.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.promineotech.bands.entity.Shows;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//controller used to update entries in the show table
@Validated
@RequestMapping("/update-shows")
@OpenAPIDefinition(info = @Info(title = "Shows Update Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface UpdateShowsController {
  
  //documentation for the update operation for the show entity's HTTP status codes
  // @formatter:off
  @Operation(
      summary = "Updates an existing Show",
      description = "Updates an existing Show's Band",
      responses = {
          @ApiResponse(responseCode = "204", description = "A show is updated.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation =Shows.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Shows were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      })
  /**
   * put mapping uses a Path variable for the showPK as the URI and a 
   * request body in JSON to update a specific row of the show table
   **/
  @PutMapping("/{showPK}")
  public Shows updateShowBand(@PathVariable Long showPK, @RequestBody Shows show);
}
