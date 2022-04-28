package org.challenge;

import org.challenge.service.SwaggerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootTest
public class SwaggerServiceTest {

    @Autowired
    SwaggerService swaggerService;

    @Test
    public void test() {
        swaggerService.getMockResponse("/", RequestMethod.GET, HttpStatus.OK);
    }
}
