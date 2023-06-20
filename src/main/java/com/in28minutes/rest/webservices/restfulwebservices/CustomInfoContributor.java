package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String,Object> detailsMap = new HashMap<String,Object>();
        detailsMap.put("custom-info", "This is a custom info");
        detailsMap.put("developer-name","Abhishek Singh");
        detailsMap.put("application-name","restful-web-services");

        builder.withDetails(detailsMap);
    }
}
