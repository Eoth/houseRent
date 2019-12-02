package estateProduct;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resId;
	
	@OneToOne(mappedBy = "res", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Product realEstate;
	 
    @ManyToMany(mappedBy = "userRes",cascade = CascadeType.ALL)
	private List<User> requester;

	public Reservation() {}
	public Reservation(int resId, Product realEstate, List<User> requester) {
		super();
		this.resId = resId;
		this.realEstate = realEstate;
		this.requester = requester;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public Product getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(Product realEstate) {
		this.realEstate = realEstate;
	}

	public List<User> getRequester() {
		return requester;
	}

	public void setRequester(List<User> requester) {
		this.requester = requester;
	}

	@Override
	public String toString() {
		return "Reservation [resId=" + resId + ", realEstate=" + realEstate + ", requester=" + requester + "]";
	}
	 
	 
	 

}
