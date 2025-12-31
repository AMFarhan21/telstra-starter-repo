package au.com.telstra.simcardactivator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.DTO.SimCardRequest;
import au.com.telstra.simcardactivator.model.SimCard;
import au.com.telstra.simcardactivator.services.SimCardServices;

@RestController
public class SimCardController {

    private final SimCardActuationHandler simCardActuationHandler;
    private final SimCardServices simCardServices;

    public SimCardController(SimCardActuationHandler simCardActuationHandler, SimCardServices simCardServices) {
        this.simCardActuationHandler = simCardActuationHandler;
        this.simCardServices = simCardServices;
    }

    @PostMapping("/activate")
    public void addSimcard(@RequestBody SimCardRequest request) {
        SimCard simCard = new SimCard(
                request.getIccid(),
                request.getCustomerEmail(),
                request.getActive());

        var actuationResult = simCardActuationHandler.actuate(simCard);
        System.out.println(actuationResult.getSuccess());
        simCardServices.activateSimCard(simCard, actuationResult.getSuccess());
    }

    @GetMapping("/query")
    public SimCard getSimCard(@RequestParam("simCardId") Long id) {
        return simCardServices.getById(id);
    }
}