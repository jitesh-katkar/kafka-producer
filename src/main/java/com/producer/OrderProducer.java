package com.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.common.model.OrderEvent;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic = "gi-topic3";

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OrderEvent event) {
        kafkaTemplate.send(topic, event);
    }
    
    
  
        public void send1(OrderEvent event) throws Exception {
            kafkaTemplate.send(topic, event);
            System.out.println("Message sent to topic : "+topic);
            
            //SendResult<String, Object> result = kafkaTemplate.send(topic, event).get();

           // System.out.println("Offset: " + result.getRecordMetadata().offset());
        }
    
}