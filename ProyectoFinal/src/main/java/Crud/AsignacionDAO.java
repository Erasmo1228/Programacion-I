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
public class AsignacionDAO extends  Asignacion{

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    AsignacionDAO() {
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

    public void create(Asignacion tarea) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO asignacion (id_asignacion, id_estudiante,id_Materia, id_profesor,id_aula,id_horario) VALUES (?, ?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, tarea.getId_asignacion());
        statement.setInt(2,tarea.getId_estudiante());
        statement.setInt(3,tarea.getId_materia());
        statement.setInt(4,tarea.getId_profesor());
        statement.setInt(5,tarea.getId_aula());
        statement.setInt(6,tarea.getId_horario());
        statement.executeUpdate();
    }

    public Asignacion read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM asignacion WHERE id_asignacion = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Asignacion tarea = new Asignacion();
            tarea.setId_asignacion(resultSet.getInt("id_asignacion"));
            tarea.setId_estudiante(resultSet.getInt("id_estudiante"));
            tarea.setId_materia(resultSet.getInt("id_Materia"));
            tarea.setId_profesor(resultSet.getInt("id_profesor"));
            tarea.setId_aula(resultSet.getInt("id_aula"));
            tarea.setId_horario(resultSet.getInt("id_horario"));
            return tarea;
        }
        return null;
    }

    public void update(Asignacion tarea) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE asignacion SET id_estudiante = ?, id_Materia = ?, id_profesor = ?,id_aula = ? ,id_horario = ? WHERE id_asignacion = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, tarea.getId_estudiante());
        statement.setInt(2, tarea.getId_materia());
        statement.setInt(3, tarea.getId_profesor());
        statement.setInt(4, tarea.getId_aula());
        statement.setInt(5, tarea.getId_horario());
        statement.setInt(6, tarea.getId_asignacion());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM asignacion WHERE id_asignacion = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Asignacion> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM asignacion";
        List<Asignacion> tarea;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            tarea = new ArrayList<>();
            while (resultSet.next()) {
                Asignacion tarea1 = new Asignacion();
                tarea1.setId_asignacion(resultSet.getInt("id_asignacion"));
                tarea1.setId_estudiante(resultSet.getInt("id_estudiante"));
                tarea1.setId_profesor(resultSet.getInt("id_profesor"));
                tarea1.setId_aula(resultSet.getInt("id_aula"));
                tarea1.setId_horario(resultSet.getInt("id_horario"));
                tarea1.setId_materia(resultSet.getInt("id_materia"));


                tarea.add(tarea1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return tarea;
    }
}

