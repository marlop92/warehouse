package pl.mlopatka.warehouse.warehouse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.mlopatka.warehouse.order.Order;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseRepositoryImplTest {

    private WarehouseRepositoryImpl repository = new WarehouseRepositoryImpl();

    @Test
    void shouldStoreOrderInProperWarehouse() {
        Order order = new Order(5);

        long warehouseId = repository.storeInWarehouse(order);

        assertEquals(3L, warehouseId);
    }

    @Test
    void shouldThrowWhenNoWarehouseAvailable() {
        Order order = new Order(50);

        Executable action = () -> repository.storeInWarehouse(order);

        assertThrows(NoAvailableWarehouseException.class, action,
                "No available warehouse for given product amount 50");
    }
}