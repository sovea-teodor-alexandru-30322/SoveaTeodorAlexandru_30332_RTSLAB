package Example5;

import java.io.PipedOutputStream;
import java.io.*;
public class Main{
    public static void main(String args[]) {
        ReadThread rt = new ReadThread();
        WriteThread wt = new WriteThread();
        try{
            rt.conect(wt.getPipe());
            rt.start();wt.start();
        }catch(Exception e){e.printStackTrace();}
    }
}

class WriteThread extends Thread{
    private PipedOutputStream po;
    WriteThread(){
        po = new PipedOutputStream();
    }
    public void run(){
        try{
            while (true){
                int d = (int)(10*Math.random());
                System.out.println("Writing Thread is sent : "+d);
                po.write(d);
                sleep(400);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    PipedOutputStream getPipe(){return po;}
}
