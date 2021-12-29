package pl.mlopatka.warehouse.warehouse;

import pl.mlopatka.warehouse.order.Order;

public interface WarehouseRepository {

    long storeInWarehouse(Order order);

}
