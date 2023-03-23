package sn.handler.malcolm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.handler.malcolm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
