package proxet.tournament.generator.dto;

public class Player implements Comparable<Player> {

    private final String nickname;
    private final Integer vehicleType;
    private Integer timeWait;

    public Player(String nickname, Integer timeWait, Integer vehicleType) {
        this.nickname = nickname;
        this.timeWait = timeWait;
        this.vehicleType = vehicleType;
    }

    public Player(String nickname, Integer vehicleType) {
        this.nickname = nickname;
        this.vehicleType = vehicleType;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    @Override
    public int compareTo(Player player) {
        return player.timeWait.compareTo(this.timeWait);
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}