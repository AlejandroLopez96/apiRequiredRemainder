package com.api.requiredremainder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.model.RequiredRemainderBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/required-remainder")
public interface RequiredRemainderController {

    @GetMapping("/calculate")
    public ResponseEntity<Integer> getRequiredRemainder(@RequestParam Integer x,
                                                        @RequestParam Integer y,
                                                        @RequestParam Integer n);

    @PostMapping("/calculate")
    public ResponseEntity<Integer> postRequiredRemainder(@RequestBody RequiredRemainderBody body);
    
}
