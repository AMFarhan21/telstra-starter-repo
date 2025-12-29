package au.com.telstra.simcardactivator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardController {

    private final RestTemplate restTemplate;

    public SimCardController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/simcard")
    public void addSimcard(@RequestBody SimCard simCard) {
        Map<String, String> payload = new HashMap<>();

        payload.put("iccid", simCard.getIccid());

        ResponseEntity<Actuator> response = restTemplate.postForEntity(
                "http://localhost:8444/actuate", payload, Actuator.class);

        if (response.getBody() != null && response.getBody().isSuccess()) {
            System.out.println("SIM card activation successful for ICCID: " + simCard.getIccid());
        } else {
            System.out.println("SIC card activation failed for ICCID: " + simCard.getIccid());
        }
    }
}