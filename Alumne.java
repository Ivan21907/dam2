package dam2;

import java.sql.*;
import java.util.Scanner;

enum curs
{
    ESO, Batxillerat, Cicles_Formatius;
}

public class Alumne
{
    //Atributs de la classe
    private int id;
    private String nom;
    private String cognoms;
    private Date data_naixement;
    private String curs;
    private String[] nom_Projenitors;

    //constructors de la classe

    public Alumne(int id, String nom, String cognoms, Date data_naixement, String curs, String[] nom_Projenitors)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.data_naixement = data_naixement;
        this.curs = curs;
        this.nom_Projenitors = nom_Projenitors;
    }
    public Alumne(String nom, String cognoms, Date data_naixement, String curs, String[] nom_Projenitors)
    {
        this.nom = nom;
        this.cognoms = cognoms;
        this.data_naixement = data_naixement;
        this.curs = curs;
        this.nom_Projenitors = nom_Projenitors;
    }

    public Alumne(String nom, String cognoms)
    {
        this.nom = nom;
        this.cognoms = cognoms;

    }

    public Alumne(int id, String nom, String cognoms)
    {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;

    }

    public Alumne(int id)
    {
        this.id = id;

    }

    /**
     * Funcio que afegeix un alumne a la base de dades
     */
    public void addDam2()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            //fem la connexio
            Connection conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Connexio", "postgres", "ivan2001");

            //preparem la sentencia
            PreparedStatement pm = conect.prepareStatement("INSERT INTO alumnes (nom, cognoms, datanaixement, curs, NomProgenitor) " +
                    "VALUES (?, ?, ?, ?::\"curs\", ?)");

            //omplim els camps de la sentencia
            pm.setString(1, this.nom);
            pm.setString(2, this.cognoms);
            pm.setDate(3, this.data_naixement);
            pm.setString(4, this.curs);
            pm.setArray(5, conect.createArrayOf("text", this.nom_Projenitors));

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
     * Funcio que elimina un alumne de la base de dades
     */
    public void deleteDam2()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            //fem la connexio
            Connection conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Connexio", "postgres", "ivan2001");

            //preparem la sentencia
            PreparedStatement pm = conect.prepareStatement("DELETE FROM alumnes WHERE id = ?");

            //omplim els camps de la sentencia
            pm.setInt(1, this.id);

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
     * Funcio que modifica un alumne de la base de dades
     */
    public void updateDam2()
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            //fem la connexio
            Connection conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Connexio", "postgres", "ivan2001");

            //preparem la sentencia
            PreparedStatement pm = conect.prepareStatement("UPDATE alumnes SET nom = ?, cognoms = ?, datanaixement = ?, curs = ?::\"curs\", NomProgenitor = ? WHERE id = ?");

            //omplim els camps de la sentencia
            pm.setString(1, this.nom);
            pm.setString(2, this.cognoms);
            pm.setDate(3, (java.sql.Date) this.data_naixement);
            pm.setString(4, this.curs);
            pm.setArray(5, conect.createArrayOf("text", this.nom_Projenitors));
            pm.setInt(6, this.id);

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
     * Funcio que mostra tots els alumnes de la base de dades
     */
    public void readDam2()
    {
        try
        {
            Connection conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Connexio", "postgres", "ivan2001");

            PreparedStatement pm = conect.prepareStatement("SELECT * FROM alumnes");

            ResultSet rs = pm.executeQuery();

            while(rs.next())
            {
                System.out.println("ID: " + rs.getInt("id") +
                        " Nom: " + rs.getString("nom") +
                        " Cognoms: " + rs.getString("cognoms") +
                        " Data de naixement: " + rs.getDate("datanaixement") +
                        " Curs: " + rs.getString("curs") +
                        " Nom dels projenitors: " + rs.getString("NomProgenitor"));
            }

            pm.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
