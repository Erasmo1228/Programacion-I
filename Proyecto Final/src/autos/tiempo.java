package autos;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JLabel;

public class tiempo extends Thread{
     private int horas=0;
  private int minutos=0;
   private int segundos=0;
    private JLabel txtaux;
    public static void main(String[] args) {
    }

    tiempo(JLabel lbhora) {
        Calendar c=Calendar.getInstance();
        horas=c.getTime().getHours();
         minutos=c.getTime().getMinutes();
          segundos=c.getTime().getSeconds();
          txtaux=lbhora;
          this.mostrarHora(txtaux);
    }
    public void run()
    {
     while(true)
     {//paramos 1 segundo
      try
        {Thread.sleep(1000);
        }
      catch(InterruptedException ex)
      {ex.printStackTrace();
      }
      //incrementamos 1 segundo
      segundos++;
      if(segundos==60){
         segundos=0;
         minutos++;
       if(minutos==60){
          minutos=0;
          horas++;
       if(horas==24){
          horas=0;
       }}}
      this.mostrarHora(txtaux);
     }}
public void mostrarHora(JLabel Txtime)
{//formatear hora}
    StringBuffer tmp=new StringBuffer(8);
    if(horas<10)
    {tmp.append(0);
    }
    tmp.append(horas);
    tmp.append(":");
    if(minutos<10)
    {tmp.append(0);
    }
    tmp.append(minutos);
    tmp.append(":");
    if(segundos<10)
      {tmp.append(0);
      }
    tmp.append(segundos);
    Txtime.setText(tmp.toString());
    }
}
