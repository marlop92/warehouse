package pl.mlopatka.warehouse.warehouse;

import pl.mlopatka.warehouse.order.Order;

public interface WarehouseService {

    String storeInWarehouse(Order order);

}
