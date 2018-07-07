package cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.hqu.javaee.StuSelectHouseSystem.entity.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LandlordRegisterForm {
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=30,message="lanName.size")
	private String lanName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=16,max=40,message="lanAddress,size")
	private String lanAddress;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=13,max=13,message="lanPhoneNumber.size")
	private Long lanPhoneNumber;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="password.size")
	private String password;
	
	@Getter
	@Setter
	@NotEmpty
	private House house;
	
	@Getter
	@Setter
	private MultipartFile picFile;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
