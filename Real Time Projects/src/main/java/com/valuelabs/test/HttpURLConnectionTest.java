/**
 * 
 */
package com.valuelabs.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;

/**
 * @author vawasthi
 * 
 */
public class HttpURLConnectionTest {
	private final String USER_AGENT = "Mozilla/5.0";
	private String urlToHit = "http://www.wyndhamap.com/wps/wcm/connect/privileges/home/about/rules";
	private String urlPost = "http://localhost:8090/wyndham/signIn";

	// HTTP GET request
	public void sendGet() {
		try {
			URL obj = new URL(urlToHit);
			HttpURLConnection httpURLConnection = (HttpURLConnection) obj
					.openConnection();
			// optional default is GET
			httpURLConnection.setRequestMethod("GET");
			// add request header
			httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = httpURLConnection.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			String html = response.toString();
			html = html.replace("/wps/wcm/connect", "http://www.wyndhamap.com/wps/wcm/connect");
			System.out.println(""+html);
		} catch (MalformedInputException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// HTTP POST request
	private void sendPost() {
		try {
			URL obj = new URL(urlPost);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) obj
					.openConnection();
			// add reuqest header
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
			httpsURLConnection.setRequestProperty("Accept-Language",
					"en-US,en;q=0.5");
			// String urlParameters =
			// "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
			// Send post request
			httpsURLConnection.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream(
					httpsURLConnection.getOutputStream());
			// dataOutputStream.writeBytes(urlParameters);
			dataOutputStream.flush();
			dataOutputStream.close();
			int responseCode = httpsURLConnection.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : "
					+ httpsURLConnection);
			// System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpsURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// HTTP POST request
		private void sendPostPhpDestination(String url) {
			try {
				URL obj = new URL(url);
				HttpURLConnection httpsURLConnection = (HttpURLConnection) obj
						.openConnection();
				// add reuqest header
				httpsURLConnection.setRequestMethod("POST");
				httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
				httpsURLConnection.setRequestProperty("Accept-Language",
						"en-US,en;q=0.5");
				// String urlParameters =
				// "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
				// Send post request
				httpsURLConnection.setDoOutput(true);
				DataOutputStream dataOutputStream = new DataOutputStream(
						httpsURLConnection.getOutputStream());
				// dataOutputStream.writeBytes(urlParameters);
				dataOutputStream.flush();
				dataOutputStream.close();
				int responseCode = httpsURLConnection.getResponseCode();
				System.out.println("\nSending 'POST' request to URL : "
						+ httpsURLConnection);
				// System.out.println("Post parameters : " + urlParameters);
				System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						httpsURLConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print result
				//http://xml1.rcipacific.com.au/
				
				//System.out.println("HTML Response :    "+response.toString().replace("/css/", "http://xml1.rcipacific.com.au/css/").replace("/js/ ", "http://xml1.rcipacific.com.au/js/"));
				String html=     response.toString().replace("/css/", "http://xml1.rcipacific.com.au/css/").toString();
				
				html = html.replace("/js/", "http://xml1.rcipacific.com.au/js/");
				System.out.println("response DAta   :"+html);
				
				//System.out.println(response.toString().replace("", ""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	/**
	 * Downloads a file from a URL
	 * 
	 * @param fileURL
	 *            HTTP URL of the file to be downloaded
	 * @param saveDir
	 *            path of the directory to save the file
	 * @throws IOException
	 */
	public static String downloadFile(String fileURL, String saveDir)
			throws IOException {
		URL url = new URL(fileURL);
		StringBuffer response = new StringBuffer();
		InputStream inputStream = null;
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();
		// always check HTTP response code first
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = "";
			String disposition = httpConn.getHeaderField("Content-Disposition");
			String contentType = httpConn.getContentType();
			int contentLength = httpConn.getContentLength();
			if (disposition != null) {
				// extracts file name from header field
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10,
							disposition.length() - 1);
				}
			} else {
				// extracts file name from URL
				fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
						fileURL.length());
				System.out.println("fileName    " + fileName);
			}
			System.out.println("Content-Type = " + contentType);
			System.out.println("Content-Disposition = " + disposition);
			System.out.println("Content-Length = " + contentLength);
			System.out.println("fileName = " + fileName);
			// opens input stream from the HTTP connection
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String html = response.toString();
			html = html.replace("/wps/wcm/connect", "http://www.wyndhamap.com/wps/wcm/connect");
			System.out.println(""+html);
			System.out.println("File downloaded");
		} else {
			System.out
					.println("No file to download. Server replied HTTP code: "
							+ responseCode);
		}
		httpConn.disconnect();

		return response.toString();
	}
	
	
	public String wcmPhpCodeReader(){
		System.out.println( " wcmPhpCodeReader -   Start");
		try{
		 URL oracle = new URL("https://www.privilegesbywyndham.com.au/holidayextras.php");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println("  data       "+inputLine.toString());
	        in.close();
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		System.out.println( " wcmPhpCodeReader -   end");
	    return null;
	}

	public static void main(String[] args) {
		HttpURLConnectionTest httpURLConnectionTest = new HttpURLConnectionTest();
		//String urlToHit = "http://www.wyndhamap.com/wps/wcm/connect/privileges/home/about/rules";
		String urlToHit=	"http://xml1.rcipacific.com.au/RentalWeeksPointsWYN.aspx?id=ATWI-WVRAP-PROD";
		//httpURLConnectionTest.sendGet();
		 //httpURLConnectionTest.sendPost();
		/*try {
			downloadFile(
					"http://www.wyndhamap.com/wps/wcm/connect/privileges/home/about/rules",
					"C://users/vawasthi/Desktop");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//httpURLConnectionTest.wcmPhpCodeReader();
		httpURLConnectionTest.sendPostPhpDestination("http://xml1.rcipacific.com.au/RentalWeeksPointsWYN.aspx?id=ATWI-WVRAP-PROD");
	}

}
