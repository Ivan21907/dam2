package dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2", "root", "ivan2001");

        PreparedStatement pm = conect.prepareStatement("INSERT INTO modul_professional (id, nom, id_professor) VALUES (?, ?, ?)");

        System.out.println("Introdueix l'id del modul professional: ");
        int idModul = sc.nextInt();

        System.out.println("Introdueix el nom del modul professional: ");
        String nomModul = sc.nextLine();

        System.out.println("Introdueix l'id del professor: ");
        int idProfe = sc.nextInt();

        pm.setInt(1, idModul);
        pm.setString(2, nomModul);
        pm.setInt(3, idProfe);

        pm.executeUpdate();
    }

}
