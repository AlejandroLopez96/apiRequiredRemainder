package com.api.requiredremainder.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.controller.RequiredRemainderController;
import com.api.requiredremainder.model.RequiredRemainderBody;
import com.api.requiredremainder.service.RequiredRemainderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequiredRemainderControllerImpl implements RequiredRemainderController {
    
    @Autowired
    private RequiredRemainderService requiredRemainderService;

    @Override
    public ResponseEntity<Integer> getRequiredRemainder(Integer x, Integer y, Integer n) {
        log.info("Start RequiredRemainderController.getRequiredRemainder with param x: {}, y: {} and n: {}", x, y, n);
        Integer result = null;
        
        try {
            result = this.requiredRemainderService.calculate(x, y, n);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> postRequiredRemainder(RequiredRemainderBody body) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postRequiredRemainder'");
    }

}
