package pl.mlopatka.warehouse.warehouse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.mlopatka.warehouse.order.Order;
import pl.mlopatka.warehouse.warehouse.entity.WarehouseRepository;

@Service
@RequiredArgsConstructor
public class WarehouseHandler {

    private final WarehouseService service;
    private final ObjectMapper mapper;

    @KafkaListener(id = "simpleOrderListener", topics = "orders-topic")
    public void transportListener(String rawOrder) throws JsonProcessingException {
        Order order = mapper.readValue(rawOrder, Order.class);
        String warehouseId = service.storeInWarehouse(order);
        System.out.printf("Stored in warehouse: %s order %s", warehouseId, order);
    }

}
