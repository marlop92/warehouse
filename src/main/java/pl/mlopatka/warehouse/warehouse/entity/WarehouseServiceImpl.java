package pl.mlopatka.warehouse.warehouse.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mlopatka.warehouse.order.Order;
import pl.mlopatka.warehouse.warehouse.NoAvailableWarehouseException;
import pl.mlopatka.warehouse.warehouse.WarehouseService;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public String storeInWarehouse(Order order) {
        return warehouseRepository.findAll().stream()
                .filter(w -> w.getOccupied() + order.getProductAmount() <= w.getCapacity())
                .map(Warehouse::getId)
                .findFirst()
                .orElseThrow(() -> new NoAvailableWarehouseException(order.getProductAmount()));
    }
}
