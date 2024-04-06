package com.api.requiredremainder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.model.RequiredRemainderBody;
import com.api.requiredremainder.utils.constants.RequiredRemainderConstants;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(RequiredRemainderConstants.PATH_REQUIRED_REMAINDER_CONTROLLER)
public interface RequiredRemainderController {

    @GetMapping(RequiredRemainderConstants.PATH_CALCULATE)
    public ResponseEntity<Integer> getRequiredRemainder(@RequestParam Integer x,
                                                        @RequestParam Integer y,
                                                        @RequestParam Integer n);

    @PostMapping(RequiredRemainderConstants.PATH_CALCULATE)
    public ResponseEntity<Integer> postRequiredRemainder(@Valid @RequestBody RequiredRemainderBody body);
    
}
