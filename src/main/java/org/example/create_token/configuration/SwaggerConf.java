package org.example.create_token.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@OpenAPIDefinition(
        info = @Info(

                contact = @Contact(
                        name = "Token and NoSQL practs"
//                        email = "feruzbekhamrayev2002@gmail.com"
                ),
                title = "JWT token and NoSQL practice",
                version = "1.0.0",
                description = "NoSQL va Token bilan integratsiya qilish qismi"
        )

//        security = @SecurityRequirement(
//                name = "OAuth2.0"
//        )
)
public class SwaggerConf {
}
