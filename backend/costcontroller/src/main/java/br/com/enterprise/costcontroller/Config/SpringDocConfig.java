package br.com.enterprise.costcontroller.Config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI()
                .info(
                    new Info()
                    .title("Cost controller")
                    .version("0.0.1")
                    .description("Enterprise monthly cost controller"));
    }
}