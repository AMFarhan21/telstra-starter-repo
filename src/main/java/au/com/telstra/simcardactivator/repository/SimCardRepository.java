package au.com.telstra.simcardactivator.repository;

import org.springframework.data.repository.CrudRepository;

import au.com.telstra.simcardactivator.model.SimCard;

public interface SimCardRepository extends CrudRepository<SimCard, Long> {

}
