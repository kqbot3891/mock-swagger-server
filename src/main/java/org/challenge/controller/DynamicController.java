package org.challenge.controller;

import org.challenge.context.HeaderConstants;
import org.challenge.service.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class DynamicController {

    private final SwaggerService swaggerService;

    @Autowired
    public DynamicController(SwaggerService swaggerService) {
        this.swaggerService = swaggerService;
    }

    @RequestMapping(value="/{endPoint}", method= RequestMethod.GET)
    public ResponseEntity endPoint(@PathVariable String endPoint, @RequestHeader HttpHeaders headers) {
        HttpStatus status = headers.containsKey(HeaderConstants.STATUS) ?
                HttpStatus.resolve(Integer.parseInt(Objects.requireNonNull(headers.get(HeaderConstants.STATUS)).get(0)))
                : HttpStatus.OK;
        Object response = swaggerService.getMockResponse("/" + endPoint, RequestMethod.GET, status);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
