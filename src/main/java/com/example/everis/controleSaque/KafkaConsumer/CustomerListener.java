package com.example.everis.controleSaque.KafkaConsumer;

import com.example.everis.controleSaque.Controller.QtdSaquesController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
@Service
public class CustomerListener {
    @Autowired
    private QtdSaquesController qtd;

    @KafkaListener(topics = "BANCO_NOVO_SAQUE",groupId = "BANCO_NOVO_SAQUE")
    @SendTo
    public String listen(String cpf){
        String uuid = qtd.alterarQtdSaquesBanco(cpf);
        System.out.println("---------------------------");
        System.out.println("Novo saque, checando fraude");
        System.out.println(uuid);
        System.out.println("Saque Efetuado");
        System.out.println("Adicionando +1 saque no banco de dados");
        System.out.println("---------------------------");
        return "salvo" + uuid ;
    }
}
