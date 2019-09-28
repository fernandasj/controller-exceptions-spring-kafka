package br.edu.ifpb.pweb2.geradorexcecoes.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

    private String secretKey = "secret";

    //validade em milisegundos
    private long validityInMs = 3600000; // 1h
}
