package pl.mlopatka.warehouse.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Warehouse {
    private long id;
    private int capacity;
    private int occupied;
}
