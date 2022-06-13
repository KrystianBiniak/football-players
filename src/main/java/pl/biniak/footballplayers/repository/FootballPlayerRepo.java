package pl.biniak.footballplayers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.biniak.footballplayers.entity.FootballPlayer;

@Repository
public interface FootballPlayerRepo extends CrudRepository<FootballPlayer, Long> {
}
