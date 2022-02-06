package com.bizao.gestionvol.controllers.api;

import org.springframework.http.MediaType;
import com.bizao.gestionvol.dto.AirportDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.bizao.gestionvol.utils.Constants.API_ROOT;
public interface AirportAPI
{
    @PostMapping(
            value = API_ROOT + "/airport/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This endpoint allow you to create a new Airport in DB")
    AirportDTO saveAirport(@RequestBody AirportDTO airport);


    @GetMapping(value = API_ROOT + "/airport/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to fetch all airports from DB")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched All the airports",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "No airport found",
                    content = @Content)
    })
    List<AirportDTO> findAll();
}
