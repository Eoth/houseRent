package Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Repository.UserRepository;
import estateProduct.User;

@Service
public class UserService implements UserServiceInterface, UserDetailsService  {

	@Autowired  private UserRepository userRepository;
	
	@Override
	public List<User> findAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
        return users;
	}

	@Override
	public User findByUserId(int id) {
		User user = userRepository.findById(id);
		return user;
	}
	
	public Optional<User> findByUserUsername(String username) {
		Optional<User> user = userRepository.findUserWithName(username);
		return user;
	}

	@Override
	public void deleteByUserId(int id) {
//		userRepository.deleteById(id);

	}
	public void updateUser(User user) {
//		userRepository.merge(user);

	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Objects.requireNonNull(username);
//        User user = userRepository.findUserWithName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        org.springframework.security.core.userdetails.User vraiUser = new org.springframework.security.core.userdetails.User (user.getUsername(),
//        		user.getPassword(),true,true,true,true,user.getAuthorities());
//        if(vraiUser != null) {
//        	System.out.println(vraiUser.getPassword());
//        }
//        return vraiUser;
//        
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
        
	}

}
