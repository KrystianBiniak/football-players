package pl.biniak.footballplayers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.biniak.footballplayers.base.FootballPlayer;
import pl.biniak.footballplayers.enums.Nationality;
import pl.biniak.footballplayers.enums.PositionOnPitch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class FootballPlayersApi {

  private List<FootballPlayer> footballPlayers;

  public FootballPlayersApi() {
    footballPlayers = new ArrayList<>();
    footballPlayers.add(new FootballPlayer("Lionel",
        "Messi",
        169L,
        PositionOnPitch.STRIKER,
        Nationality.ARGENTINA,
        130L,
        LocalDate.of(1987, 6, 24),
        true));
    footballPlayers.add(new FootballPlayer("Zinedine",
        "Zidane",
        185L,
        PositionOnPitch.MIDFIELDER,
        Nationality.FRANCE,
        130L,
        LocalDate.of(1972, 6, 23),
        false));
  }

  @GetMapping("/all")
  public List<FootballPlayer> getAllPlayers() {
    return footballPlayers;
  }

  @GetMapping("/active")
  public List<FootballPlayer> getActivePlayers(@RequestParam boolean active) {
    return footballPlayers.stream().
        filter(FootballPlayer -> FootballPlayer.isActive() == active).toList();
  }

}
