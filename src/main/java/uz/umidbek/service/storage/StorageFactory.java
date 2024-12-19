package uz.umidbek.service.storage;

import uz.umidbek.enums.StorageType;
import uz.umidbek.exceptions.UnknownAlgorithmException;
import uz.umidbek.service.storage.impl.InMemoryStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class StorageFactory {
    private static StorageFactory INSTANCE;
    private final Map<StorageType, Storage> map = new ConcurrentHashMap<>();
    private StorageFactory() {
        map.put(StorageType.IN_MEMORY, new InMemoryStorage());
    }

    public static synchronized StorageFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StorageFactory();
        }
        return INSTANCE;
    }

    public Storage getAlgorithm(StorageType storageType) {
        if (!map.containsKey(storageType)) {
            throw new UnknownAlgorithmException("Implementation not found for storage = " + storageType);
        }
        return map.get(storageType);
    }

}
