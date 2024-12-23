package com.pxp.SQLite.demo.service;

import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PaymentService {
    public PaymentIntent createPaymentIntent(long amout) throws  Exception{
        PaymentIntentCreateParams params =
            PaymentIntentCreateParams.builder()
                    .setAmount(amout)
                    .setCurrency("usd")
                    .addPaymentMethodType(Arrays.asList("card").toString())
                    .build();
        return PaymentIntent.create(params);
    };
}
