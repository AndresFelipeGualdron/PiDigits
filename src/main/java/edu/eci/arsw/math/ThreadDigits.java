package edu.eci.arsw.math;

public class ThreadDigits extends Thread{

    int start;
    int end;
    byte[] rta;

    public ThreadDigits(int start, int end){
        this.start = start;
        this.end = end;
    }


    public byte[] getRta() {
        return rta;
    }



    @Override
    public void run(){
        PiDigits piDigits = new PiDigits();
        this.rta = piDigits.getDigits(start,end);
        System.out.println(this.rta);

    }

}
