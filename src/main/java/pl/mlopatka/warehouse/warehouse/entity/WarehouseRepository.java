package pl.mlopatka.warehouse.warehouse.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehouseRepository extends MongoRepository<Warehouse, String> {


}
