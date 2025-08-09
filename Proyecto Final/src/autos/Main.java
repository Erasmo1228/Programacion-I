package autos;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class Main {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;

    static String bd="pro_visual";
    static String login="admin01";
    static String password="2811";
    static String url="jdbc:mysql://localhost/"+bd;


    public static Connection Enlace(Connection conn) throws SQLException{
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e)
        {
            System.out.print("Clase no Encontrada");
        }
        return conn;
    }
public static Statement sta (Statement st) throws SQLException{
    conn=Enlace(conn);
    st=conn.createStatement();
    return st;
}

public static ResultSet Vermarcas(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select nombre from marca ";
    PreparedStatement prov=conn.prepareStatement(cad);
    rs=prov.executeQuery();
    return rs;
}

public static ResultSet Vermodelos(ResultSet rs, String mar) throws SQLException{
    st=sta(st);
    String cad;
    cad="SELECT modelo.descripcion from modelo inner join marca on modelo.idmarca=marca.idmarca where marca.nombre='"+mar+"'";
    PreparedStatement prov=conn.prepareStatement(cad);
    rs=prov.executeQuery();
    return rs;
}

public static ResultSet ObtenerCodMarca(ResultSet rs, String nom)throws SQLException
    {
    st=sta(st);
    String cad;
    cad="select idmarca from marca where nombre='"+nom+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet ObtenerCodModelo(ResultSet rs, String nom)throws SQLException
    {
    st=sta(st);
    String cad;
    cad="select idmodelo from modelo where descripcion='"+nom+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet ObtenerCodRepuesto(ResultSet rs, String nom)throws SQLException
    {
    st=sta(st);
    String cad;
    cad="select idproducto from productos where nombre='"+nom+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet ObtenerCodcliente(ResultSet rs, String nom)throws SQLException
    {
    st=sta(st);
    String cad;
    cad="select idcliente from clientes where apellidos='"+nom+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet Enlmarca(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from marca";
    PreparedStatement mar=conn.prepareStatement(cad);
    rs=mar.executeQuery();
    return rs;
}
public static ResultSet Enluser(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from usuario";
    PreparedStatement mar=conn.prepareStatement(cad);
    rs=mar.executeQuery();
    return rs;
}
public static ResultSet Enlcliente(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from clientes";
    PreparedStatement mar=conn.prepareStatement(cad);
    rs=mar.executeQuery();
    return rs;
}
public static ResultSet Enlvautos(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from auto";
    PreparedStatement mar=conn.prepareStatement(cad);
    rs=mar.executeQuery();
    return rs;
}
public static ResultSet Enlmodelo(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from ver_modelo";
    PreparedStatement mod=conn.prepareStatement(cad);
    rs=mod.executeQuery();
    return rs;
}
public static ResultSet Enlrepuesto(ResultSet rs) throws SQLException{
    st=sta(st);
    String cad;
    cad="select * from productos";
    PreparedStatement mod=conn.prepareStatement(cad);
    rs=mod.executeQuery();
    return rs;
}

public static ResultSet login(ResultSet rs) throws SQLException{
        st=sta(st);
        PreparedStatement log=conn.prepareCall("{call login()}");
        rs=log.executeQuery();
        return rs;
    }
public static ResultSet precio(ResultSet rs,String des) throws SQLException{
        st=sta(st);
        st=sta(st);
    String cad;
    cad="SELECT modelo.precio as total from modelo where modelo.descripcion='"+des+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet preciopro(ResultSet rs,String des) throws SQLException{
        st=sta(st);
        st=sta(st);
    String cad;
    cad="SELECT precio from productos where nombre='"+des+"'";
    rs=st.executeQuery(cad);
    return rs;
    }
public static ResultSet info(ResultSet rs,String nom) throws SQLException{
        st=sta(st);
        st=sta(st);
    String cad;
    cad="SELECT descripcion,precio from productos where nombre='"+nom+"'";
    rs=st.executeQuery(cad);
    return rs;


    }


}

