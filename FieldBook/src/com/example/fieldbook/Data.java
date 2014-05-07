package com.example.fieldbook;

public class Data {
	
	private static String DataID; //PK string
    private static String PropertyMethodAssnID;//int muna
    private static String Value;//fromuserinpu
    private static String UserIDNo;//a
    private static String DateTime;//kuin
    private static String DeviceID;//wagmuna
    private static String Longitude;//rand
    private static String Latitude;//rand
    private static String Active;//1
    private static String Blocked;//0
    private static int SeqID; //autoinc
    
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	public Data(String DataID2, String PropertyMethodAssnID2, String Value2, String UserIDNo2,  
			String DeviceID2, String Longitude2, String Latitude2, String Active2, String Blocked2, int SeqID2) {
    super();
    DataID = DataID2;
    PropertyMethodAssnID = PropertyMethodAssnID2;
    Value = Value2;
    UserIDNo = UserIDNo2;
    DeviceID = DeviceID2;
    Longitude = Longitude2;
    Latitude = Latitude2;  
    Active = Active2;
    Blocked = Blocked2;
    SeqID = SeqID2;
}

	//getters & setters
	public static String getDataID() {
		return DataID;
	}

	public void setDataID(String DataID2) {
		DataID = DataID2;
	}

	public static String getPropertyMethodAssnID() {
		return PropertyMethodAssnID;
	}

	public void setPropertyMethodAssnID(String PropertyMethodAssnID2) {
		PropertyMethodAssnID = PropertyMethodAssnID2;
	}
      
	public static String getValue() {
		return Value;
	}

	public void setValue(String Value2) {
		Value = Value2;
	}
      
	public static String getUserIDNo() {
		return UserIDNo;
	}

	public void setUserIDNo(String UserIDNo2) {
		UserIDNo = UserIDNo2;
	}
      
	public static String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String DateTime2) {
		DateTime = DateTime2;
	}
        
	public static String getDeviceID(){
		return DeviceID;
	}

	public void setDeviceID(String DeviceID2) {
		DeviceID = DeviceID2;
	}
      
	public static String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String Longitude2) {
		Longitude = Longitude2;
	}
      
	public static String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String Latitude2) {
		Latitude = Latitude2;
	}

	public static String getActive() {
		return Active;
	}

	public void setActive(String Active2) {
		Active = Active2;
	}
      
	public static String getBlocked() {
		return Blocked;
	}

	public void setBlocked(String Blocked2) {
		Blocked = Blocked2;
	}

	public static int getSeqID() {
		return SeqID;
	}

	public void setSeqID(int SeqID2) {
		SeqID = SeqID2;
	}
 
    @Override
    public String toString() {
        return "Data [DataID = " + DataID + ", PropertyMethodAssnID = " + PropertyMethodAssnID + ", Value = " + Value + ", UserIDNo = " + UserIDNo + ", DateTime = " + DateTime + ", DeviceID = " + DeviceID + 
        		", Longitude = " + Longitude + ", Latitude = " + Latitude + ", Active = " + Active + ", Blocked = " + Blocked + ", SeqID = " + SeqID + " ]";
    }
}

// END OF CLASS DATA
