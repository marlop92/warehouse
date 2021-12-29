package pl.mlopatka.warehouse.warehouse;

import org.springframework.stereotype.Repository;
import pl.mlopatka.warehouse.order.Order;

import java.util.List;
import java.util.Map;

@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository {

    private static final Map<Long, Warehouse> WAREHOUSES = Map.of(
        1L, new Warehouse(1, 50, 49),
        2L, new Warehouse(2, 50, 50),
        3L, new Warehouse(3, 50, 20)
    );

    @Override
    public long storeInWarehouse(Order order) {
        return WAREHOUSES.values().stream()
                .filter(w -> w.getOccupied() + order.getProductAmount() <= w.getCapacity())
                .map(Warehouse::getId)
                .findFirst()
                .orElseThrow(() -> new NoAvailableWarehouseException(order.getProductAmount()));
    }
}
