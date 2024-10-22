import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SOAPClient {
    public static void main(String[] args) throws Exception {
        String soapEndpoint = "https://your-atlassian-endpoint";
        String soapAction = "http://example.org/your-service/GetInfo";

        String xmlRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                            "xmlns:web=\"http://example.org/your-service\">" +
                            "<soapenv:Header/><soapenv:Body>" +
                            "<web:GetInfo><web:ID>12345</web:ID></web:GetInfo>" +
                            "</soapenv:Body></soapenv:Envelope>";

        URL url = new URL("https", "your-atlassian-endpoint", "/path-to-resource");
        HttpURLConnection connection = (url) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setRequestProperty("SOAPAction", soapAction);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(xmlRequest.getBytes(StandardCharsets.UTF_8));
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}
