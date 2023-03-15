package com.promineotech.bands.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bands.entity.ShowRequest;
import com.promineotech.bands.entity.Shows;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/shows")
@OpenAPIDefinition(info = @Info(title = "Add Band Service"), 
     servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface ShowAddController {
  // @formatter:off
  @Operation(
      summary = "Create a new Show",
      description = "Returns the created Show",
      responses = {
          @ApiResponse(responseCode = "201", description = "The created Show is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Shows.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "A show component was not found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(name = "showRequest", 
              required = true, 
              description = "The show as JSON")
      }
   )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Shows createShow(@Valid @RequestBody ShowRequest showRequest);
  //@formatter:on
}
