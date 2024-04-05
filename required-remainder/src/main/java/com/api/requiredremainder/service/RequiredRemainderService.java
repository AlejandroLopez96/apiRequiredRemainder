package com.api.requiredremainder.service;

import org.springframework.stereotype.Service;

@Service
public interface RequiredRemainderService {

    public Integer calculate(Integer x, Integer y, Integer n) throws Exception;

}
