import java.net.*;
import java.io.*;
public class Clientalso implements Runnable
{
    int clientport=10,serverport=20;
    DatagramSocket ds;
    Thread recThread;
   public Clientalso()throws IOException
    {
        ds=new DatagramSocket(clientport);
        recThread=new Thread(this);
        recThread.start();
        sends();
    }
    public void sends() throws IOException
    {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String data=br.readLine();
            if(data.equals("EXIT"))
                break;
            DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),serverport);
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
    public static void main(String ar[]) throws IOException
    {
        new Clientalso();
    }
}