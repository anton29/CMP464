package com.example.flickrmap;

/*
 Example code based on code from Nicholas Smith at http://imnes.blogspot.com/2011/01/how-to-use-yelp-v2-from-java-including.html
 For a more complete example (how to integrate with GSON, etc) see the blog post above.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.google.android.gms.maps.model.LatLng;

/**
 * Example for accessing the Yelp API.
 */
public class YelpParser {

  OAuthService service;
  Token accessToken;

  /**
   * Setup the Yelp API OAuth credentials.
   *
   * OAuth credentials are available from the developer site, under Manage API access (version 2 API).
   *
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public YelpParser(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /**
   * Search with term and location.
   *
   * @param term Search term
   * @param latitude Latitude
   * @param longitude Longitude
   * @return JSON string response
   */
  public String search(String term, double latitude, double longitude) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search?term=pizza&bounds=40.855971,-73.867611|40.9,-73.9&limit=5");
    request.addQuerystringParameter("pizza", term);
    request.addQuerystringParameter("ll", latitude + "," + longitude);
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }

  // CLI
  public static void main(String[] args) {
    // Update tokens here from Yelp developers site, Manage API access.
    String consumerKey = "L2RiCU8fxpt-tDWhO1XROA";
    String consumerSecret = "u_gg3ddGCDOBr4xXsSDsua-vzyU";
    String token = "D-fM67DSDCb7wORSRV0AYa8xRH0_I3ue";
    String tokenSecret = "hoFW0Fnm6QQgxZbkAM01y1jDn9g";

    YelpParser yelp = new YelpParser(consumerKey, consumerSecret, token, tokenSecret);
    String response = yelp.search("pizza", 40.855971, -73.867611);

    try{
    	JSONObject mainJson = new JSONObject(response);
    	JSONArray businesses = mainJson.getJSONArray("businesses");
    	for (int i = 0; i < businesses.length(); i++) {
    		JSONObject business = businesses.getJSONObject(i);
    		JSONArray address = business.getJSONObject("location").getJSONArray("display_address");
    		String address_string = "";
    		for (int j=0; j < address.length(); j++)
    			address_string = address_string + address.getString(j) + " ";
    	}	
    }
    catch(Exception e){
    	e.printStackTrace();
    }
  }


}

  

