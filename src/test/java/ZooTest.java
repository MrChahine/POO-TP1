import org.example.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ZooTest {
    @Test
    public void testLimiteVisiteursException() throws LimiteVisiteurException {
        Zoo zoo = new Zoo(); // Limite de 2 visiteurs par secteur
        Exception exp = null;

        try{
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();
            zoo.nombreAnimaux();
        }catch (Exception e){
            exp = e;
        }

        Assert.assertNotNull(exp);
    }

    @Test
    public void AnimalDansMauvaisSecteur() throws LimiteVisiteurException {
        Secteur secteur = new Secteur(TypeAnimal.CHAT);
        Exception exp = null;
        Animal chien = new Animal("choupi",TypeAnimal.CHIEN);
        try {
            secteur.ajouterAnimal(chien);
        }catch (Exception e){
            exp = e;
        }
        Assert.assertNotNull(exp);
        System.out.println(exp);}
}
