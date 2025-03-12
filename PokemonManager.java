import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private List<Pokemon> userCollection;

    public PokemonManager(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.userCollection = new ArrayList<>();
    }

    public void addPokemonToCollection(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: El Pokémon no existe en la base de datos.");
            return;
        }
        Pokemon pokemon = pokemonMap.get(name);
        if (userCollection.contains(pokemon)) {
            System.out.println("El Pokémon ya está en tu colección.");
        } else {
            userCollection.add(pokemon);
            System.out.println("Pokémon agregado a tu colección: " + name);
        }
    }

    public void showPokemonData(String name) {
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    public void showUserCollectionOrderedByType() {
        userCollection.sort(Comparator.comparing(Pokemon::getType1).thenComparing(Pokemon::getName));
        for (Pokemon pokemon : userCollection) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showAllPokemonOrderedByType() {
        List<Pokemon> allPokemon = new ArrayList<>(pokemonMap.values());
        allPokemon.sort(Comparator.comparing(Pokemon::getType1).thenComparing(Pokemon::getName));
        for (Pokemon pokemon : allPokemon) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    public void showPokemonByAbility(String ability) {
        boolean found = false;
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().stream().anyMatch(a -> a.equalsIgnoreCase(ability))) {
                System.out.println(pokemon.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron Pokémon con la habilidad: " + ability);
        }
    }
}

