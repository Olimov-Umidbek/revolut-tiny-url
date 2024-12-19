package uz.umidbek.service.shortener;

import uz.umidbek.enums.Algorithm;
import uz.umidbek.exceptions.UnknownAlgorithmException;
import uz.umidbek.service.shortener.impl.UUIDShortener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ShortenerFactory {
    private static ShortenerFactory INSTANCE;
    private final Map<Algorithm, ShortenerAlgorithm> map = new ConcurrentHashMap<>();
    private ShortenerFactory() {
        map.put(Algorithm.UUID, new UUIDShortener());
    }

    public static synchronized ShortenerFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ShortenerFactory();
        }
        return INSTANCE;
    }

    public ShortenerAlgorithm getAlgorithm(Algorithm algorithm) {
        if (!map.containsKey(algorithm)) {
            throw new UnknownAlgorithmException("Implementation not found for algoritm = " + algorithm);
        }
        return map.get(algorithm);
    }
}
