package com.api.requiredremainder.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.controller.RequiredRemainderController;
import com.api.requiredremainder.model.RequiredRemainderRequest;
import com.api.requiredremainder.model.RequiredRemainderResponse;
import com.api.requiredremainder.service.RequiredRemainderService;
import com.api.requiredremainder.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequiredRemainderControllerImpl implements RequiredRemainderController {
    
    @Autowired
    private RequiredRemainderService requiredRemainderService;

    @Override
    public ResponseEntity<RequiredRemainderResponse> getRequiredRemainder(Integer x, Integer y, Integer n) {
        log.info("Start RequiredRemainderController.getRequiredRemainder with param x: {}, y: {} and n: {}", x, y, n);
        RequiredRemainderResponse result = new RequiredRemainderResponse();
        
        try {
            result.setResult(this.requiredRemainderService.calculate(x, y, n));
		} catch (Exception e) {
            log.error("Error in RequiredRemainderController.getRequiredRemainder");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

        log.info("Finish RequiredRemainderController.getRequiredRemainder");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RequiredRemainderResponse> postRequiredRemainder(RequiredRemainderRequest request) {
        log.info("Start RequiredRemainderController.postRequiredRemainder with bodyParam: {}", Utils.jsonMe(request));
        RequiredRemainderResponse result = new RequiredRemainderResponse();
        
        try {
            result.setResult(this.requiredRemainderService.calculate(request.getX(), request.getY(), request.getN()));
		} catch (Exception e) {
            log.error("Error in RequiredRemainderController.postRequiredRemainder");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

        log.info("Finish RequiredRemainderController.postRequiredRemainder");
        return new ResponseEntity<RequiredRemainderResponse>(result, HttpStatus.OK);
    }

}
