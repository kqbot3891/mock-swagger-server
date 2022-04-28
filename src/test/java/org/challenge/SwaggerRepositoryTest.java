package org.challenge;

import org.challenge.repository.SwaggerRepository;
import org.junit.jupiter.api.Test;

public class SwaggerRepositoryTest {

    @Test
    public void Test() {
        SwaggerRepository repository = new SwaggerRepository();
        repository.getSwagger("http://rackerlabs.github.io/wadl2swagger/openstack/swagger/identity.yaml");
    }
}
