package com.example.fieldbook;
/*
 * CLASS ORGUNIT 
 */
public class OrgUnit{
	
	private String OrgUnitID;
	private String OrgUnitDescription;
	private String OrgUnitAbbr;
	private int SeqID;
		 
	//constructors
	public OrgUnit(){}
		 
	public OrgUnit(String OrgUnitID, String OrgUnitDescription, String OrgUnitAbbr, int SeqID) {
		super();
		this.OrgUnitID = OrgUnitID;
		this.OrgUnitDescription = OrgUnitDescription;
		this.OrgUnitAbbr = OrgUnitAbbr;
		this.SeqID = SeqID;
	}	 
		//getters & setters
		public String getOrgUnitID() {
			return OrgUnitID;
		}
		
		public void setOrgUnitID(String OrgUnitID) {
			this.OrgUnitID = OrgUnitID;
		}
		
		public String getOrgUnitDescription() {
			return OrgUnitDescription;
		}
		
		public void setOrgUnitDescription(String OrgUnitDescription) {
			this.OrgUnitDescription = OrgUnitDescription;
		}
		
		public String getOrgUnitAbbr() {
			return OrgUnitAbbr;
		}
		
		public void setOrgUnitAbbr(String OrgUnitAbbr) {
			this.OrgUnitAbbr = OrgUnitAbbr;
		}
		
		public int getSeqID() {
			return SeqID;
		}
		
		public void setSeqID(int SeqID) {
			this.SeqID = SeqID;
		}
			 
		@Override
		public String toString() {
			return "OrgUnit [OrgUnitID = " + OrgUnitID + ", OrgUnitDescription = " + OrgUnitDescription + 
					", OrgUnitAbbr = " + OrgUnitAbbr + ", SeqID = " + SeqID + " ]";
		}
}

// END OF CLASS OrgUnit
