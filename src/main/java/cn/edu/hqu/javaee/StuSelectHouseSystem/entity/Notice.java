package cn.edu.hqu.javaee.StuSelectHouseSystem.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
	@Getter
	@Setter
	private Date time;
	
	@Getter
	@Setter
    private String place;
	
	@Getter
	@Setter
    private String landlordName;
	
	@Getter
	@Setter
    private String studentName;
	
	@Getter
	@Setter
    private String houseId;
	
	@Getter
	@Setter
    private String landlordTel;
	
	@Getter
	@Setter
    private String studentTel;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "time","houseId");
		
	}
	
	@Override 
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "houseId");
	}

	public void setList(List<Notice> allNotice) {
		// TODO Auto-generated method stub
		
	}


}
