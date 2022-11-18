package dam2;

import java.sql.Date;

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
    private curs curs;
    private String[] nom_Projenitors;

    //constructors de la classe
    public Alumne(String nom, String cognoms, Date data_naixement, curs curs, String[] nom_Projenitors)
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
        this.nom = nom;
        this.cognoms = cognoms;

    }



}
