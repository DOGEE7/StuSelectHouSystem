package cn.edu.hqu.javaee.StuSelectHouseSystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="student")
public class Student implements Serializable{
	private static final long serialVersionUID=1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long stuId;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="stuName")
	private String stuName;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="stuAddress")
	private String stuAddress;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="stuPhoneNumber")
	private Long stuPhoneNumber;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="birthDate")
	private Date birthDate;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="gender")
	private String gender;
	
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
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"stuName");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "stuName");
	}
	
}
