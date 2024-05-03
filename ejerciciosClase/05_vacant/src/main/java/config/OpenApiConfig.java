package config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/*------------------------
* SWAGGER CONFIGURATION
* -----------------------*/
@Configuration
@OpenAPIDefinition(info = @Info(title = "API to administrate companies and vacancies for companies",version = "1.0",description = "API documentation"))
public class OpenApiConfig {
}
