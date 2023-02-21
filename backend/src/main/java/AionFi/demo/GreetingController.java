package AionFi.demo;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import io.ipinfo.api.*;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.ASNResponse;
import io.ipinfo.api.model.IPResponse;
import java.util.Map;

//enable CORS
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class GreetingController {

    // public final class ReturningValues {
    //     private IPResponse IP;
    //     private ASNResponse ASN;

    //     public ReturningValues(IPResponse IP, ASNResponse ASN) {
    //         this.IP = IP;
    //         this.ASN = ASN;
    //     }

    //     public IPResponse getIP() {
    //         return IP;
    //     }

    //     public void setIP(IPResponse IP) {
    //         this.IP = IP;
    //     }

    //     public ASNResponse getASN() {
    //         return ASN;
    //     }

    //     public void setASN(ASNResponse ASN) {
    //         this.ASN = ASN;
    //     }

    // }

    @PostMapping("/getLocationInfo")
    public IPResponse index(@RequestHeader Map<String, String> authorizationHeader, @RequestBody String body) {

        IPInfo ipInfo = new IPInfoBuilder().setToken("28dbfb85263943").build();
        String API_Key = "";
        if (authorizationHeader.containsKey("apikey")) {
            API_Key = authorizationHeader.get("apikey");
        }
        System.out.println(body);
        String[] sp = body.split("=");
        String iP = sp[1];
        // Boolean ASN = false;
        // Boolean Reg = false;
        // Boolean Web = false;
        // if (iP.contains(".")) {
        //     ASN = false;
        //     Reg = true;
        // } else {
        //     ASN = true;
        //     Reg = false;
        // }
        // ReturningValues response = new ReturningValues(null, null);
        // response.setIP(ipInfo.lookupIP(iP));
        // if (ASN) {
        //     response.setASN(ipInfo.lookupASN(iP));
        //     System.out.println("IP: " + response.ASN);
        //     return response;
        // } else if (Reg) {
        //     response.setIP(ipInfo.lookupIP(iP));
        //     System.out.println("IP: " + response.IP);
        //     System.out.println("IP: " + iP);
        //     return response;
        // }
        
        // create object APIKEY


        if (API_Key.equals("5cc940b5-fa40-4f37-9853-663377f58c51")) {
            try {
                IPResponse response = ipInfo.lookupIP(iP);
                return response;
            } catch (RateLimitedException e) {
                throw new RuntimeException("Rate limited");
            }
        } else {
            throw new RuntimeException("Invalid APIKEY");
        }
    }


}