package com.ekyc.capitaltrust.ekyc.controller;


import com.ekyc.capitaltrust.ekyc.model.AppClientDetails;
import com.ekyc.capitaltrust.ekyc.model.CheckStatusAPIParam;
import com.ekyc.capitaltrust.ekyc.model.ChecksumInputParam;
import com.ekyc.capitaltrust.ekyc.model.phonepe;
import com.ekyc.capitaltrust.ekyc.repository.AppClientDetailsRepository;
import com.ekyc.capitaltrust.ekyc.repository.phonepeRepository;
import com.ekyc.capitaltrust.ekyc.utilities.PhonePeCallbackHandler;
import com.phonepe.sdk.pg.Env;
import com.phonepe.sdk.pg.common.http.PhonePeResponse;
import com.phonepe.sdk.pg.payments.v1.PhonePePaymentClient;
import com.phonepe.sdk.pg.payments.v1.models.request.PgPayRequest;
import com.phonepe.sdk.pg.payments.v1.models.response.PayPageInstrumentResponse;
import com.phonepe.sdk.pg.payments.v1.models.response.PgPayResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping({"/phonepe"})
class phonepe_controller {
    @Autowired
    AppClientDetailsRepository appClientDetailsRepository;
    @Autowired
    phonepeRepository phonepeRepository;

    @Autowired
    PhonePeCallbackHandler phonePeCallbackHandler;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Autowired
    private HttpServletResponse httpServletResponse;
    @Qualifier("httpServletRequest")
    @Autowired
    private ServletRequest httpServletRequest;

    phonepe_controller() {
    }

    @GetMapping("/servercallback")
    public void callback() throws IOException {
        System.out.println("Server callback is called");
        phonePeCallbackHandler.doPost((HttpServletRequest) httpServletRequest,httpServletResponse);

    }

    @PostMapping("/checksomevalue")
    public String checkSumValue(@RequestBody ChecksumInputParam checksumInputParam) {
        Optional<AppClientDetails> ap = this.appClientDetailsRepository.findByLoanId(checksumInputParam.getLoanid());
        String transactionId = UUID.randomUUID().toString().substring(0, 34);
        JSONObject paymentRequest = new JSONObject();
        paymentRequest.put("merchantId", "CAPITALTRUSTUAT");
        paymentRequest.put("merchantTransactionId", transactionId);
        int var10002 = checksumInputParam.getLoanid();
        paymentRequest.put("merchantUserId", "" + var10002 + "_" + checksumInputParam.getPaymenttype());
        paymentRequest.put("amount", checksumInputParam.getAmount());
        paymentRequest.put("mobileNumber", ((AppClientDetails)ap.get()).getClientMobileNo());
        paymentRequest.put("callbackUrl", "https://cml.capitaltrust.in:8083/phonepe/servercallback");
        JSONObject paymentInstrument = new JSONObject();
        paymentInstrument.put("type", "UPI_INTENT");
        paymentInstrument.put("targetApp", checksumInputParam.getTargettype());
        paymentRequest.put("paymentInstrument", paymentInstrument);
        JSONObject deviceContext = new JSONObject();
        deviceContext.put("deviceOS", "ANDROID");
        paymentRequest.put("deviceContext", deviceContext);
        System.out.println("paymentRequest: " + paymentRequest.toString());
        String base64Payload = Base64.encodeBase64String(paymentRequest.toString().getBytes());
        String data = base64Payload + "/pg/v1/pay6e54e2d7-0f23-4ab9-b87f-a94effa8c919";
        String digest = DigestUtils.sha256Hex(data);
        String result = digest + "###1";
        JSONObject response = new JSONObject();
        response.put("checksum", result);
        response.put("base64payload", base64Payload);
        response.put("apiendpoint", "/pg/v1/pay");
        response.put("transaction", transactionId);
        System.out.println("base64Payload: " + base64Payload);
        System.out.println("Checksum: " + result);

        String pattern = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        phonepe ph=new phonepe();
        ph.setLoanId((long)checksumInputParam.getLoanid());
        ph.setRequestGenerated(paymentRequest.toString());
        ph.setResponseGenerated(response.toString());
        ph.setTransactionId(transactionId);
        ph.setDate(date);
        phonepeRepository.save(ph);

        return response.toString();
    }

