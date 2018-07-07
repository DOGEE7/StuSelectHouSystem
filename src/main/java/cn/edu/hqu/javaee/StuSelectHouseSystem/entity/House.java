package cn.edu.hqu.javaee.StuSelectHouseSystem.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="house")
public class House implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long houId;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="houAdress")
	private String houAddress;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="type")
	private String type;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="population")
	private int population;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="rentPrice")
	private int rentPrice;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="rentOrNot")
	private Boolean rentOrNot;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="rentOrNot")
	private String reason;

	@Getter
	@Setter
	private int updateCost=(new Random()).nextInt(50);
	
	@Getter
	@Setter
	@OneToOne(mappedBy="landlord")
	@JoinColumn(name="id",nullable=false)
	private Landlord landlord;
	
	@Getter
	@Setter
	@Column(name="postedTime")
	@Temporal(value=TemporalType.DATE)
	@NotEmpty
	private Date postedTime;
	
	

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id","landlord");
		
	}
	
	@Override 
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","landlord");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
