package swagger.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${wafa.api.version}")
    private String apiVersion;

    @Value("${wafa.api.server}")
    private String apiServerType;

    @Value("${wafa.api.url}")
    private String apiUrl;

    @Value("${wafa.api.route}")
    private String apiRoute;

    @Bean
    public OpenAPI openApiDefinitionBuilder() {
        return new OpenAPI()
                .info(openApiInfoBuilder())
                .tags(openApiTagBuilder())
                .addServersItem(new Server().description(apiServerType).url(apiUrl + apiRoute));
    }

    private Info openApiInfoBuilder() {
        return new Info()
                .title("Books Service API")
                .version(apiVersion)
                .description("A simple REST Api for management books")
                .contact(new Contact().name("Ahmed Douinir").email("dwainir@gmail.com"));
    }

    private List<Tag> openApiTagBuilder() {
        return Arrays.asList(new Tag().name("Books Service").description("A simple books api to test swagger functionality"));
    }

}
