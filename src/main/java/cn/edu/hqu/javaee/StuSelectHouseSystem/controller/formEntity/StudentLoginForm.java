package cn.edu.hqu.javaee.StuSelectHouseSystem.controller.formEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StudentLoginForm {
	@Getter
	@Setter
	String stuName;
	@Getter
	@Setter
	String password;
	
}
