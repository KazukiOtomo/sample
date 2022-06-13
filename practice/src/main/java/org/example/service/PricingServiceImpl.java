package org.example.service;

import org.example.domain.pricing.Master;
import org.example.domain.pricing.Merchandise;
import org.example.domain.pricing.Price;

public class PricingServiceImpl implements PricingService {

    @Override
    public Merchandise decidePrice(Price price) {
        var master = new Master();
        return master.pricing(price);
    }
}
