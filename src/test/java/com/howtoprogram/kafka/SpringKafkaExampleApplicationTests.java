//package com.howtoprogram.kafka;
//
//import com.howtoprogram.kafka.model.User;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.UUID;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringKafkaExampleApplicationTests {
//
//    @Autowired
//    private KafkaTemplate<String, GenericRecord> kafkaTemplate;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    @Autowired
//    private GenericRecord genericRecord;
//
//   // @Test
//    public void contextLoads() throws InterruptedException {
//        User user = new User();
//        user.setId(UUID.randomUUID());
//        user.setSurname("Mulaudzi");
//        user.setName("Isaac");
//
//
//        genericRecord.put("user",user);
//        ProducerRecord<String,String> producerRecord = new ProducerRecord<String, String>("SpringKafkaTopic","Isaac_MUL");
//
//
////        ListenableFuture<SendResult<String, GenericRecord>> future = kafkaTemplate.send("SpringKafkaTopic",  genericRecord);
////        future.addCallback(new ListenableFutureCallback<SendResult<?, GenericRecord>>() {
////            @Override
////            public void onSuccess(SendResult<?, GenericRecord> result) {
////                System.out.println("success");
////            }
////
////            @Override
////            public void onFailure(Throwable ex) {
////                System.out.println("failed");
////            }
////        });
////        System.out.println(Thread.currentThread().getId());
////		assertThat(this.listener.countDownLatch1.await(60, TimeUnit.SECONDS)).isTrue();
//
//    }
//
////    public byte[] serialize(User user){
////
////        try {
////            return objectMapper.writeValueAsBytes(user);
////        } catch (Exception e) {
////            throw new SerializationException("Error serializing JSON message", e);
////        }
////
////    }
//
//    ///////////////////////////////////////////////////////////////
////    void producer(Schema schema) throws IOException {
////
//////        Properties props = new Properties();
//////        props.put("metadata.broker.list", "0:9092");
//////        props.put("serializer.class", "kafka.serializer.DefaultEncoder");
//////        props.put("request.required.acks", "1");
//////        ProducerConfig config = new ProducerConfig(props);
////        Producer<String, byte[]> producer = new Producer<String, byte[]>(config);
////        GenericRecord payload1 = new GenericData.Record(schema);
////        //Step2 : Put data in that genericrecord object
////        payload1.put("desc", "'testdata'");
////        //payload1.put("name", "अasa");
////        payload1.put("name", "dbevent1");
////        payload1.put("id", 111);
////        System.out.println("Original Message : "+ payload1);
////        //Step3 : Serialize the object to a bytearray
////        DatumWriter<GenericRecord>writer = new SpecificDatumWriter<GenericRecord>(schema);
////        ByteArrayOutputStream out = new ByteArrayOutputStream();
////        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
////        writer.write(payload1, encoder);
////        encoder.flush();
////        out.close();
////
////        byte[] serializedBytes = out.toByteArray();
////        System.out.println("Sending message in bytes : " + serializedBytes);
////        //String serializedHex = Hex.encodeHexString(serializedBytes);
////        //System.out.println("Serialized Hex String : " + serializedHex);
////        KeyedMessage<String, byte[]> message = new KeyedMessage<String, byte[]>("page_views", serializedBytes);
////        producer.send(message);
////        producer.close();
////
////    }
////
////
////    public static void main(String[] args) throws IOException, DecoderException {
////        ProducerTest test = new ProducerTest();
////        Schema schema = new Schema.Parser().parse(new File("src/test_schema.avsc"));
////        test.producer(schema);
////    }
//
//}
