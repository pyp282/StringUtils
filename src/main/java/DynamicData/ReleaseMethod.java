package DynamicData;


public class ReleaseMethod {
    /**
     * Unit Indented Space(3 spaces).
     */
    private static String SPACE = "   ";

    /**
     * Method to format raw json string.
     * @param rawJson raw json string.
     * @param eleNum number of elements will be shown in one line.
     * @return formatted json string.
     */
    public static String formatJson(String rawJson, int eleNum){
        StringBuffer result = new StringBuffer();
        int length = rawJson.length();
        int number = 0;
        char key = 0;
        int count = 0;

        for (int i = 0; i < length; i++) {
            key = rawJson.charAt(i);

            //new line
            if((key == '[') || (key == '{')){
                if((i - 1 > 0) && (rawJson.charAt(i - 1) == ':'))
                {
                    result.append('\n');
                    result.append(indent(number));
                }

                result.append(key);

                result.append('\n');

                //increase indentation.
                number++;
                result.append(indent(number));

                continue;
            }

            //new line
            if((key == ']') || (key == '}')){
                result.append('\n');

                //reduce indentation.
                number--;
                result.append(indent(number));

                result.append(key);

                if(((i + 1) < length) && (rawJson.charAt(i + 1) != ','))
                {
                    result.append('\n');
                }

                continue;
            }

            //new line
            if((key == ','))
            {
                count++;

                result.append(key);

                if((rawJson.charAt(i -1) == ']') || (rawJson.charAt(i -1) == '}')){
                    result.append('\n');
                    result.append(indent(number));
                    count = 0;
                }

                if(rawJson.charAt(i -1) == '"' && count == eleNum){
                    result.append('\n');
                    result.append(indent(number));
                    count = 0;
                }else {
                    result.append(" ");
                }

                continue;
            }

            result.append(key);
        }


        return result.toString();
    }

    /**
     * Method to return specific number SPACE.
     * @param number number of SPACEs
     * @return specific number SPACE.
     */
    private static String indent(int number)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++)
        {
            result.append(SPACE);
        }
        return result.toString();
    }

}
