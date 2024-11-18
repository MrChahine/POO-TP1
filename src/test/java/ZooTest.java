import org.example.model.LimiteVisiteurException;
import org.example.model.TypeAnimal;
import org.example.model.Zoo;

public class ZooTest {
    public static void main(String[] args) {
            // Création du zoo
            Zoo zoo = new Zoo();

            Exception exc = null;

            // Ajout d'un secteur pour les chiens
            zoo.ajouterSecteur(TypeAnimal.CHIEN);

            // Ajouter des visiteurs jusqu'à la limite
            for (int i = 0; i < 15; i++) {
                try {
                    zoo.nouveauVisiteur(); // Cela fonctionne tant qu'il y a de la place
                } catch (LimiteVisiteurException e) {
                    exc = e;
                }
            }

            // Essayer d'ajouter un autre visiteur, ce qui devrait lancer une exception
        try {
            zoo.nouveauVisiteur(); // Doit lever LimiteVisiteurException
        } catch (LimiteVisiteurException e) {
            exc = e;
        }
        assert exc != null;

        System.out.println("Test : "+exc);

    }
}
