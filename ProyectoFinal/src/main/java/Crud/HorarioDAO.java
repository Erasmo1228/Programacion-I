/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Erasmo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// En esta clase se crea la conexion de las entidades con la base de datos y sus repectivos metodos
public class HorarioDAO extends Horario {
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    HorarioDAO() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (connection == null) {
            try {
                // load and register JDBC driver for MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            } catch (SQLException esql) {
                System.out.println("" + esql.getMessage());
                return null;
            }
        }
        return connection;
    }

    public void create(Horario hora) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO horario (id_horario, dia,Fechainicio,FechaFin,id_aula) VALUES (?, ?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, hora.getId_horario());
        statement.setString(2,hora.getDia());
        statement.setString(3,hora.getFechaInicio());
        statement.setString(4,hora.getFechaFin());
        statement.setInt(5, hora.getId_aula());
        statement.executeUpdate();
    }

    public Horario read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM horario WHERE id_aula = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Horario hora = new Horario();
            hora.setId_horario(resultSet.getInt("id_horario"));
            hora.setDia(resultSet.getString("dia"));
            hora.setFechaInicio(resultSet.getString("Fechainicio"));
            hora.setFechaFin(resultSet.getString("FechaFin"));
            hora.setId_aula(resultSet.getInt("id_aula"));
            return hora;
        }
        return null;
    }

    public void update(Horario hora) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE horario SET dia = ?, Fechainicio = ?,FechaFin = ?, id_aula = ? WHERE id_horario = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, hora.getDia());
        statement.setString(2, hora.getFechaInicio());
        statement.setString(3, hora.getFechaFin());
        statement.setInt(4, hora.getId_aula());
        statement.setInt(5, hora.getId_horario());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM horario WHERE id_horario = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Horario> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM horario";
        List<Horario> hora;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            hora = new ArrayList<>();
            while (resultSet.next()) {
                Horario hora1 = new Horario();
                hora1.setId_horario(resultSet.getInt("id_horario"));
                hora1.setDia(resultSet.getString("dia"));
                hora1.setFechaInicio(resultSet.getString("Fechainicio"));
                hora1.setFechaFin(resultSet.getString("FechaFin"));
                hora1.setId_aula(resultSet.getInt("id_aula"));

                hora.add(hora1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return hora;
    }
}
