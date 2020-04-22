package guru.springframework.spring5webapp.repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.spring5webapp.model.Publisher;

@Repository
public interface PublishRepo extends CrudRepository<Publisher, Long> {

}
