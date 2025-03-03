package pl.justitia.ingester.service;

import pl.justitia.ingester.model.Item;

public interface FileService {
    void saveItem(Item item);
}
