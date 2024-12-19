package uz.umidbek.service;

import uz.umidbek.exceptions.EmptyUrlException;
import uz.umidbek.service.shortener.ShortenerAlgorithm;
import uz.umidbek.service.storage.Storage;

import java.util.Optional;
import java.util.logging.Logger;

public class ShortenerService {
    private final Storage storage;
    private final ShortenerAlgorithm algorithm;

    private final Logger logger = Logger.getLogger(ShortenerService.class.getName());

    public ShortenerService(Storage storage, ShortenerAlgorithm algorithm) {
        this.storage = storage;
        this.algorithm = algorithm;
    }

    public String put(String longUrl) {
        validate(longUrl);

        String shortUrl = "https://www.rev.me/" +
            algorithm.compress(longUrl);

        return storage.putAndGet(longUrl, shortUrl);
    }

    public Optional<String> get(String shortUrl) {
        validate(shortUrl);
        return storage.get(shortUrl);
    }

    private void validate(String url) {
        boolean valid = url != null;
        if (!valid) {
            throw new EmptyUrlException("Invalid url, url value is: " + url);
        }
    }
}
