package shreshtha.inc.uksmg.data.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import shreshtha.inc.uksmg.data.entity.SamplePerson;

public interface SamplePersonRepository
        extends
            JpaRepository<SamplePerson, Long>,
            JpaSpecificationExecutor<SamplePerson> {

}
