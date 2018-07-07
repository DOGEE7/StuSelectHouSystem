package cn.edu.hqu.javaee.StuSelectHouseSystem.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name="landlord")
public class Landlord implements Serializable{
	private static final long serialVersionUID=1L;
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long lanId;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="lanName")
	private String lanName;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="lanAddress")
	private String lanAddress;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="lanPhoneNumber")
	private Long lanPhoneNumber;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@Getter
	@Setter
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="id",  nullable = false)
	private Notice notice;
	
	@Getter
	@Setter
	@OneToOne()
	@JoinColumn(name="id",nullable=false)
	private House house;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "lanName");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "lanName");
	}
	
	
	
}
