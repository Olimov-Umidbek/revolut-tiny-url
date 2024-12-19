package uz.umidbek.service.storage.impl;

import uz.umidbek.exceptions.StorageOutBoundException;
import uz.umidbek.service.storage.Storage;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryStorage implements Storage {
    private final Map<String, String> storage = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public String putAndGet(String longUrl, String shortUrl) {
        if (count.incrementAndGet() >= 100) {
            throw new StorageOutBoundException("Storage is full");
        }

        storage.put(shortUrl, longUrl);
        return shortUrl;
    }

    @Override
    public Optional<String> get(String shortUrl) {
        return Optional.ofNullable(storage.get(shortUrl));
    }

    @Override
    public String put(String longUrl, String shortUrl) {
        return storage.put(longUrl, shortUrl);
    }
}
