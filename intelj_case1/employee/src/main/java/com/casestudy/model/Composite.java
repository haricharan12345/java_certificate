package com.casestudy.model;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")

public class Composite implements Serializable {
	
	    private int empId;
	    private String certificateName;
	    // Constructors, getters, setters, and equals/hashCode methods...
		
	    public Composite(int empId, String certificateName) {
			super();
			this.empId = empId;
			this.certificateName = certificateName;
		}
	    public Composite() {
			super();
		}
	    
	    public int getEmpId() {
			return empId;
		}
		
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getCertificateName() {
			return certificateName;
		}
		public void setCertificateName(String certificateName) {
			this.certificateName = certificateName;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(certificateName, empId);
		}
		
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Composite other = (Composite) obj;
			return Objects.equals(certificateName, other.certificateName) && empId == other.empId;
		}
		
	}




