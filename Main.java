import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el mapa de Pokémon usando el Factory
        System.out.println("Seleccione el tipo de Map a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");

        int option = 1;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, se usará HashMap por defecto.");
        }
        scanner.nextLine(); // Consumir salto de línea

        Map<String, Pokemon> pokemonMap = PokemonMapFactory.createMap(option);

        // Agregamos Pokémon de prueba
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "Electric", null, 35, 55, 40, 50, 50, false, Arrays.asList("Static", "Lightning Rod")));
        pokemonMap.put("Charizard", new Pokemon("Charizard", "Fire", "Flying", 78, 84, 78, 109, 85, false, Arrays.asList("Blaze", "Solar Power")));

        PokemonManager manager = new PokemonManager(pokemonMap);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1) Agregar Pokémon a la colección");
            System.out.println("2) Mostrar datos de un Pokémon");
            System.out.println("3) Mostrar colección ordenada por tipo");
            System.out.println("4) Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5) Mostrar Pokémon por habilidad");
            System.out.println("6) Salir");

            System.out.print("Seleccione una opción: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String name = scanner.nextLine();
                    manager.addPokemonToCollection(name);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon a mostrar: ");
                    String pokemonName = scanner.nextLine();
                    manager.showPokemonData(pokemonName);
                    break;
                case 3:
                    manager.showUserCollectionOrderedByType();
                    break;
                case 4:
                    manager.showAllPokemonOrderedByType();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = scanner.nextLine();
                    manager.showPokemonByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
