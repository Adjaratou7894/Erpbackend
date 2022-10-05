
package com.example.erpbackend.Importation;


import com.example.erpbackend.Model.Postulant;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * la classe permettant d'uploader un fichier excel et de lire son contenu et le
 * mettre également dans une liste de type postulant et retourner cette liste
 * */

public class ConfigExcel {

    public List<Postulant> excelImport(MultipartFile file)
    {
        //definition d'une liste vide de type postulant pour stocker les postulant trié
        List <Postulant> postulantListe = new ArrayList<>();


        /*
         * les differentes variables qui seront utilisées pour stocker les donnée du fichier
         * */

        String nom_postulant="";
        String prenom_postulant="";
        String numero_postulant="";
        String email_postulant="";
        String genre_postulant = "";

        //String excelFilePath = "C:\\Users\\mkkeita\\Desktop\\projects\\apiFreeTirag\\file1.xlsx";

        //l'heure de debut de l'importation
        long start = System.currentTimeMillis();

        try {
            //FileInputStream inputStrean = new FileInputStream(file.getInputStream());

            /*
             Workbook permet de modéliser un fichier Excel
             Sheet(feuille) , Row(ligne)  et Cell(cellule) permettent de modeliser les éléments d'un fichier Excel
             Les classes utilisées pour le nouveau format xlsx XSSFWorkbook , XSSFSheet , XSSFRow et XSSFCell .
            * */

            //ouverture du fichier excel uploader
            Workbook workbook = new XSSFWorkbook(file.getInputStream());

            //permet de recuperer la première feuille du fichier
            Sheet firstSheet=workbook.getSheetAt(0);

            //on definit la liste rowIterator de type Row qui va contenir toutes les lignes du fichier
            Iterator<Row> rowIterator=firstSheet.iterator();

            //on part sur la ligne suivante
            rowIterator.next();

            //on parcours les lignes de la feuille dans cette boucle, à chaque tours du boucle on part au projet suivant
            // la méthode hasNext() renvoie true si l'itérateur a plus d'éléments.
            while (rowIterator.hasNext()){

                //la méthode next() renvoie l'élément suivant et passe également à l'élément suivant.
                Row nextRow = rowIterator.next();

                //renvoie toutes les cellules, y compris les cellules vides
                Iterator<Cell> cellIterator = nextRow.cellIterator();


                //on parcours les cellules
                // la méthode hasNext() renvoie true si l'itérateur a plus d'éléments.
                while (cellIterator.hasNext()){


                    //la méthode next() renvoie la cellule suivant et passe également à la cellule suivante.
                    Cell nextCell=cellIterator.next();

                    //Renvoie l'index de base zéro pour le nom de colonne donné, ou -1 si la colonne n'existe pas.
                    int columnIndex = nextCell.getColumnIndex();

                    //verifie les valeurs de columnIndex
                    switch (columnIndex){

                        //si ça vaut 0
                        case 0:
                            //On recuoere le nom du postulant
                            nom_postulant=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(nom_postulant);
                            break;
                        //si ça vaut 1
                        case 1:
                            //On recuoere le prenom du postulant
                            prenom_postulant=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(prenom_postulant);
                            break;

                        //si ça vaut 2
                        case 2:
                            //On recuoere le numero du postulant
                            numero_postulant=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(numero_postulant);
                            break;

                        //si ça vaut 3
                        case 3:
                            //On recuoere le email du postulant
                            email_postulant=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(email_postulant);
                            break;

                        //si ça vaut 3
                        case 4:
                            //On recupère le email du postulant
                            genre_postulant=nextCell.getStringCellValue();

                            //on affiche cette valeur dans la console
                            System.out.println(genre_postulant);
                            break;
                    }
                    //postulantList.add(new Postulant(nom_postulant, prenom_postulant, numero_postulant, email_postulant));
                }
                Postulant postulants = new Postulant(nom_postulant, prenom_postulant, numero_postulant, email_postulant, genre_postulant);
                postulantListe.add(postulants);

            }

            //permet de fermer le fichier
            workbook.close();

            //l'heure de fin de limportation
            long end = System.currentTimeMillis();

            //affichage de l'heure du debut  et fin de l'importation
            System.out.printf("Import done in %d ms\n", (end - start));

        }
        //lorsqu'il y a une exception comme le fichier not found
        catch (Exception e) {
            e.printStackTrace();
        }

        return  postulantListe;//retourne de la liste des postulant importé
    }
}
