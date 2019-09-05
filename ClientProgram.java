import java.net.*;
import java.io.*;
public class ClientProgram implements Runnable
{
    int clientport=10,serverport=20;
    DatagramSocket ds;
    Thread recThread;
   public ClientProgram()throws IOException
    {
        ds=new DatagramSocket(clientport);
        recThread=new Thread(this);
        recThread.start();
    }
    public void run()
    {
        System.out.println("IN RUN  FUNCTION");
        byte b[]=new byte[1000];
        while(true)
        {
            System.out.println("TTTTTTTTTTTTTT");
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
    public static void main(String ar[])throws IOException
    {
        new ClientProgram();
    }
}