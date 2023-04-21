package shreshtha.inc.uksmg.data.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import shreshtha.inc.uksmg.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);
}
