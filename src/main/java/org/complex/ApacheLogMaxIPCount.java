package org.complex;


import java.util.HashMap;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLogMaxIPCount {

    public static void main(String[] args) {
        // Sample log data
        String logData =
                "123.123.23.123 - - [26/Apr/2000:00:23:48 -0400] \"GET /pics/wpaper.gif HTTP/1.0\" 200 6248 \"http://www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n" +
                        "123.123.123.123 - - [26/Apr/2000:00:23:47 -0400] \"GET /asctortf/ HTTP/1.0\" 200 8130 \"http://search.netscape.com/Computers/Data_Formats/Document/Text/RTF\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n" +
                        "123.123.123.124 - - [25/Apr/2000:00:23:48 -0400] \"GET /pics/5star2000.gif HTTP/1.0\" 200 4005 \"http://www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n" +
                        "123.123.123.123 - - [25/Apr/2000:00:23:50 -0400] \"GET /pics/5star.gif HTTP/1.0\" 404 1031 \"http://www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n" +
                        "123.123.123.124 - - [25/Apr/2000:00:23:51 -0400] \"GET /pics/a2hlogo.jpg HTTP/1.0\" 200 4282 \"http://www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n" +
                        "123.123.123.124 - - [24/Apr/2000:00:23:51 -0400] \"GET /cgi-bin/newcount?jafsof3&width=4&font=digital&noshow HTTP/1.0\" 200 36 \"http://www.jafsoft.com/asctortf/\" \"Mozilla/4.05 (Macintosh; I; PPC)\"\n";

        // Process the log data
        String mostFrequentIP = getMostFrequentIP(logData);
        System.out.println("The most frequent IP address is: " + mostFrequentIP);
    }

    public static String getMostFrequentIP(String logData) {
        // Split the log data into lines
        String[] lines = logData.split("\n");

        // Map to count occurrences of each IP address
        Map<String, Integer> ipCountMap = new HashMap<>();

        for (String line : lines) {
            // Extract IP address
            String ip = extractIP(line);
            //String ip = extractDate(line);

            // Update count in the map
            ipCountMap.put(ip, ipCountMap.getOrDefault(ip, 0) + 1);
        }
        System.out.println(ipCountMap);

        // Find the IP address with the maximum count
        String mostFrequentIP = null;
        int maxCount = 0;

        for (Entry<String, Integer> entry : ipCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentIP = entry.getKey();
            }
        }

        return mostFrequentIP;
    }

    private static String extractIP(String logLine) {
        // IP address is the first token in the line
        StringTokenizer tokenizer = new StringTokenizer(logLine);
        return tokenizer.nextToken();
    }

    // If Date is to be extracted (or let say another column)
    private static String extractDate(String logLine) {

        //String regex = "\\[\\d{2}/[A-Za-z]{3}/\\d{4}:\\d{2}:\\d{2}:\\d{2} [+-]\\d{4}\\]";
        String regex = "\\[\\d{2}/[A-Za-z]{3}/\\d{4}:";

        // Pattern to match Date
        Pattern ipPattern = Pattern.compile(regex);

        // Extract Date address using regex
        Matcher matcher = ipPattern.matcher(logLine);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
