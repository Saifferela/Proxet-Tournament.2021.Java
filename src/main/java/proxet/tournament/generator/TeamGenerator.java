package proxet.tournament.generator;

import proxet.tournament.generator.dto.Player;
import proxet.tournament.generator.dto.TeamGeneratorResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TeamGenerator {

    private List<Player> readFilePlayer(String filePath) {

        try {
            Path path = Paths.get(filePath);
            return Files.lines(path)
                    .map(line -> line.split("\t"))
                    .map(lines -> new Player(
                            lines[0], // nickname.
                            Integer.parseInt(lines[1]), // timeWait.
                            Integer.parseInt(lines[2]))).sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return Collections.emptyList();
    }

    public TeamGeneratorResult generateTeams(String filePath) {
        List<Player> players = readFilePlayer(filePath);

        TeamSeparator redTeam = new TeamSeparator();
        TeamSeparator blueTeam = new TeamSeparator();

        for (Player player : players) {
            boolean isAddedToTeam = redTeam.addPlayerInTeam(player);

            if (!isAddedToTeam)
                blueTeam.addPlayerInTeam(player);
            if (redTeam.isFull() && blueTeam.isFull()) {
                break;
            }
        }
        return new TeamGeneratorResult(redTeam.giveTeam(), blueTeam.giveTeam());
    }
}