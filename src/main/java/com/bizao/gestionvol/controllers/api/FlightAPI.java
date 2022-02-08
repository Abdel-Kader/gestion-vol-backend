package com.bizao.gestionvol.controllers.api;

import com.bizao.gestionvol.dto.FlightDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

import static com.bizao.gestionvol.utils.Constants.API_ROOT;

public interface FlightAPI
{
    @PostMapping(
            value = API_ROOT + "/flight/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This endpoint allow you to add a new Flight in DB")
    FlightDTO saveFlight(@RequestBody FlightDTO dto);

    @GetMapping(value = API_ROOT + "/flight/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to fetch all flights from DB")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched All the flights",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "No flight found",
                    content = @Content)
    })
    List<FlightDTO> findAll();

    @GetMapping(value = API_ROOT + "/flight/{takeOffCity}/{landingCity}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to get flight comparaison by passing the take off date")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched flight details",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "No flight found",
                    content = @Content)
    })
    List<FlightDTO> compareFlight(@PathVariable("takeOffCity") Integer takeOffAirport,
                                  @PathVariable("landingCity") Integer landingAirport,
                                  @PathVariable("date") String date) throws ParseException;

    @GetMapping(value = API_ROOT + "/flight/{flightID}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to get flight details by passing the flight flightID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched flight details",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "No flight found",
                    content = @Content)
    })
    FlightDTO findByFlightID(@PathVariable("flightID") String flightID);
}
