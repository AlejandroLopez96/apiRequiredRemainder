package com.api.requiredremainder.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.api.requiredremainder.utils.constants.RequiredRemainderConstants;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

    @Autowired
    //	If we have differents profiles of compilation this env variable gives us the chance to select values 
    //	from application-{profile}.properties and the generic application.properties
    private Environment env;

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl(this.env.getProperty("environment.url"));
        server.setDescription(this.env.getProperty("environment.description"));
        
        Info information = new Info()
                .title(RequiredRemainderConstants.OPEN_API_INFO_TITLE)
                .version(RequiredRemainderConstants.OPEN_API_INFO_VERSION)
                .description(RequiredRemainderConstants.OPEN_API_INFO_DESCRIPTION);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}