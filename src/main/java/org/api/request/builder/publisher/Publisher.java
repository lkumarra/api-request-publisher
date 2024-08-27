package org.api.request.builder.publisher;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.api.request.builder.helpers.PropertyReaderHelper;
import org.api.request.builder.requestModel.APIRequest;

@Slf4j
public class Publisher {

    private final KafkaProducer<String, String> producer;
    private final PropertyReaderHelper propertyReaderHelper;

    public Publisher() {
        propertyReaderHelper = new PropertyReaderHelper(System.getProperty("user.dir") + "/src/main/resources/kafka-publisher.properties");
        this.producer = new KafkaProducer<>(propertyReaderHelper.getProperties());
    }

    public void publishMessage(APIRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(request);
        producer.send(new ProducerRecord<>(propertyReaderHelper.getProperty("request.publisher"), message));
        log.info("Published message : {}", message);
    }

}
