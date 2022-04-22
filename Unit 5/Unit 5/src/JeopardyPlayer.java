public class JeopardyPlayer {
    private String name;
    private int points;
    private int playerNumber;

    public JeopardyPlayer(String name, int points, int playerNumber) {
        this.name = name;
        this.points = points;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }

		public void decrementPoints(int points) {
				this.points -= points;
		}

    public int getPlayerNumber() {
        return playerNumber;
    }

}