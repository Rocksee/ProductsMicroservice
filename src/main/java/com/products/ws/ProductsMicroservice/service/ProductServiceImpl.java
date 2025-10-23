package com.products.ws.ProductsMicroservice.service;

import com.products.ws.ProductsMicroservice.rest.CreatedProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public String createProduct(CreatedProductRestModel productRestModel) throws Exception{

        String productID = UUID.randomUUID().toString();

        // TODO: Persist product details into DB table before publishing an event

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(productRestModel.getTitle(), productRestModel.getPrice(),
                productRestModel.getQuantity(),productID);

        LOGGER.info("Before publishing a ProductCreatedEvent");
        SendResult<String, ProductCreatedEvent> result = kafkaTemplate
                .send("topic2", productID, productCreatedEvent)
                .get();
//product-created-event-topic
        // *** Use completable future if you want it to be async
//        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
//                kafkaTemplate.send("product-created-event-topic", productID, productCreatedEvent);
//        future.whenComplete((result, exception) -> {
//            if (exception != null) {
//                LOGGER.error("Failed to send the message: " + exception.getMessage());
//            } else {
//                LOGGER.info("Successfully sent the message: " + result.getRecordMetadata());
//            }
//        });
        //if you want to wait for async operation to complete and block the current thread (so it will become synchronous)
//        future.join();
        LOGGER.info("Get Partition Info: " + result.getRecordMetadata().partition());
        LOGGER.info("Topic: " + result.getRecordMetadata().topic());
        LOGGER.info("Offset: " + result.getRecordMetadata().offset());
        LOGGER.info("************* Returning product ID");
        return productID;
    }
}
