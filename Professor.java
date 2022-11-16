package dam2;

import java.sql.*;
import java.util.Scanner;

public class Professor
{
    //Atributs de la classe
    private int id;
    private String nom;
    private String cognoms;

    //constructors de la classe
    public Professor(String nom, String cognoms)
    {
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professor(int id, String nom, String cognoms)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professor(int id)
    {
        this.id = id;
    }

    //Getters & Setters
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

    /**
     * Funcio que afegeix un professor a la base de dades
     * @throws SQLException
     */
    public void addDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            //fem la connexio
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            //preparem la sentencia
            PreparedStatement pm = conect.prepareStatement("INSERT INTO professors (nom, cognom) VALUES (?, ?)");

            //omplim els camps de la sentencia
            pm.setString(1, this.nom);
            pm.setString(2, this.cognoms);

            //executem la sentencia
            pm.executeUpdate();

            //tanquem la connexio
            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Funcio que elimina un professor de la base de dades
     * @throws SQLException
     */
    public void deleteDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("DELETE FROM professors WHERE idprofessors = ?");

            pm.setInt(1, this.id);

            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Funcio que modifica un professor de la base de dades a partir del seu id
     * @throws SQLException
     */
    public void updateDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("UPDATE professors SET nom = ?, cognom = ? WHERE idprofessors = ?");

            pm.setString(1, this.nom);
            pm.setString(2, this.cognoms);
            pm.setInt(3, this.id);


            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Funcio que mostra tots els professors de la base de dades
     */
    public void readDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("SELECT * FROM professors");

            ResultSet rs = pm.executeQuery();

            while(rs.next())
            {
                System.out.println("Id: " + rs.getInt("idprofessors"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Cognoms: " + rs.getString("cognom"));
            }

            pm.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
