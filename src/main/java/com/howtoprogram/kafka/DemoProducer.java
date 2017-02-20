package com.howtoprogram.kafka;

import com.howtoprogram.kafka.generatedAvro.UserGen;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by isaac on 2017/02/17.
 */
@EnableKafka
@Configuration
public class DemoProducer {

    public static void main(String [] args) throws Exception{
        Producer<String, GenericRecord> producer = new KafkaProducer<>(producerConfigs());



        for (int i = 0; i <40; i++) {
            UserGen userGen = new UserGen();
//            userGen.setId(UUID.randomUUID().toString());
            userGen.setName("Isaac"+i);
            userGen.setSurname("Mulaudzi" + i);
            producer.send(new ProducerRecord<>("SpringKafkaTopic", userGen));

        }
        producer.close();
    }

    @Bean
    public static Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }
}
