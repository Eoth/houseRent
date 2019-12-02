package estateProduct;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(nullable = false)
	private String typeProperty;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private String adress;
	
	@Column(nullable = false)
	private  int nbPers;
	
	@Column(nullable = false)
	private boolean available=true;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "userId")
	private User owner; // propriétaire
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "userId")
	private User renter; // locataire
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "resId")
    private Reservation res;
	
	public Product() {}
	
	public Product(int productId, String typeProperty, double price, String adress, int nbPers, boolean available,
			Date beginDate, Date endDate, User owner, User renter) {
		super();
		this.productId = productId;
		this.typeProperty = typeProperty;
		this.price = price;
		this.adress = adress;
		this.nbPers = nbPers;
		this.available = available;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.owner = owner;
		this.renter = renter;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTypeProperty() {
		return typeProperty;
	}

	public void setTypeProperty(String typeProperty) {
		this.typeProperty = typeProperty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNbPers() {
		return nbPers;
	}

	public void setNbPers(int nbPers) {
		this.nbPers = nbPers;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getRenter() {
		return renter;
	}

	public void setRenter(User locataire) {
		this.renter = locataire;
	}

	public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
	}
	
	

}
