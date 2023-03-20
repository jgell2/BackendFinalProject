package com.promineotech.bands.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.promineotech.bands.entity.Shows;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//controller for deleting a specific show, uses the uri "http://localhost:8080/delete-show/{showPK}
@Validated
@RequestMapping("/delete-show")
@OpenAPIDefinition(info = @Info(title = "Shows Delete Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})

//documentation for HTTP status codes for the controller
public interface DeleteShowController {
  @Operation(
      summary = "Deletes a specified show",
      description = "Deletes a show specified by a show's primary key",
      responses = {
          @ApiResponse(responseCode = "200", description = "A show is deleted.", 
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
      }
      )

  //delete mapping uses the showPK path variable in the URI to delete a specific show
  @DeleteMapping("/{showPK}")
  public void deleteShow(@PathVariable Long showPK);
}
