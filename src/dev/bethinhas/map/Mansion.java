package dev.bethinhas.map;

import dev.bethinhas.item.Food;
import dev.bethinhas.item.Key;
import dev.bethinhas.phantom.FatPhantom;
import dev.bethinhas.phantom.FighterPhantom;
import dev.bethinhas.phantom.IntelligentPhantom;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Mansion {
    private Set<Location> locations;
    private Location initialLocation;

    public Mansion() {
        this.locations = new HashSet<>();

        this.init();
    }

    public void init() {
        if (initialLocation != null) return;

        this.generateFirstFloor();
    }

    private void generateFirstFloor() {
        // Cômodos
        var HW001 = new Hallway("Corredor 1", "HW-001", "no corredor principal da mansão");
        var HW002 = new Hallway("Corredor 2", "HW-002", "");
        var HW003 = new Hallway("Corredor 3", "HW-003", "");
        var RO001 = new Room("Quarto 1", "RO-001", "em um quarto qualquer");
        var RO002 = new Room("Quarto 2", "RO-002", "");
        var RO003 = new Room("Quarto 3", "RO-003", "");
        var KT001 = new Kitchen("Cozinha", "KI-001", "");
        var LV001 = new LivingRoom("Sala", "LR-001", "em uma sala bem grande");
        var BT001 = new BathRoom("Banheiro", "BR-001", "");
        var ST001 = new Stair("Escada", "ST-001", "de frente a uma escada", true);

        HW001.addExit(LV001.getLocation(), LV001);
        HW001.addExit(RO001.getLocation(), RO001);
        HW001.addExit(HW002.getLocation(), HW002);

        HW002.addExit(LV001.getLocation(), LV001);
        HW002.addExit(RO002.getLocation(), RO002);
        HW002.addExit(KT001.getLocation(), KT001);
        HW002.addExit(HW001.getLocation(), HW001);

        HW003.addExit(RO003.getLocation(), RO003);
        HW003.addExit(ST001.getLocation(), ST001);

        LV001.addExit(BT001.getLocation(), BT001);

        // Itens
        var FO001 = new Food("Alface", "Um alface bem verdinho.");

        var KEY001 = new Key("Chave", "Uma chave como qualquer outra", ST001);

        KT001.addItem(FO001);
        LV001.addItem(KEY001);

        // Fantasmas
        var PH001 = new FatPhantom(
                "Mabin Joo",
                "{player} entra em {location} e escuta uma voz dizendo:  \\\"Vou te comer, vou te comer, vou te comer...\\\".\"",
                "Você pode capturar esse fantasma lhe dando comida.",
                List.of(FO001.getName())
        );

        var PH002 = new IntelligentPhantom(
                "",
                "{player} entra {location} e escuta uma voz dizendo:  \\\"Não é a força que me mantém aqui, é o que vocês nunca conseguiram entender...\\\".\"",
                "Você pode capturar esse fantasma resolvendo um enigma.",
                "Qual a cor do cavalo branco de Napoleão?",
                List.of("Branco", "branco")
        );

        var PH003 = new FighterPhantom(
                "",
                "{player} entra {location} e escuta uma voz dizendo:  \"A luta é tudo o que restou de mim...\".",
                "Você pode capturar esse fantasma com um espelho.",
                20
        );

        KT001.setPhantom(PH001);
        RO001.setPhantom(PH002);
        LV001.setPhantom(PH003);

        this.locations.addAll(List.of(HW001, HW002, HW003, RO001, RO002, RO003, KT001, LV001, BT001, ST001));

        initialLocation = HW001;
    }

    private void generateSecondFloor(Stair firstFloorStairs) {
    }

    private void generateThirdFloor(Stair secondFloorStairs) {
    }

    public Location getInitialLocation() {
        return initialLocation;
    }

    public Set<Location> getLocations() {
        return locations;
    }
}
