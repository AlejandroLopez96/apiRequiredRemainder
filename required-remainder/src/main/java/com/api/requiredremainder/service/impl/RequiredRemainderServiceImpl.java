package com.api.requiredremainder.service.impl;

import org.springframework.stereotype.Service;

import com.api.requiredremainder.service.RequiredRemainderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequiredRemainderServiceImpl implements RequiredRemainderService {
    
    @Override
    public Integer calculate(Integer x, Integer y, Integer n) throws Exception {
        log.info("Start RequiredRemainderService.calculate with params x: {}, y: {} and n: {}", x, y, n);
		Integer result = null;
		
		try {

			// w is to get the difference from n to k
			Integer w = (n - y) % x;

			// This condition is to avoid negative values
			if (n - w < 0) {
				// Add n to have positive value
				result = n - w + n;
			} else 
				result = n - w;
			
		} catch (Exception e) {
			log.error("There is an Exception in RequiredRemainderService.calculate: {}", e.getMessage());
			throw e;
		}
		
		log.info("Finish RequiredRemainderService.calculate : {}", result);
		return result;
    }

}
