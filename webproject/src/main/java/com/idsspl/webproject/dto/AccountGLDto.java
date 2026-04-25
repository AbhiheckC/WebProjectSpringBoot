package com.idsspl.webproject.dto;

public class AccountGLDto {

	 private String accountCode;
	    private String glName;

	    public AccountGLDto(String accountCode, String glName) {
	        this.accountCode = accountCode;
	        this.glName = glName;
	    }

		public String getAccountCode() {
			return accountCode;
		}

		public String getGlName() {
			return glName;
		}

		public void setAccountCode(String accountCode) {
			this.accountCode = accountCode;
		}

		public void setGlName(String glName) {
			this.glName = glName;
		}
	
	    
	    
}
