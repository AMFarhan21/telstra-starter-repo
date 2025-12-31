package au.com.telstra.simcardactivator.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.model.ActuationResult;
import au.com.telstra.simcardactivator.model.SimCard;

@Controller
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private final @NonNull String incentiveApiUrl;

    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8444/actuate";
    }

    public ActuationResult actuate(SimCard simCard) {
        return restTemplate.postForObject(incentiveApiUrl, simCard, ActuationResult.class);
    }
}
