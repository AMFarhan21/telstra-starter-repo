package au.com.telstra.simcardactivator.services;

import org.springframework.stereotype.Service;

import au.com.telstra.simcardactivator.model.SimCard;
import au.com.telstra.simcardactivator.repository.SimCardRepository;

@Service
public class SimCardServices {
    private final SimCardRepository repository;

    public SimCardServices(SimCardRepository repository) {
        this.repository = repository;
    }

    public SimCard activateSimCard(SimCard simCard, boolean active) {
        SimCard record = new SimCard(simCard.getIccid(), simCard.getCustomerEmail(), active);

        return repository.save(record);
    }

    public SimCard getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Sim Card not found"));
    }
}
