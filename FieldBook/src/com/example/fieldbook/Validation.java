package com.example.fieldbook;
/*
 * CLASS VALIDATION 
 */
public class Validation {
	
	private String ValidationID;
	private String ValidationDescription;
    private String ValidationType;
    private String Values;
	private int SeqID;
		 
	//constructors
	public Validation(){}
		 
	public Validation(String ValidationID, String ValidationDescription, String ValidationType, String Values, int SeqID) {
		super();
		this.ValidationID = ValidationID;
        this.ValidationDescription = ValidationDescription;
        this.ValidationType = ValidationType;
        this.Values = Values;
        this.SeqID = SeqID;
    }
		 
		//getters & setters
		public String getValidationID() {
			return ValidationID;
		}
		
		public void setValidationID(String ValidationID) {
			this.ValidationID = ValidationID;
		}
			      
		public String getValidationDescription() {
			return ValidationDescription;
		}
		
		public void setValidationDescription(String ValidationDescription) {
			this.ValidationDescription = ValidationDescription;
		}
			      
		public String getValidationType() {
			return ValidationType;
		}
		
		public void setValidationType(String ValidationType) {
			this.ValidationType = ValidationType;
		}
			      
		public String getValues() {
			return Values;
		}
		
		public void setValues(String Values) {
			this.Values= Values;
		}
			      
		public int getSeqID() {
			return SeqID;
		}
		
		public void setSeqID(int SeqID) {
			this.SeqID = SeqID;
		}
			 
		@Override
		public String toString() {
			return "Validation [ValidationID = " + ValidationID + ", ValidationDescription = " + ValidationDescription + ", ValidationType = " + ValidationType + 
							", Values = " + Values + ", SeqID = " + SeqID + " ]";
		}
}
		
// END OF CLASS VALIDATION