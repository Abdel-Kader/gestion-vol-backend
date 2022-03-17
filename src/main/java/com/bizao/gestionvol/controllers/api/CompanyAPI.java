package com.bizao.gestionvol.controllers.api;

import com.bizao.gestionvol.dto.CompanyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

import static com.bizao.gestionvol.utils.Constants.API_ROOT;

public interface CompanyAPI
{
    @PostMapping(
            value = API_ROOT + "/company/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This endpoint allow you to create a new Company in DB")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Company created successfully",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Arguments are not valid",
                    content = @Content)
    })
    ResponseEntity<CompanyDTO> saveCompany(@Valid @RequestBody CompanyDTO dto);



    @GetMapping(value = API_ROOT + "/company/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "This allow you to fetch all companies from DB")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched All the companies or Empty array if no company found",
                    content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<List<CompanyDTO>> findAll();
}
