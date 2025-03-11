import java.util.*;

public class PokemonMapFactory {
    public static Map<String, Pokemon> createMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                System.out.println("Opción no válida, se usará HashMap por defecto.");
                return new HashMap<>();
        }
    }
}
