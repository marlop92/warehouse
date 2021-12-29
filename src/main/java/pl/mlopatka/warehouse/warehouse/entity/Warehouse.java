package pl.mlopatka.warehouse.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("warehouse")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Warehouse {

    @Id
    private String id;
    private int capacity;
    private int occupied;
}
