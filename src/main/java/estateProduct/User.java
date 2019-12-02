package estateProduct;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER")
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	String firstName;
	String lastName;
	String username;
	String password;
	String role;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    private List<Product> myProperty;
	
	@OneToMany(mappedBy="renter", cascade=CascadeType.ALL)
    private List<Product> myRentHouse;
	

	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName="resId")
	private Reservation userRes;
	
	public User() {}

	public User(int userId, String firstName, String lastName, String username, String password, String role,
			List<Product> mesMaisons, List<Product> maisonsLoue) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.myProperty = mesMaisons;
		this.myRentHouse = maisonsLoue;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getMyProperty() {
		return myProperty;
	}

	public void setMyProperty(List<Product> mesMaisons) {
		this.myProperty = mesMaisons;
	}

	public List<Product> getMyRentHouse() {
		return myRentHouse;
	}

	public void setMyRentHouse(List<Product> maisonsLoue) {
		this.myRentHouse = maisonsLoue;
	}

	public Reservation getUserRes() {
		return userRes;
	}

	public void setUserRes(Reservation userRes) {
		this.userRes = userRes;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", role=" + role + ", mesMaisons=" + myProperty
				+ ", maisonsLoue=" + myRentHouse + "]";
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Collection<SimpleGrantedAuthority> authorithies = new ArrayList<>();
//		authorithies.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		return authorithies;
//	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
