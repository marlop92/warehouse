package pl.mlopatka.warehouse.warehouse;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import pl.mlopatka.warehouse.warehouse.entity.Warehouse;
import pl.mlopatka.warehouse.warehouse.entity.WarehouseRepository;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class WarehouseConfig {

    private final WarehouseRepository repository;

    @PostConstruct
    void initDb(){
        repository.deleteAll();
        repository.save(new Warehouse("1", 50, 47));
        repository.save(new Warehouse("2", 50, 50));
        repository.save(new Warehouse("3", 50, 23));
    }

}
