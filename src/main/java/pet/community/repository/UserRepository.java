package pet.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.community.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}


