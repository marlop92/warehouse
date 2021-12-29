package pl.mlopatka.warehouse.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class OrdersSender {

    private final KafkaTemplate<String, String> template;
    private final ObjectMapper mapper;

    @PostConstruct
    void sendMessage() throws JsonProcessingException {
        Order order = new Order(10);
        template.send("orders-topic",mapper.writeValueAsString(order));
    }
}
