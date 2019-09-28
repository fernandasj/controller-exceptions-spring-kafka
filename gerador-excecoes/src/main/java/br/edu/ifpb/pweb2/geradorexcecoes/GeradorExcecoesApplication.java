package br.edu.ifpb.pweb2.geradorexcecoes;

import br.edu.ifpb.pweb2.geradorexcecoes.channels.GeradorExcecoesChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.processing.Processor;

@SpringBootApplication
@EnableBinding({Processor.class, GeradorExcecoesChannels.class})
public class GeradorExcecoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeradorExcecoesApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
