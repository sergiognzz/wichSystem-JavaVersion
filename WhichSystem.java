
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class WhichSystem {
    public static void main(String[] args) {

       if  (args.length == 0) {
           System.out.println("Usage: java WhichSystem.java <IP_ADDRESS>");
           return;
       }

       int ttl = getTTL(args[0]);
       String os = getOS(ttl);
       System.out.println("Detected OS: " + os);
       System.out.println("TTL value: " + ttl);
    }

    public static String getOS(int ttl){
        if (ttl == 0) {
            return "Error: Unable to determine TTL value.";
        } else if (ttl >= 0 && ttl <= 64) {
            return "Linux";
        } else if (ttl >= 65 && ttl <= 128) {
            return "Windows";
        } else if (ttl == 255) {
            return "macOS";
        } else {
            return "Unknown";
        }
    }

    public static int getTTL(String ipAddress){
         
       try{
            System.out.println("Fetching TTL for IP address: " + ipAddress);

            ProcessBuilder pb = new ProcessBuilder(
            "/bin/bash",
            "-c",
            "/usr/bin/ping -c 1 " + ipAddress + " | awk -F'ttl=' '/ttl=/{print $2}' | awk '{print $1}'"
            );

            Process proceso = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            
            String line = reader.readLine();

            if (line != null) {
                int ttl = Integer.parseInt(line.trim());
                return ttl;
            } else {
                return 0;
            }

       }
       catch(Exception e){
          return 0;
       }
    }
}