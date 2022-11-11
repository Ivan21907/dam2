package dam2;

import java.sql.*;
import java.util.Scanner;

public class ModulProfessional
{
    private int id;
    private String nom;
    private int id_professor;

    public ModulProfessional(int id, String nom, int id_professor)
    {
        this.id = id;
        this.nom = nom;
        this.id_professor = id_professor;
    }

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

    public void addDam2() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("INSERT INTO mòdul_professional (nom, id_professor) VALUES (?, ?)");

            /*System.out.println("Introdueix l'id del modul professional: ");
            int idModul = sc.nextInt();

            System.out.println("Introdueix el nom del modul professional: ");
            String nomModul = sc.nextLine();

            System.out.println("Introdueix l'id del professor: ");
            int idProfe = sc.nextInt();*/

            pm.setString(1, this.nom);
            pm.setInt(2, this.id_professor);

            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void updateDam2()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("UPDATE mòdul_professional SET nom = ?, id_professor = ? WHERE idmòdul_Professional = ?");

            /*System.out.println("Introdueix l'id del modul professional a actualitzar: ");
            int idModul = sc.nextInt();

            System.out.println("Introdueix el nou nom del modul professional: ");
            String nomModul = sc.nextLine();

            System.out.println("Introdueix l'id del nou professor: ");
            int idProfe = sc.nextInt();*/

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

    public void deleteDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("DELETE FROM mòdul_professional WHERE idmòdul_Professional = ?");

            /*System.out.println("Introdueix l'id del modul professional a eliminar: ");
            int idModul = sc.nextInt();*/

            pm.setInt(1, this.id);

            pm.executeUpdate();

            pm.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

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
