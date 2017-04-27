package DynamicData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JacksonDemo {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("src/main/java/DynamicData/domains.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        StringBuilder stringBuilder = new StringBuilder();

        String inputStr;
        JSONObject config = null;

        String formatedJson = "";

        while ((inputStr = bufferedReader.readLine()) != null)
            stringBuilder.append(inputStr);

        System.out.println(stringBuilder.toString());

        formatedJson = ReleaseMethod.formatJson(stringBuilder.toString(), 3);
        System.out.println(formatedJson);
        config = new JSONObject(stringBuilder.toString());
        JSONArray transferDomains = config.getJSONArray("TransferDomains");

        for (int i = 0; i < transferDomains.length(); i++) {
            System.out.println(transferDomains.get(i));
        }
//
        System.out.println(config.toString());


        File file = new File("src/main/java/DynamicData/domainsFormat.json");
        FileWriter fileWriter = new FileWriter(file);


        fileWriter.write(formatedJson);
        fileWriter.flush();
        fileWriter.close();


    }
}
