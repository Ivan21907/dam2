package dam2;

import java.sql.*;
import java.util.Scanner;

public class ModulProfessional
{
    //Atributs de la classe
    private int id;
    private String nom;
    private int id_professor;

    //constructors de la classe
    public ModulProfessional(int id, String nom, int id_professor)
    {
        this.id = id;
        this.nom = nom;
        this.id_professor = id_professor;
    }

    //
    public ModulProfessional(String nom, int id_professor)
    {
        this.nom = nom;
        this.id_professor = id_professor;
    }

    public ModulProfessional(int id)
    {
        this.id = id;
    }

    public ModulProfessional(String nom)
    {
        this.nom = nom;
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

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    /**
     * Funcio que afegeix un modul a la base de dades
     * @throws SQLException
     */
    public void addDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            //fem la connexio a la base de dades
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            //preparem la sentencia
            PreparedStatement pm = conect.prepareStatement("INSERT INTO mòdul_professional (nom, id_professor) VALUES (?, ?)");

            //omplim els camps de la sentencia
            pm.setString(1, this.nom);
            pm.setInt(2, this.id_professor);

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
     * Funcio que modifica un modul de la base de dades a partir de l'id del modul
     */
    public void updateDam2()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("UPDATE mòdul_professional SET nom = ?, id_professor = ? WHERE idmòdul_Professional = ?");

            pm.setString(1, this.nom);
            pm.setInt(2, this.id_professor);
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
     * Funcio que elimina un modul de la base de dades a partir de l'id del modul
     */
    public void deleteDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("DELETE FROM mòdul_professional WHERE idmòdul_Professional = ?");

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
     * Funcio que mostra tots els moduls i els professors (pel seu nom i cognom) de la base de dades
     */
    public void readDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("SELECT mp.idmòdul_Professional, mp.nom, p.nom, p.cognom FROM " +
                    "mòdul_professional mp INNER JOIN professors p ON mp.id_professor = p.idprofessors");

            ResultSet rs = pm.executeQuery();

            while (rs.next())
            {
                System.out.println("Id del mòdul professional: " + rs.getInt(1));
                System.out.println("Nom del mòdul professional: " + rs.getString(2));
                System.out.println("Nom del professor: " + rs.getString(3));
                System.out.println("Cognom del professor: " + rs.getString(4));
                System.out.println("------------------------------------------------");
            }

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
