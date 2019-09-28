package br.edu.ifpb.pweb2.monitorexcecoes;

import br.edu.ifpb.pweb2.monitorexcecoes.channels.MonitorExcecoesChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import javax.annotation.processing.Processor;


@SpringBootApplication
@EnableBinding({Processor.class, MonitorExcecoesChannels.class})
public class MonitorExcecoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorExcecoesApplication.class, args);
    }

}
