package top.jhana.repository;


import org.springframework.data.repository.CrudRepository;
import top.jhana.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
