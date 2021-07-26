package com.cognizant.pms.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_data")
public class UserData {
	@Id
	@Column
	private String userid;

	@Column
	private String upassword;

	@Column
	private String uname;

	@Column
	private String authtoken;

}
