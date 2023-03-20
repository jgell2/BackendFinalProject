package com.promineotech.bands.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bands.entity.Album;
import com.promineotech.bands.entity.Band;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//Controller mapped to http://localhost:8080/view-albums used to view all albums
@Validated
@RequestMapping("/view-albums")
@OpenAPIDefinition(info = @Info(title = "Albums Get Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface ViewAlbumsController {
  
  //documentation for the view albums response codes
//@formatter:off
  @Operation(
      summary = "Returns a list of Albums",
      description = "Returns a list of all Albums in the albums table and the bands associated with them",
      responses = {
          @ApiResponse(responseCode = "200", description = "A List of albums is returned.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation =Band.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No albums were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      }
      )
  //get mapping runs the fetchAllAlbums method which runs in the implementing class
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Album> fetchAlbums();
  // @formatter:on

}
