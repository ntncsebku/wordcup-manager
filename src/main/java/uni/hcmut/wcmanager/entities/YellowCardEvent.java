package uni.hcmut.wcmanager.entities;

public class YellowCardEvent extends CardEvent {
    public YellowCardEvent(Match match, PlayerInMatch actor, int at) {
        super(match, actor, at);
    }

    @Override
    public void handle() {
        actor.incrementYellowCard();

        TeamInMatch playersTeam = actor.getTeamInMatch();
        playersTeam.incrementYellowCardCount();

        // If this player has received 2 yellow cards
        if (actor.getYellowCardCount() == 2) {
            playersTeam.sendPlayerOff(actor);
            afterRedCardEvent();
        }
    }
}
