package pl.biniak.footballplayers.entity;

import pl.biniak.footballplayers.enums.Nationality;
import pl.biniak.footballplayers.enums.PositionOnPitch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FootballPlayer {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  private String name;
  private String surname;
  private Long cmHeight;
  private PositionOnPitch positionOnPitch;
  private Nationality nationality;
  private Long goalsScored;
  private LocalDate bornIn;
  private boolean active;


  public FootballPlayer() {
  }

  public FootballPlayer(Long id, String name, String surname, Long cmHeight, PositionOnPitch positionOnPitch, Nationality nationality, Long goalsScored, LocalDate bornIn, boolean active) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.cmHeight = cmHeight;
    this.positionOnPitch = positionOnPitch;
    this.nationality = nationality;
    this.goalsScored = goalsScored;
    this.bornIn = bornIn;
    this.active = active;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCmHeight() {
    return cmHeight;
  }

  public void setCmHeight(Long cmHeight) {
    this.cmHeight = cmHeight;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public PositionOnPitch getPositionOnPitch() {
    return positionOnPitch;
  }

  public void setPositionOnPitch(PositionOnPitch positionOnPitch) {
    this.positionOnPitch = positionOnPitch;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public void setNationality(Nationality nationality) {
    this.nationality = nationality;
  }

  public Long getGoalsScored() {
    return goalsScored;
  }

  public void setGoalsScored(Long goalsScored) {
    this.goalsScored = goalsScored;
  }

  public LocalDate getBornIn() {
    return bornIn;
  }

  public void setBornIn(LocalDate bornIn) {
    this.bornIn = bornIn;
  }
}
