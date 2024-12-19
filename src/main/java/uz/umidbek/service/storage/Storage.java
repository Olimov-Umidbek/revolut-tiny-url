package uz.umidbek.service.storage;

import java.util.Optional;

public interface Storage {

    public String putAndGet(String longUrl, String shorUrl);

    public Optional<String> get(String shortUrl);

    public String put(String longUrl, String shortUrl);
}
