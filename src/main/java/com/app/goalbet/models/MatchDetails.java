package com.app.goalbet.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-12T21:53:00.279307600+05:30[Asia/Calcutta]")
public class MatchDetails   {
  @JsonProperty("matchId")
  private String matchId = null;

  @JsonProperty("team1")
  private Integer team1 = null;

  @JsonProperty("team2")
  private Integer team2 = null;

  @JsonProperty("time")
  private String time = null;

  @JsonProperty("stadium")
  private String stadium = null;

  public MatchDetails matchId(String matchId) {
    this.matchId = matchId;
    return this;
  }

  /**
   * Get matchId
   * @return matchId
  **/
  @ApiModelProperty(value = "")
  
    public String getMatchId() {
    return matchId;
  }

  public void setMatchId(String matchId) {
    this.matchId = matchId;
  }

  public MatchDetails team1(Integer team1) {
    this.team1 = team1;
    return this;
  }

  /**
   * Get team1
   * @return team1
  **/
  @ApiModelProperty(value = "")
  
    public Integer getTeam1() {
    return team1;
  }

  public void setTeam1(Integer team1) {
    this.team1 = team1;
  }

  public MatchDetails team2(Integer team2) {
    this.team2 = team2;
    return this;
  }

  /**
   * Get team2
   * @return team2
  **/
  @ApiModelProperty(value = "")
  
    public Integer getTeam2() {
    return team2;
  }

  public void setTeam2(Integer team2) {
    this.team2 = team2;
  }

  public MatchDetails time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")
  
    public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public MatchDetails stadium(String stadium) {
    this.stadium = stadium;
    return this;
  }

  /**
   * Get stadium
   * @return stadium
  **/
  @ApiModelProperty(value = "")
  
    public String getStadium() {
    return stadium;
  }

  public void setStadium(String stadium) {
    this.stadium = stadium;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchDetails matchDetails = (MatchDetails) o;
    return Objects.equals(this.matchId, matchDetails.matchId) &&
        Objects.equals(this.team1, matchDetails.team1) &&
        Objects.equals(this.team2, matchDetails.team2) &&
        Objects.equals(this.time, matchDetails.time) &&
        Objects.equals(this.stadium, matchDetails.stadium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, team1, team2, time, stadium);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchDetails {\n");
    
    sb.append("    matchId: ").append(toIndentedString(matchId)).append("\n");
    sb.append("    team1: ").append(toIndentedString(team1)).append("\n");
    sb.append("    team2: ").append(toIndentedString(team2)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    stadium: ").append(toIndentedString(stadium)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
