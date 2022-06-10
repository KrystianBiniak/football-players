package pl.biniak.footballplayers.api;

import org.springframework.web.bind.annotation.*;
import pl.biniak.footballplayers.base.FootballPlayer;
import pl.biniak.footballplayers.enums.Nationality;
import pl.biniak.footballplayers.enums.PositionOnPitch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

  @GetMapping
  public Stream<FootballPlayer> getActivePlayers(@RequestParam boolean active) {
    return footballPlayers.stream().filter(FootballPlayer -> FootballPlayer.isActive() == active);
  }

  @PostMapping
  public boolean addPlayer(@RequestBody FootballPlayer footballPlayer) {
    return footballPlayers.add(footballPlayer);
  }

  @PutMapping
  public boolean updatePlayer(@RequestBody FootballPlayer footballPlayer) {
    footballPlayers.removeIf(FootballPlayer -> FootballPlayer.getSurname().equals(footballPlayer.getSurname()));
    return footballPlayers.add(footballPlayer);
  }

  @DeleteMapping
  public boolean deletePlayer(@RequestParam String surname) {
    return footballPlayers.removeIf(FootballPlayer -> FootballPlayer.getSurname().equals(surname));
  }

}
