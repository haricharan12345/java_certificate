package com.casestudy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Certificate {

	@Id
	private String cerName;
	private int criticality;
	private long validity;
	private long cost;
	private String vendor;
	private int score;




}
