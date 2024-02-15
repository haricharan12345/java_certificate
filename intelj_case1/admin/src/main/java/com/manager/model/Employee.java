package com.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@IdClass(Composite.class)
public class Employee {

	@Id
	private int empId;
	private String empName;
	private int managerId;
	private String password;

	@Id
	private String certificateName;

}

