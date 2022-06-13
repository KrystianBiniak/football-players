package pl.biniak.footballplayers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.biniak.footballplayers.entity.FootballPlayer;
import pl.biniak.footballplayers.manager.FootballPlayerManager;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class FootballPlayersApi {

  private FootballPlayerManager footballPlayers;

  @Autowired
  public FootballPlayersApi(FootballPlayerManager footballPlayerManager) {
    this.footballPlayers = footballPlayerManager;
  }

  @GetMapping("/all")
  public Iterable<FootballPlayer> getAllPlayers() {
    return footballPlayers.findAll();
  }

  @GetMapping
  public List<FootballPlayer> getActivePlayers(@RequestParam boolean active) {
    return footballPlayers.findByActivity(active);
  }

  @PostMapping
  public FootballPlayer addPlayer(@RequestBody FootballPlayer footballPlayer) {
    return footballPlayers.savePlayer(footballPlayer);
  }

  @PutMapping
  public void updatePlayer(@RequestBody FootballPlayer footballPlayer) {
    //footballPlayers.deletePlayer(footballPlayer.get);
    footballPlayers.savePlayer(footballPlayer);
  }

  @DeleteMapping
  public void deletePlayer(@RequestParam Long id) {
    footballPlayers.deletePlayer(id);
  }

}
