/**
 	* CLASS METHOD 
**/
package com.example.fieldbook;

			public class Method{
				
				private String MethodID;
				private String MethodDescription;
				private String Active;
				private int SeqID;
					 
				//constructors
				public Method(){}
					 
				public Method(String MethodID, String MethodDescription, String Active, int SeqID) {
					super();
					this.MethodID = MethodID;
					this.MethodDescription = MethodDescription;
					this.Active = Active;
					this.SeqID = SeqID;
				}	 
					//getters & setters
					public String getMethodID() {
						return MethodID;
					}
					
					public void setMethodID(String MethodID) {
						this.MethodID = MethodID;
					}
					
					public String getMethodDescription() {
						return MethodDescription;
					}
					
					public void setMethodDescription(String MethodDescription) {
						this.MethodDescription = MethodDescription;
					}
					
					public String getActive() {
						return Active;
					}
					
					public void setActive(String Active) {
						this.Active = Active;
					}
					
					public int getSeqID() {
						return SeqID;
					}
					
					public void setSeqID(int SeqID) {
						this.SeqID = SeqID;
					}
						 
					@Override
					public String toString() {
						return "Method [MethodID = " + MethodID + ", MethodDescription= " + MethodDescription + 
								", Active = " + Active + ", SeqID = " + SeqID + " ]";
					}
			}
	
			// END OF CLASS METHOD