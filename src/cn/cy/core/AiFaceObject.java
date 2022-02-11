package cn.cy.core;

import com.baidu.aip.face.AipFace;

public class AiFaceObject {
	    public String APP_ID = "23957177";
	    public String API_KEY = "eSAr3gUWHf77KB64b8nZSBeO";
	    public String SECRET_KEY = "5Ya4uq94m3kzcZPlHf1uLYyZPn7IwYGd";
	    public String GROUD_LIST = "1234";
	    
	    private AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

	    public AipFace getClient(){
	    	client.setConnectionTimeoutInMillis(2000);
	    	client.setSocketTimeoutInMillis(60000);
	    	return client;
	    }
	    
}
