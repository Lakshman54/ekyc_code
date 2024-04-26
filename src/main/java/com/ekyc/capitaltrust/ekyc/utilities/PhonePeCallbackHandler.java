package com.ekyc.capitaltrust.ekyc.utilities;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class PhonePeCallbackHandler extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String callbackResponse = req.getParameter("response");
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(callbackResponse);
        String decodedString = new String(decodedBytes, "UTF-8");
        JSONObject jsonObject = new JSONObject(decodedString);

        // Process the callback response
        String success = jsonObject.getString("success");
        String code = jsonObject.getString("code");
        String message = jsonObject.getString("message");
        JSONObject data = jsonObject.getJSONObject("data");

        // Handle the callback response based on the success status
        if (success.equals("true")) {
            // Process successful transaction
            String merchantId = data.getString("merchantId");
            String merchantTransactionId = data.getString("merchantTransactionId");
            String transactionId = data.getString("transactionId");
            int amount = data.getInt("amount");
            String state = data.getString("state");
            String responseCode = data.getString("responseCode");
            JSONObject paymentInstrument = data.getJSONObject("paymentInstrument");

            // Handle payment instrument based on type
            String type = paymentInstrument.getString("type");
            if (type.equals("UPI")) {
                String utr = paymentInstrument.getString("utr");
                // Handle UPI payment instrument
            } else if (type.equals("CARD")) {
                String cardType = paymentInstrument.getString("cardType");
                String pgTransactionId = paymentInstrument.getString("pgTransactionId");
                String bankTransactionId = paymentInstrument.getString("bankTransactionId");
                String pgAuthorizationCode = paymentInstrument.getString("pgAuthorizationCode");
                String arn = paymentInstrument.getString("arn");
                String bankId = paymentInstrument.getString("bankId");
                // Handle CARD payment instrument
            } else if (type.equals("NETBANKING")) {
                String pgTransactionId = paymentInstrument.getString("pgTransactionId");
                String pgServiceTransactionId = paymentInstrument.getString("pgServiceTransactionId");
                String bankTransactionId = paymentInstrument.getString("bankTransactionId");
                String bankId = paymentInstrument.getString("bankId");
                // Handle NETBANKING payment instrument
            }
        } else {
            // Handle failed transaction
            String errorCode = jsonObject.getString("code");
            String errorMessage = jsonObject.getString("message");
            // Handle error response
        }
    }



}