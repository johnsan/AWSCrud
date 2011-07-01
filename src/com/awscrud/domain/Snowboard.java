
package com.awscrud.domain;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Snowboard {
    @Id
    private String id;

    private String brand;

    private String model;
    
    private Short length;

    private String genre;

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Short getLength() {
		return length;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

}
