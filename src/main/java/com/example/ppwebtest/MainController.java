package com.example.ppwebtest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class MainController {
    @RequestMapping("pptest")
    public String test1() {
        log.info("pptest " + LocalDateTime.now());
        return "ok";
    }

    @RequestMapping("**")
    public String test(@RequestBody String body) {
        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        log.info("received request:" + body);

        // GET HEX
        JsonObject data = jsonObject
                .getAsJsonObject("service")
                .getAsJsonObject("data").getAsJsonObject();

        if (data.get("rawData") != null) {
            byte[] hexStringByte = Base64.decode(
                    data.get("rawData")
                            .getAsString());
            String hexString = HexBin.encode(hexStringByte);
            log.info("hex:" + hexString);
        }

        return "ok";
    }
}