    @PostMapping("/checkStatusAPI")
    public String checkStatusAPI(@RequestBody CheckStatusAPIParam checkStatusAPIParam) {
        String merchantId = "CAPITALTRUSTUAT";
        String data = "/pg/v1/status/" + merchantId + "/" + checkStatusAPIParam.getMerchantTransactionId();
        String digest = DigestUtils.sha256Hex(data + "6e54e2d7-0f23-4ab9-b87f-a94effa8c919");
        String xverify = digest + "###1";
        String API_BASE_URL = "https://api-preprod.phonepe.com/apis/pg-sandbox/pg/v1/status/";

        try {

            URL url = new URL(API_BASE_URL + merchantId + "/" + checkStatusAPIParam.getMerchantTransactionId());
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-VERIFY", xverify);
            connection.setRequestProperty("X-MERCHANT-ID", checkStatusAPIParam.getMerchantTransactionId());
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null) {
                response.append(line);
            }

            phonepe ph=phonepeRepository.findByTransactionId(checkStatusAPIParam.getMerchantTransactionId());
            ph.setCheckstatusResponse(response.toString());
            phonepeRepository.save(ph);



            reader.close();
            return response.toString();
        } catch (Exception var12) {
            Exception e = var12;
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/pay")
    public PhonePeResponse getPhonePe() {
        String merchantId = "CAPITALTRUSTUAT";
        String saltKey = "6e54e2d7-0f23-4ab9-b87f-a94effa8c919";
        Integer saltIndex = 1;
        Env env = Env.UAT;
        String merchantTransactionId = UUID.randomUUID().toString().substring(0, 34);
        long amount = 100L;
        String merchantUserId = "loanId";
        String callbackurl = "http://localhost:8080/phonepe/servercallback";
        String redirecturl = "http://localhost:8080/phonepe/servercallback";
        String redirectMode = "REDIRECT";
        PgPayRequest pgPayRequest = PgPayRequest.PayPagePayRequestBuilder().amount(amount).merchantId(merchantId).merchantTransactionId(merchantTransactionId).callbackUrl(callbackurl).merchantUserId(merchantUserId).redirectUrl(redirecturl).redirectMode(redirectMode).build();
        boolean shouldPublishEvents = true;
        PhonePePaymentClient phonepeClient = new PhonePePaymentClient(merchantId, saltKey, saltIndex, env, shouldPublishEvents);
        PhonePeResponse<PgPayResponse> payResponse = phonepeClient.pay(pgPayRequest);
        PayPageInstrumentResponse payPageInstrumentResponse = (PayPageInstrumentResponse)((PgPayResponse)payResponse.getData()).getInstrumentResponse();
        String url = payPageInstrumentResponse.getRedirectInfo().getUrl();
        return payResponse;
    }




    @GetMapping("/validate")
    public boolean verifyValidity() {
        String merchantId = "CAPITALTRUSTUAT";
        String saltKey = "6e54e2d7-0f23-4ab9-b87f-a94effa8c919";
        Integer saltIndex = 1;
        Env env = Env.UAT;
        String merchantTransactionId = UUID.randomUUID().toString().substring(0, 34);
        long amount = 100L;
        String merchantUserId = "loanId";
        String callbackurl = "http://localhost:8080/phonepe/servercallback";
        String redirecturl = "https://www.merchant.com/redirect";
        String redirectMode = "REDIRECT";
        PgPayRequest.PayPagePayRequestBuilder().amount(amount).merchantId(merchantId).merchantTransactionId(merchantTransactionId).callbackUrl(callbackurl).merchantUserId(merchantUserId).redirectUrl(redirecturl).redirectMode(redirectMode).build();
        boolean shouldPublishEvents = true;
        PhonePePaymentClient phonepeClient = new PhonePePaymentClient(merchantId, saltKey, saltIndex, env, shouldPublishEvents);
        String xVerify = "a005532637c6a6e4a4b08ebc6f1144384353305a9cd253d995067964427cd0bb###1";
        JSONObject json = new JSONObject();
        json.put("response", "eyJzdWNjZXNzIjpmYWxzZSwiY29kZSI6IlBBWU1FTlRfRVJST1IiLCJtZXNzYWdlIjoiUGF5bWVudCBGYWlsZWQiLCJkYXRhIjp7Im1lcmNoYW50SWQiOiJtZXJjaGFudElkIiwibWVyY2hhbnRUcmFuc2FjdGlvbklkIjoibWVyY2hhbnRUcmFuc2FjdGlvbklkIiwidHJhbnNhY3Rpb25JZCI6IkZUWDIzMDYwMTE1NDMxOTU3MTYzMjM5IiwiYW1vdW50IjoxMDAsInN0YXRlIjoiRkFJTEVEIiwicmVzcG9uc2VDb2RlIjoiUkVRVUVTVF9ERUNMSU5FX0JZX1JFUVVFU1RFRSIsInBheW1lbnRJbnN0cnVtZW50IjpudWxsfX0=");
        System.out.println("data: " + json.toString());
        boolean value = phonepeClient.verifyResponse(xVerify, json.getString("response"));
        return value;
    }
}
