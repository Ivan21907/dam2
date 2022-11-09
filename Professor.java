package dam2;

import java.sql.*;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

        PreparedStatement pm = conect.prepareStatement("INSERT INTO professor (id, nom, cognoms) VALUES (?, ?, ?)");

        System.out.println("Introdueix l'id del professor: ");
        int idProfe = sc.nextInt();

        System.out.println("Introdueix el nom del professor: ");
        String nomProfe = sc.nextLine();

        System.out.println("Introdueix els cognoms del professor: ");
        String cognomsProfe = sc.nextLine();

        pm.setInt(1, idProfe);
        pm.setString(2, nomProfe);
        pm.setString(3, cognomsProfe);

        pm.executeUpdate();
    }

    public void deleteDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

        PreparedStatement pm = conect.prepareStatement("DELETE FROM professor WHERE id = ?");

        System.out.println("Introdueix l'id del professor a eliminar: ");
        int idProfe = sc.nextInt();

        pm.setInt(1, idProfe);

        pm.executeUpdate();
    }

    public void updateDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

        PreparedStatement pm = conect.prepareStatement("UPDATE professor SET nom = ?, cognoms = ? WHERE id = ?");

        System.out.println("Introdueix un l'id del professor: ");
        int idProfe = sc.nextInt();

        System.out.println("Introdueix un nou nom del professor: ");
        String nomProfe = sc.nextLine();

        System.out.println("Introdueix els cognoms del professor: ");
        String cognomsProfe = sc.nextLine();

        pm.setString(1, nomProfe);
        pm.setString(2, cognomsProfe);
        pm.setInt(3, idProfe);

        pm.executeUpdate();
    }

    public void readDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("SELECT * FROM professor");

            ResultSet rs = pm.executeQuery();

            while(rs.next())
            {
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Cognoms: " + rs.getString("cognoms"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
