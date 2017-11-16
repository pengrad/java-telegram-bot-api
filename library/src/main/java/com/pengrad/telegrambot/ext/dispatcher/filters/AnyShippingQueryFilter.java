package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.ShippingQueryFilter;
import com.pengrad.telegrambot.model.ShippingQuery;

public class AnyShippingQueryFilter extends ShippingQueryFilter {

    @Override
    public boolean filter(ShippingQuery shippingQuery) {
        return true;
    }
}
