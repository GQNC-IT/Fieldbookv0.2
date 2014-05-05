package com.example.fieldbook;

public class Data {
	
	private String DataID;
    private String PropertyMethodAssnID;
    private String Value;
    private String UserIDNo;
    private String DateTime;
    private String DeviceID;
    private String Longitude;
    private String Latitude;
    private String Active;
    private String Blocked;
    private int SeqID;
    
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	public Data(String DataID, String PropertyMethodAssnID, String Value, String UserIDNo, String DateTime, 
			String DeviceID, String Longitude, String Latitude, String Active, String Blocked, int SeqID) {
    super();
    this.DataID = DataID;
    this.PropertyMethodAssnID = PropertyMethodAssnID;
    this.Value = Value;
    this.UserIDNo = UserIDNo;
    this.DateTime = DateTime;
    this.DeviceID = DeviceID;
    this.Longitude = Longitude;
    this.Latitude = Latitude;  
    this.Active = Active;
    this.Blocked = Blocked;
    this.SeqID = SeqID;
}

	//getters & setters
	public String getDataID() {
		return DataID;
	}

	public void setDataID(String DataID) {
		this.DataID = DataID;
	}

	public String getPropertyMethodAssnID() {
		return PropertyMethodAssnID;
	}

	public void setPropertyMethodAssnID(String PropertyMethodAssnID) {
		this.PropertyMethodAssnID = PropertyMethodAssnID;
	}
      
	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}
      
	public String getUserIDNo() {
		return UserIDNo;
	}

	public void setUserIDNo(String UserIDNo) {
		this.UserIDNo = UserIDNo;
	}
      
	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String DateTime) {
		this.DateTime = DateTime;
	}
        
	public String getDeviceID(){
		return DeviceID;
	}

	public void setDeviceID(String DeviceID) {
		this.DeviceID = DeviceID;
	}
      
	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String Longitude) {
		this.Longitude = Longitude;
	}
      
	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String Latitude) {
		this.Latitude = Latitude;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String Active) {
		this.Active = Active;
	}
      
	public String getBlocked() {
		return Blocked;
	}

	public void setBlocked(String Blocked) {
		this.Blocked = Blocked;
	}

	public int getSeqID() {
		return SeqID;
	}

	public void setSeqID(int SeqID) {
		this.SeqID = SeqID;
	}
 
    @Override
    public String toString() {
        return "Data [DataID = " + DataID + ", PropertyMethodAssnID = " + PropertyMethodAssnID + ", Value = " + Value + ", UserIDNo = " + UserIDNo + ", DateTime = " + DateTime + ", DeviceID = " + DeviceID + 
        		", Longitude = " + Longitude + ", Latitude = " + Latitude + ", Active = " + Active + ", Blocked = " + Blocked + ", SeqID = " + SeqID + " ]";
    }
}

// END OF CLASS DATA
