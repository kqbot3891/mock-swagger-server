package org.challenge.service;

import io.swagger.models.Operation;
import io.swagger.models.Path;
import org.challenge.repository.SwaggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class SwaggerService {

    private SwaggerRepository swaggerRepository;

    @Autowired
    public SwaggerService(SwaggerRepository swaggerRepository) {
        this.swaggerRepository = swaggerRepository;
    }

    public Object getMockResponse(String path, RequestMethod method, HttpStatus status) {
        swaggerRepository.getSwagger("http://rackerlabs.github.io/wadl2swagger/openstack/swagger/identity.yaml");
        Path endpoint = swaggerRepository.getPath(path);
        Operation operation;
        switch(method) {
            case PUT:
                operation = endpoint.getPut();
                break;
            case POST:
                operation = endpoint.getPost();
                break;
            case DELETE:
                operation = endpoint.getDelete();
                break;
            case PATCH:
                operation = endpoint.getPatch();
            default:
                operation = endpoint.getGet();
        }
        return operation.getResponsesObject().get(String.valueOf(status.value())).getExamples().get("application/json");
    }
}
