/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

/**
 *
 * @author Erasmo
 */
// En esta clase se crea la conexion de las entidades con la base de datos y sus repectivos metodos
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO extends Profesor {
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    ProfesorDAO() {
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

    public void create(Profesor teacher) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO profesor (id_profesor, nombre, EmailProfesor,Especialidad) VALUES (?,?, ?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1,teacher.getId_profesor());
        statement.setString(2, teacher.getNombre());
        statement.setString(3,teacher.getEmailProfesor());
        statement.setString(4,teacher.getEspecialidad());
        statement.executeUpdate();
    }

    public Profesor read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM profesor WHERE id_profesor = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Profesor teacher = new Profesor();
            teacher.setId_profesor(resultSet.getInt("id_profesor"));
            teacher.setNombre(resultSet.getString("nombre"));
            teacher.setEmailProfesor(resultSet.getString("EmailProfesor"));
            return teacher;
        }
        return null;
    }

    public void update(Profesor teacher) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE profesor SET nombre = ?, EmailProfesor = ? , Especialidad = ? WHERE id_profesor = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, teacher.getNombre());
        statement.setString(2, teacher.getEmailProfesor());
        statement.setString(3,teacher.getEspecialidad());
        statement.setInt(4, teacher.getId_profesor());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM profesor WHERE id_profesor = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Profesor> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM profesor";
        List<Profesor> teacher;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            teacher = new ArrayList<>();
            while (resultSet.next()) {
                Profesor teacher1 = new Profesor();
                teacher1.setId_profesor(resultSet.getInt("id_profesor"));
                teacher1.setNombre(resultSet.getString("Nombre"));
                teacher1.setEmailProfesor(resultSet.getString("EmailProfesor"));
                teacher1.setEspecialidad(resultSet.getString("Especialidad"));

                teacher.add(teacher1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return teacher;
    }
}
