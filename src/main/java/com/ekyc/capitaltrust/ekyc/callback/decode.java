package com.ekyc.capitaltrust.ekyc.callback;

import org.json.JSONObject;

import java.util.Base64;

public class decode {
    public decode() {
    }

    public static String decode(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

    public static CallbackPayload parsePayload(String payload) {
        CallbackPayload callbackPayload = new CallbackPayload();
        new JSONObject(payload);
        callbackPayload.setResponse(payload);
        return callbackPayload;
    }

    public static String handleCallback(CallbackPayload callbackPayload) {
        String response = callbackPayload.getResponse();
        String decodedResponse = decode(response);
        return decodedResponse;
    }
}
