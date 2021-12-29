package pl.mlopatka.warehouse.warehouse;

public class NoAvailableWarehouseException extends RuntimeException{

    public NoAvailableWarehouseException(int amount) {
        super("No available warehouse for given product amount " + amount);
    }
}
