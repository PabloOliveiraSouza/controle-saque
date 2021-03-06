package com.example.everis.controleSaque;
import com.example.everis.controleSaque.KafkaConsumer.AdicionarQtdSaque;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableKafka
public class ControladorDeSaqueApplication{

	public static void main(String[] args)  {
		SpringApplication.run(ControladorDeSaqueApplication.class, args);

	}




}
