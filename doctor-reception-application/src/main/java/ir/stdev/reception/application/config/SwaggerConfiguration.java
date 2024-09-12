package ir.stdev.reception.application.config;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Value("${project.openApi.dev-url}")
    private String devUrl;

//    @Bean
//    public OpenAPI myOpenApi(){
//        Server devServer = new Server();
//        devServer.setUrl(devUrl);
//        devServer.setDescription("Dev Server");
//
//        Info info = new Info()
//                .title("Doctor Reception Application")
//                .version("1.0.0");
//
//        return new OpenAPI().info(info).servers(List.of(devServer));
//    }
}
