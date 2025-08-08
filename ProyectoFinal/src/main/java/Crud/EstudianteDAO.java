/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// En esta clase se crea la conexion de las entidades con la base de datos y sus repectivos metodos
public class EstudianteDAO extends Estudiante{
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    EstudianteDAO() {
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

    public void create(Estudiante estudiante) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO Estudiante (nombre, EmailEstudiante, Carrera) VALUES (?, ?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, estudiante.getNombre());
        statement.setString(2,estudiante.getCorreo());
        statement.setString(3,estudiante.getCarrera());
        statement.executeUpdate();
    }

    public Estudiante read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM Estudiante WHERE id_estudiante = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId_estudiante(resultSet.getInt("id_estudiante"));
            estudiante.setNombre(resultSet.getString("nombre"));
            estudiante.setCorreo(resultSet.getString("EmailEstudiante"));
            estudiante.setCarrera(resultSet.getString("Carrera"));
            return estudiante;
        }
        return null;
    }

    public void update(Estudiante estudiante) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE estudiante SET nombre = ?, EmailEstudiante = ?, Carrera = ? WHERE id_estudiante = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, estudiante.getNombre());
        statement.setString(2, estudiante.getCorreo());
        statement.setString(3,estudiante.getCarrera());
        statement.setInt(4, estudiante.getId_estudiante());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Estudiante> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM estudiante";
        List<Estudiante> estudiante;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            estudiante = new ArrayList<>();
            while (resultSet.next()) {
                Estudiante estudiante1 = new Estudiante();
                estudiante1.setId_estudiante(resultSet.getInt("id_estudiante"));
                estudiante1.setNombre(resultSet.getString("nombre"));
                estudiante1.setCorreo(resultSet.getString("EmailEstudiante"));
                estudiante1.setCarrera(resultSet.getString("Carrera"));

                estudiante.add(estudiante1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return estudiante;
    }
}
