package assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Assignment3 {
    public static double ping(String host) throws Exception {
        String pingCommand = "ping " + host;
        System.out.println(pingCommand);
        Process process = Runtime.getRuntime().exec(pingCommand);
        System.out.println(process);
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(inputStream+"jj");
        String output = "";
        String line = "";
        while ((line = inputStream.readLine()) != null) {
            System.out.println("inside while line "+line);
            System.out.println("inside while output before "+output);
            output += line + "\n";
            System.out.println("inside while output after"+output);
        }

        process.waitFor();
        System.out.println("outside while "+output);
        String[] timeArray = output.split("time=");
        System.out.println(Arrays.toString(timeArray));
        int pingCount = timeArray.length - 1;
        System.out.println(pingCount);
        double[] pingTimes = new double[pingCount];
        for (int i = 0; i < pingCount; i++) {
            String timeStr = timeArray[i + 1].substring(0, timeArray[i + 1].indexOf("ms") - 1);
            pingTimes[i] = Double.parseDouble(timeStr);
        }

        java.util.Arrays.sort(pingTimes);

        double median;
        if (pingCount % 2 == 0)
            median = (pingTimes[pingCount/2] + pingTimes[pingCount/2 - 1])/2;
        else
            median = pingTimes[pingCount/2];

        return median;
    }

    public static void main(String[] args) {
        String host = "google.com"; // replace with your own host name or IP address
        try {
            double median = ping(host);
            System.out.println("Median ping time to " + host + " is " + median + " ms");
        } catch (Exception e) {
            System.out.println("Ping failed: " + e.getMessage());
        }
    }
}
