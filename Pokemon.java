import java.util.List;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private boolean legendary;
    private List<String> abilities;

    public Pokemon(String name, String type1, String type2, int hp, int attack, int defense,
                   int speed, boolean legendary, List<String> abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.legendary = legendary;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public String getAbilitiesAsString() {
        return String.join(", ", abilities);
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " | Tipo1: " + type1 + " | Tipo2: " + (type2 != null ? type2 : "Ninguno") +
               " | HP: " + hp + " | Ataque: " + attack + " | Defensa: " + defense +
               " | Velocidad: " + speed + " | Legendario: " + (legendary ? "Sí" : "No") +
               " | Habilidades: " + getAbilitiesAsString();
    }
}

