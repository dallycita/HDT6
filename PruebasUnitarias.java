import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class PokemonManagerTest {
    private PokemonManager manager;
    private Map<String, Pokemon> pokemonMap;

    @BeforeEach
    void setUp() {
        pokemonMap = new HashMap<>();
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "Electric", null, 35, 55, 40, 50, false, Arrays.asList("Static", "Lightning Rod")));
        pokemonMap.put("Charizard", new Pokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, false, Arrays.asList("Blaze", "Solar Power")));

        manager = new PokemonManager(pokemonMap);
    }

    @Test
    void testAddPokemonToCollection() {
        manager.addPokemonToCollection("Pikachu");
        manager.addPokemonToCollection("Pikachu"); // Intento de agregarlo dos veces

        assertEquals(1, manager.userCollection.size(), "El Pokémon debería agregarse solo una vez.");
        assertEquals("Pikachu", manager.userCollection.get(0).getName(), "El Pokémon en la colección debería ser Pikachu.");
    }

    @Test
    void testShowPokemonByAbility() {
        // Redirigir la salida estándar para capturar el output del método
        String ability = "Static";
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream()));
        manager.showPokemonByAbility(ability);
        String output = System.out.toString().trim();

        assertTrue(output.contains("Pikachu"), "Debería mostrarse Pikachu en la salida.");
    }
}
