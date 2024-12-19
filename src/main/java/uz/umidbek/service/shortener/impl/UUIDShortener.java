package uz.umidbek.service.shortener.impl;

import uz.umidbek.service.shortener.ShortenerAlgorithm;

import java.util.UUID;

public class UUIDShortener implements ShortenerAlgorithm {
    @Override
    public String compress(String url) {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
