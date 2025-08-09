/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autos;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import autos.Main.*;
/**
 *
 * @author Carlos
 */
public class rep_cliente {
static Connection conn=null;
public static void visualiza()
        {
    try
            {
        conn=Main.Enlace(conn);
        conn.setAutoCommit(false);
}
    catch(SQLException e)
            {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    try
    {
        Map parameters=new HashMap();
        parameters.put("","");
        JasperPrint print=JasperFillManager.fillReport(System.getProperty("user.dir")+
        "/reportes/cliente.jasper",parameters,conn);
     JasperViewer.viewReport(print,false);
}
catch(Exception e)
{
    e.printStackTrace();
}
}
}
