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
public class AulaDAO extends Aula {

    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/planificador";
    private static final String USERNAME = "admin01";
    private static final String PASSWORD = "2811";

    private static Connection connection;

    AulaDAO() {
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

    public void create(Aula aula) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO aula (id_aula, Nombre,Capacidad) VALUES (?, ?,?)";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, aula.getId_aula());
        statement.setString(2,aula.getNombre());
        statement.setInt(3,aula.getCapacidad());
        statement.executeUpdate();
    }

    public Aula read(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM aula WHERE id_aula = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Aula aula = new Aula();
            aula.setId_aula(resultSet.getInt("id_aula"));
            aula.setNombre(resultSet.getString("nombre"));
            aula.setCapacidad(resultSet.getInt("Capacidad"));
            return aula;
        }
        return null;
    }

    public void update(Aula aula) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "UPDATE aula SET Nombre = ?, Capacidad = ? WHERE id_aula = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, aula.getNombre());
        statement.setInt(2, aula.getCapacidad());
        statement.setInt(3, aula.getId_aula());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "DELETE FROM aula WHERE id_aula = ?";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public List<Aula> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM aula";
        List<Aula> aula;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            aula = new ArrayList<>();
            while (resultSet.next()) {
                Aula aula1 = new Aula();
                aula1.setId_aula(resultSet.getInt("id_aula"));
                aula1.setNombre(resultSet.getString("nombre"));
                aula1.setCapacidad(resultSet.getInt("Capacidad"));

                aula.add(aula1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("" + e.getMessage());
            return null;
        }
        return aula;
    }
}
