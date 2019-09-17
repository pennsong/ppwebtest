package com.example.ppwebtest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class MainController {
    @RequestMapping("**")
    public String test(@RequestBody String body) throws Base64DecodingException {
        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        System.out.println("received request:" + LocalDateTime.now());
        System.out.println(jsonObject);

        // GET HEX
        byte[] hexStringByte = Base64.decode(jsonObject.get("rawData").getAsString());
        String hexString = HexBin.encode(hexStringByte);
        System.out.println("hex:" + hexString);

        return "ok";
    }
}
