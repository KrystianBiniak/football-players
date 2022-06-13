package pl.biniak.footballplayers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.biniak.footballplayers.entity.FootballPlayer;
import pl.biniak.footballplayers.enums.Nationality;
import pl.biniak.footballplayers.enums.PositionOnPitch;
import pl.biniak.footballplayers.repository.FootballPlayerRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FootballPlayerManager {

  private FootballPlayerRepo footballPlayerRepo;

  @Autowired
  public FootballPlayerManager(FootballPlayerRepo footballPlayerRepo) {
    this.footballPlayerRepo = footballPlayerRepo;
  }

  public List<FootballPlayer> findByActivity(boolean active) {
    Iterable<FootballPlayer> players = findAll();
    List<FootballPlayer> selectedPlayers = new ArrayList<>();
    for (FootballPlayer footballPlayer : players) {
      if (footballPlayer.isActive() == active) {
        selectedPlayers.add(footballPlayer);
      }
    }
    return selectedPlayers;
  }

  public Iterable<FootballPlayer> findAll() {
    return footballPlayerRepo.findAll();
  }

  public FootballPlayer savePlayer(FootballPlayer footballPlayer) {
    return footballPlayerRepo.save(footballPlayer);
  }

  public void deletePlayer(Long id) {
    footballPlayerRepo.deleteById(id);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void fillDB() {
    savePlayer(new FootballPlayer(1L,
        "Zinedine",
        "Zidane",
        185L,
        PositionOnPitch.MIDFIELDER,
        Nationality.FRANCE,
        130L,
        LocalDate.of(1972, 6, 23),
        false));
    savePlayer(new FootballPlayer(2L,
        "Lionel",
        "Messi",
        169L,
        PositionOnPitch.STRIKER,
        Nationality.ARGENTINA,
        130L,
        LocalDate.of(1987, 6, 24),
        true));
  }

}
