package com.api.requiredremainder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.model.RequiredRemainderRequest;
import com.api.requiredremainder.model.RequiredRemainderResponse;
import com.api.requiredremainder.utils.constants.RequiredRemainderConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping(RequiredRemainderConstants.PATH_REQUIRED_REMAINDER_CONTROLLER)
public interface RequiredRemainderController {

    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = RequiredRemainderResponse.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content)})
    @Tag(name = "get", description = "GET methods of Required remainder APIs")
    @Operation(summary = "Calculate required remainder from 3 params",
       description = "Calculate required remainder from 3 request params (x, y, n). The response is a RequiredRemainderResponse with an Integer value.")
    @GetMapping(RequiredRemainderConstants.PATH_CALCULATE)
    public ResponseEntity<RequiredRemainderResponse> getRequiredRemainder(
        @Parameter(
        description = "Param 'x' to calculate required remainder",
        required = true) @RequestParam Integer x,
        @Parameter(
        description = "Param 'y' to calculate required remainder",
        required = true) @RequestParam Integer y,
        @Parameter(
        description = "Param 'n' to calculate required remainder",
        required = true) @RequestParam Integer n);

    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = RequiredRemainderResponse.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content)})                                                    
    @Tag(name = "post", description = "POST methods of Required remainder APIs")
    @Operation(summary = "Calculate required remainder from Object (RequiredRemainderRequest) with 3 fields",
       description = "Calculate required remainder from request body that's a object (RequiredRemainderRequest) which include 3 fields (x, y, n). The response is an Integer.")
    @PostMapping(RequiredRemainderConstants.PATH_CALCULATE)
    public ResponseEntity<RequiredRemainderResponse> postRequiredRemainder(@Valid @RequestBody RequiredRemainderRequest request);
    
}
