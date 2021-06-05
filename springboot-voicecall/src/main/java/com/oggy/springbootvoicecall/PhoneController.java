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

	public static final String ACCOUNT_SID = "ACce1173a74cc4a0235b1e167649eb8dd7";
	  public static final String AUTH_TOKEN = "af408d4f8d438ecdf4ee0576df3be7d8";
	  public static final String FROM_NUMBER="+16174207457";
	  public static final String TO_NUMBER="+917008567506";
	  static {
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	  }
	  @GetMapping("/voicecall")
	  public String makecall() throws URISyntaxException{
		  Call call = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
			        new URI("http://demo.twilio.com/docs/voice.xml")).create();
		  System.out.println(call.getSid());
		  return "success";
	}//http://localhost:8080/api/v1/voicecall
}
