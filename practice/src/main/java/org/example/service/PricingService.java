package org.example.service;

import org.example.domain.pricing.Merchandise;
import org.example.domain.pricing.Price;

public interface PricingService {

    public Merchandise decidePrice(Price price);
}
