package proxet.tournament.generator;

import proxet.tournament.generator.dto.Player;

import java.util.ArrayList;
import java.util.List;

public class TeamSeparator {

    private static final int NUMBER_PLAYERS_TEAM = 9;
    private static final int NUMBER_TYPES_VEHICLE = 3;
    private final List<Player> oneVehicle = new ArrayList<>();
    private final List<Player> twoVehicle = new ArrayList<>();
    private final List<Player> threeVehicle = new ArrayList<>();
    private final List<Player> teamList = new ArrayList<>();

    public boolean addPlayerInTeam(Player player) {
        if (oneVehicle.size() < NUMBER_TYPES_VEHICLE && player.getVehicleType() == 1) {
            return oneVehicle.add(new Player(player.getNickname(), player.getVehicleType()));
        }
        if (twoVehicle.size() < NUMBER_TYPES_VEHICLE && player.getVehicleType() == 2) {
            return twoVehicle.add(new Player(player.getNickname(), player.getVehicleType()));
        }
        if (threeVehicle.size() < NUMBER_TYPES_VEHICLE && player.getVehicleType() == 3) {
            return threeVehicle.add(new Player(player.getNickname(), player.getVehicleType()));
        }
        return false;
    }

    public List<Player> giveTeam() {
        if (teamList.size() < 1) {
            teamList.addAll(oneVehicle);
            teamList.addAll(twoVehicle);
            teamList.addAll(threeVehicle);
        }
        return teamList;
    }

    public boolean isFull() {
        return teamList.size() > NUMBER_PLAYERS_TEAM;
    }
}