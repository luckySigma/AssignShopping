package net.asd.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	// private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String code;
	@NotBlank(message = "Please Enter Product Name")
	private String name;
	@NotBlank(message = "Please Enter Brand Name")
	private String brand;
	@NotBlank(message = "Please Enter Email")
	private String email;
	@NotBlank(message = "Please Enter Supplier Name")
	private String supplier;
	@Column(name = "unit_price")
	@Min(value = 1, message = "The price cannot be less than 1")

	private double unitPrice;
	private int quantity;
	@Column(name = "is_active")
	@JsonIgnore
	private boolean active;

	//default constructor
	public Orders() {

		this.code = "ORD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", email=" + email
				+ ", supplier=" + supplier + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active="
				+ active + "]";
	}

	// getters and setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
