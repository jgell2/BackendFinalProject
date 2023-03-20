package com.promineotech.bands.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bands.entity.Shows;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

//controller for viewing shows stored in the shows table
@Validated
@RequestMapping("/view-shows")
@OpenAPIDefinition(info = @Info(title = "Shows Get Service"), 
    servers = {@Server(url="http://localhost:8080", description = "Local server.")})
public interface ViewAllShowsController {
//documentation for the get operation on the shows table for the HTTP status codes


    // @formatter:off
    @Operation(
        summary = "Returns a list of Shows",
        description = "Returns a list of all Shows in the shows table",
        responses = {
            @ApiResponse(responseCode = "200", description = "A List of Shows is returned.", 
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
    /**get mapping runs the fetch shows method which is passed on to the implementing 
     * class & shows all shows in the shows table
     **/
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Shows> fetchShows();
    // @formatter:on
}
