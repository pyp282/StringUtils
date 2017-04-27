package DynamicData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModifyContentDemo {

    public static void modifyLine() throws IOException {
        List<String> newlines = new ArrayList<>();
        String filePath = "src/main/java/DynamicData/domainsFormat.json";


        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        for (String line : lines) {
            if(line.contains("baidu.com")){
                newlines.add(line.replace("baidu.com", "" + new Date()));
            }else {
                newlines.add(line);
            }
        }

        Files.write(Paths.get(filePath), newlines, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {
        modifyLine();
    }
}
