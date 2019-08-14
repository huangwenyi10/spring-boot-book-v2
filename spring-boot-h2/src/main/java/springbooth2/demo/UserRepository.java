package springbooth2.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述：UserRepository
 * @author ay
 * @date 2019-03-13
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
