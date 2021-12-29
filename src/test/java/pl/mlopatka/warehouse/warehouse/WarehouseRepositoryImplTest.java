package pl.mlopatka.warehouse.warehouse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.mlopatka.warehouse.order.Order;
import pl.mlopatka.warehouse.warehouse.entity.Warehouse;
import pl.mlopatka.warehouse.warehouse.entity.WarehouseRepository;
import pl.mlopatka.warehouse.warehouse.entity.WarehouseServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class WarehouseRepositoryImplTest {

    @Mock
    private WarehouseRepository mockRepo;
    @InjectMocks
    private WarehouseServiceImpl service;

    @Test
    void shouldStoreOrderInProperWarehouse() {
        Order order = new Order(5);
        Mockito.when(mockRepo.findAll()).thenReturn(List.of(
                new Warehouse("1", 50, 49),
                new Warehouse("2", 50, 50),
                new Warehouse("3", 50, 20)
        ));

        String warehouseId = service.storeInWarehouse(order);

        assertEquals("3", warehouseId);
    }

    @Test
    void shouldThrowWhenNoWarehouseAvailable() {
        Order order = new Order(50);
        Mockito.when(mockRepo.findAll()).thenReturn(List.of(
                new Warehouse("1", 50, 49),
                new Warehouse("2", 50, 50),
                new Warehouse("3", 50, 20)
        ));

        Executable action = () -> service.storeInWarehouse(order);

        assertThrows(NoAvailableWarehouseException.class, action,
                "No available warehouse for given product amount 50");
    }
}