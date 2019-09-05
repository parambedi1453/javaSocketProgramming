import java.net.*;
import java.io.*;

// this is one way in which server is sending and client is recieving
public class ServerProgram
{
    int clientport=10,serverport=20;
    DatagramSocket ds;
    public ServerProgram()throws IOException
    {
        ds=new DatagramSocket(serverport);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String data=br.readLine();
            if(data.equals("EXIT"))
                break;
            DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),clientport);
            ds.send(dp);
        }
        ds.close();
    }
    public static void main(String ar[])throws IOException
    {
       new ServerProgram(); 
   
    }
}
