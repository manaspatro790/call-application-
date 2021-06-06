package com.oggy.springbootvoicecall;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api/v1")
public class PhoneController {

	public static final String ACCOUNT_SID = "enter your auth_sid";
	  public static final String AUTH_TOKEN = "enter your auth_token";
	  public static final String FROM_NUMBER="your twilio number";
	  public static final String TO_NUMBER="your verified phno";
	  static {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	  }
	  @GetMapping("/voicecall")
	  public String makecall() throws URISyntaxException{
		  Call call = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
			        new URI("http://demo.twilio.com/docs/voice.xml")).create();
		  System.out.println(call.getSid());
		  return "success";
	}
	
	// to make a call -http://localhost:8080/api/v1/voicecall
	@GetMapping("/sms")
	  public String sms() throws URISyntaxException {
		  Message message = Message.creator(new PhoneNumber(TO_NUMBER),
			        new PhoneNumber(FROM_NUMBER), 
			        "google.com").create();

			    System.out.println(message.getSid());
			    return "sent";
	  }
	
	// to make a sms -http://localhost:8080/api/v1/sms
}
