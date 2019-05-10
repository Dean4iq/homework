package ua.den.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.den.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);
    User findByEmail(String email);
}
