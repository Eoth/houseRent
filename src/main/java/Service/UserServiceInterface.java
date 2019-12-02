package Service;

import java.util.List;

import estateProduct.User;

public interface UserServiceInterface {
	
	public List<User> findAllUser();
	public User findByUserId(int id);
	public void deleteByUserId(int id);
	public void saveUser(User product);

}
