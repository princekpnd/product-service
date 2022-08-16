package customer.service.com.Entity;

import java.time.LocalDate;

import javax.persistence.Column;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;

public class ExcelEntity {
	@Column(name = "CODE", nullable = false)
	private String code;
	
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "BATCH", nullable = false)
	private String batch;
	
	@Column(name = "STOCK", nullable = false)
	private int stock;
	
	@Column(name = "DEAL", nullable = false)
	private int deal;
	
	@Column(name = "FREE", nullable = false)
	private int free;
	
	@Column(name = "MRP", nullable = false)
	private int mrp;
	
	@Column(name = "RATE", nullable = false)
	private int rate;
	
	@Column(name = "EXPIRY_DATE", nullable = false)
	private LocalDate expiryDate;
	
	@Column(name = "SUPPLIER", nullable = false)
	private String supplier;
	
	@Column(name = "COMPANY", nullable = false)
	private String company;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the deal
	 */
	public int getDeal() {
		return deal;
	}

	/**
	 * @param deal the deal to set
	 */
	public void setDeal(int deal) {
		this.deal = deal;
	}

	/**
	 * @return the free
	 */
	public int getFree() {
		return free;
	}

	/**
	 * @param free the free to set
	 */
	public void setFree(int free) {
		this.free = free;
	}

	/**
	 * @return the mrp
	 */
	public int getMrp() {
		return mrp;
	}

	/**
	 * @param mrp the mrp to set
	 */
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the expiryDate
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	
	
	
}
