package dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Professor
{
    private int id;
    private String nom;
    private String cognoms;

    public Professor(int id, String nom, String cognoms)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public void addDam2() throws SQLException
    {
        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

        PreparedStatement pm = conect.prepareStatement("INSERT INTO professor (id, nom, cognoms) VALUES (?, ?, ?)");
        pm.executeUpdate();
    }

}
