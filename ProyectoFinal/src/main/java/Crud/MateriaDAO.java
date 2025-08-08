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

public class MateriaDAO extends Materia{
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    MateriaDAO() {
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

    public void create(Materia asignatura) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO materia (id_Materia, nombre, Creditos,Descripcion,id_estudiante,id_profesor) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1,asignatura.getId_materia());
        statement.setString(2, asignatura.getNombre());
        statement.setInt(3,asignatura.getCreditos());
        statement.setString(4,asignatura.getDescripcion());
        statement.setInt(5,asignatura.getId_estudiante());
        statement.setInt(6,asignatura.getId_profesor());
        statement.executeUpdate();
    }

    public Materia read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM materia WHERE id_Materia = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Materia asignatura = new Materia();
            asignatura.setId_materia(resultSet.getInt("id_Materia"));
            asignatura.setNombre(resultSet.getString("Nombre"));
            asignatura.setCreditos(resultSet.getInt("Creditos"));
            asignatura.setDescripcion(resultSet.getString("Descripcion"));
            asignatura.setId_estudiante(resultSet.getInt("id_estudiante"));
            asignatura.setId_profesor(resultSet.getInt("id_profesor"));
            return asignatura;
        }
        return null;
    }

    public void update(Materia asignatura) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE materia SET Nombre = ?, Creditos = ? , Descripcion = ? , id_estudiante = ?, id_profesor = ?  WHERE id_Materia = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, asignatura.getNombre());
        statement.setInt(2, asignatura.getCreditos());
        statement.setString(3,asignatura.getDescripcion());
        statement.setInt(4, asignatura.getId_estudiante());
        statement.setInt(5, asignatura.getId_profesor());
        statement.setInt(6,asignatura.getId_materia());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM materia WHERE id_Materia = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Materia> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM materia";
        List<Materia> asignatura;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            asignatura = new ArrayList<>();
            while (resultSet.next()) {
                Materia asignatura1 = new Materia();
                asignatura1.setId_materia(resultSet.getInt("id_Materia"));
                asignatura1.setNombre(resultSet.getString("Nombre"));
                asignatura1.setCreditos(resultSet.getInt("Creditos"));
                asignatura1.setDescripcion(resultSet.getString("Descripcion"));
                asignatura1.setId_estudiante(resultSet.getInt("id_estudiante"));
                asignatura1.setId_profesor(resultSet.getInt("id_profesor"));

                asignatura.add(asignatura1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return asignatura;
    }
}

