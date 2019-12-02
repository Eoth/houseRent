package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import estateProduct.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);
	
	@Query("SELECT u FROM User u WHERE u.userId=?1")
	public User findById(int id);
}
