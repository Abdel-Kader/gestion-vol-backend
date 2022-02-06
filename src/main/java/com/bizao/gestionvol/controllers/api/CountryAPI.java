package com.bizao.gestionvol.controllers.api;

import com.bizao.gestionvol.dto.CountryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.bizao.gestionvol.utils.Constants.API_ROOT;

public interface CountryAPI
{
    @PostMapping(
            value = API_ROOT + "/country/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This endpoint allow you to create a new Country in DB")
    CountryDTO saveCountry(@RequestBody CountryDTO dto);

    @GetMapping(value = API_ROOT + "/country/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to fetch all countries from DB")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched All the countries",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "No country found",
                    content = @Content)
    })
    List<CountryDTO> findAll();

}