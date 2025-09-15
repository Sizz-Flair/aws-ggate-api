package com.sms.ggateapi.domain;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Async test 클래스.
 * * <p>역할:
 * * <p>상속: PsiClass:Object
 * * @author YourName
 *
 * @since 2025 -09-07
 */
@Service
public class AsyncTest {

    @Async
    public CompletableFuture<Integer> test(Integer i) throws InterruptedException {
        System.out.println("test"+i);
        Thread.sleep(100);
        return CompletableFuture.completedFuture(i);
    }


    @Async
    public CompletableFuture<Map<String, String>> getAddress(String orderNo, String address){
        StringBuffer content = new StringBuffer();
        Map<String, String> result = new HashMap<>();
        OutputStreamWriter wr = null;
        InputStreamReader in = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(null, "https://address.doortodoor.co.kr/address/address_webservice.korex");
            TrustManager[] tm = new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers(){return null;}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
            }};


            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, tm, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                public boolean verify(String string,SSLSession ssls) {
                    return true;
                }
            });
            String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.address.nplus.doortodoor.co.kr/\">" +
                    "	<soapenv:Header/>" +
                    "	<soapenv:Body>" +
                    "		<web:getAddressInformationByValue>" +
                    "			<arg0>" +
                    "				<!--박스타입(1: 극소, 2: 소, 3:중, 4:대) -->" +
                    "				<boxTyp>1</boxTyp>" +
                    "				<clntMgmCustCd>30327633</clntMgmCustCd>" +
                    "				<clntNum>30327633</clntNum>" +
                    "				<cntrLarcCd>01</cntrLarcCd>" +
                    "				<fareDiv>03</fareDiv>" +
                    "				<orderNo><![CDATA["+orderNo+"]]></orderNo>" +
                    "				<prngDivCd>01</prngDivCd>" +
                    "				<rcvrAddr><![CDATA["+address+"]]></rcvrAddr>" +
                    "				<sndprsnAddr>인천광역시 중구 제물량로 197</sndprsnAddr>" +
                    "			</arg0>" +
                    "		</web:getAddressInformationByValue>" +
                    "	</soapenv:Body>" +
                    "</soapenv:Envelope>";
            conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.addRequestProperty("Content-Type", "text/xml");
            wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(xml);
            wr.flush();

            in = new InputStreamReader(conn.getInputStream(),"utf-8");
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null){
                content.append(line);
            }
            System.out.println(content.toString());

            if(result.isEmpty()) {
                result = null;
            }
        }catch(Exception e){
            result = null;
            System.out.println(content.toString());
            System.out.println(address);
            System.out.println("KOREX Error");
            e.printStackTrace();
        }finally{
            if(in!=null){try{in.close();}catch(Exception e){}}
            if(wr!=null){try{wr.close();}catch(Exception e){}}
            if(conn!=null){try{conn.disconnect();}catch(Exception e){}}
        }
        return null;
    }

}
