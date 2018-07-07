package cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterForm {
	@Getter
	@Setter
	@NotEmpty(message="{stuName.valid}")
	@Size(min=4,max=30,message="{stuName.size}")
	private String stuName;
	
	@Getter
	@Setter
	@NotEmpty(message="{stuAddress.valid}")
	@Size(min=16,max=40,message="{stuAddress.size}")
	private String stuAddress;
	
	@Getter
	@Setter
	@NotEmpty(message="{stuPhoneNumber.size}")
	@Size(min=13,max=13, message="{stuPhoneNumber.size}")
	private Long stuPhoneNumber;
	
	@Getter
	@Setter
	@Past(message="{birthDate.valid}")
	private Date birthDate;
	
	@Getter
	@Setter
	@NotEmpty(message="{gender.valid}")
	@Size(min=2,max=4,message="{gender.size}")
	private String gender;
	
	@Getter
	@Setter
	@NotEmpty(message="{password.valid}")
	@Size(min=4,max=25,message="{password.size}")
	private String password;
	
	@Getter
	@Setter
	private MultipartFile picFile;
	
	
	

}
