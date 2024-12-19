package uz.umidbek.service;


import org.junit.Test;
import uz.umidbek.enums.Algorithm;
import uz.umidbek.enums.StorageType;
import uz.umidbek.exceptions.EmptyUrlException;
import uz.umidbek.service.shortener.ShortenerAlgorithm;
import uz.umidbek.service.shortener.ShortenerFactory;
import uz.umidbek.service.storage.Storage;
import uz.umidbek.service.storage.StorageFactory;

import static org.junit.Assert.*;

public class ShortenerServiceTest {
    private final Storage storage = StorageFactory.getInstance().getAlgorithm(StorageType.IN_MEMORY);
    private final ShortenerAlgorithm algorithm = ShortenerFactory.getInstance().getAlgorithm(Algorithm.UUID);
    private final ShortenerService service = new ShortenerService(storage, algorithm);

    @Test
    public void putAndGet() {
        String url = "https://www.revolut.com/rewards-personalised-cashback-and-discounts/";
        String shortUrl = service.put(url);

        assertNotNull(shortUrl);
        assertTrue(service.get(shortUrl).isPresent());
        assertEquals(url, service.get(shortUrl).get());
    }

    @Test
    public void checkNull() {
        EmptyUrlException exception = assertThrows(EmptyUrlException.class, () -> service.put(null));
        assertNotNull(exception);
    }
}