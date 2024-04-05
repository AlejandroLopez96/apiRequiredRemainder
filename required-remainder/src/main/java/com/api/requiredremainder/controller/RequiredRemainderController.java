package com.api.requiredremainder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.model.RequiredRemainderBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/required-remainder")
public interface RequiredRemainderController {

    @GetMapping("/calculate/{x}/{y}/{n}")
    public ResponseEntity<Integer> getRequiredRemainder(@PathVariable Integer x,
                                                        @PathVariable Integer y,
                                                        @PathVariable Integer n);

    @PostMapping("/calculate")
    public ResponseEntity<Integer> postRequiredRemainder(@RequestBody RequiredRemainderBody body);
    
}
