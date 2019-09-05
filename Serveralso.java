import java.net.*;
import java.io.*;
public class Serveralso implements Runnable
{
    int clientport=10,serverport=20;
    DatagramSocket ds;
    Thread recthread;
    public Serveralso() throws Exception
    {
        ds=new DatagramSocket(serverport);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        recthread=new Thread(this);
        recthread.start();
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
   public void run()
    {
    byte b[]=new byte[1000];
        while(true)
        {
            try
            {
            DatagramPacket dp=new DatagramPacket(b,b.length);
            ds.receive(dp);
            String data=new String(b,0,dp.getLength());
            System.out.println("Server:"+data);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    public static void main(String ar[]) throws Exception
    {
       new Serveralso(); 
    }
}