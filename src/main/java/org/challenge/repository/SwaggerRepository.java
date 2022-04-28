package org.challenge.repository;

import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SwaggerRepository {
    Map<String, Swagger> swaggers = new HashMap<>();
    Map<String, Path> paths = new HashMap<>();

    public Swagger getSwagger(String source) {
        if (!swaggers.containsKey(source)) {
            Swagger swagger = new SwaggerParser().read(source);
            for (String path : swagger.getPaths().keySet()) {
                paths.putIfAbsent(path, swagger.getPaths().get(path));
            }
            swaggers.put(source, swagger);
        }
        return swaggers.get(source);
    }

    public Path getPath(String path) {
        return paths.get(path);
    }
}
