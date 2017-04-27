package DynamicData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDomains {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        JSONObject allEnvDomains = new JSONObject();
        allEnvDomains.put("ote", addEnvDomains());
        allEnvDomains.put("test", addEnvDomains());
        allEnvDomains.put("dev", addEnvDomains());


        File file = new File("src/main/java/DynamicData/domains.json");
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("Writing JSON object to file");
        System.out.println("-----------------------");
        System.out.println(allEnvDomains);

        String formatJson = ReleaseMethod.formatJson(allEnvDomains.toJSONString(), 3);

        fileWriter.write(formatJson);
        fileWriter.flush();
        fileWriter.close();

        allEnvDomains.put("test", updateEnvDomains());

        formatJson = ReleaseMethod.formatJson(allEnvDomains.toJSONString(), 3);

        fileWriter = new FileWriter(file);
        fileWriter.write(formatJson);
        fileWriter.flush();
        fileWriter.close();


    }

    @SuppressWarnings("unchecked")
    public static JSONObject addEnvDomains(){
        JSONObject specificEnv = new JSONObject();

        JSONArray transferDomains = new JSONArray();
        transferDomains.add("google.com");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("APIRESELLERFJSOWIRLSK.NET");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        specificEnv.put("TransferDomains", transferDomains);

        JSONArray renewalDomains = new JSONArray();
        renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");
        specificEnv.put("RenewalDomains", renewalDomains);

        JSONArray privacyDomains = new JSONArray();
        privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org");
        specificEnv.put("PrivacyDomains", privacyDomains);

        return specificEnv;
    }


    @SuppressWarnings("unchecked")
    public static JSONObject updateEnvDomains(){
        JSONObject specificEnv = new JSONObject();

        JSONArray transferDomains = new JSONArray();

        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        transferDomains.add("facebook.net");
        specificEnv.put("TransferDomains", transferDomains);

        JSONArray renewalDomains = new JSONArray();
        renewalDomains.add("baidu.com");

        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");renewalDomains.add("baidu.com");
        renewalDomains.add("sina.us");
        specificEnv.put("RenewalDomains", renewalDomains);

        JSONArray privacyDomains = new JSONArray();

        privacyDomains.add("helloworld.org"); privacyDomains.add("apireseller.com");
        privacyDomains.add("helloworld.org");
        specificEnv.put("PrivacyDomains", privacyDomains);

        return specificEnv;
    }

}
