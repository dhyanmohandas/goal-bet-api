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
 * PredictionDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-13T17:03:36.359386+05:30[Asia/Calcutta]")
public class PredictionDetails   {
  @JsonProperty("matchId")
  private String matchId = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("teamGoals1")
  private Integer teamGoals1 = null;

  @JsonProperty("teamGoals2")
  private Integer teamGoals2 = null;

  public PredictionDetails matchId(String matchId) {
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

  public PredictionDetails userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  
    public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PredictionDetails teamGoals1(Integer teamGoals1) {
    this.teamGoals1 = teamGoals1;
    return this;
  }

  /**
   * Get teamGoals1
   * @return teamGoals1
  **/
  @ApiModelProperty(value = "")
  
    public Integer getTeamGoals1() {
    return teamGoals1;
  }

  public void setTeamGoals1(Integer teamGoals1) {
    this.teamGoals1 = teamGoals1;
  }

  public PredictionDetails teamGoals2(Integer teamGoals2) {
    this.teamGoals2 = teamGoals2;
    return this;
  }

  /**
   * Get teamGoals2
   * @return teamGoals2
  **/
  @ApiModelProperty(value = "")
  
    public Integer getTeamGoals2() {
    return teamGoals2;
  }

  public void setTeamGoals2(Integer teamGoals2) {
    this.teamGoals2 = teamGoals2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PredictionDetails predictionDetails = (PredictionDetails) o;
    return Objects.equals(this.matchId, predictionDetails.matchId) &&
        Objects.equals(this.userId, predictionDetails.userId) &&
        Objects.equals(this.teamGoals1, predictionDetails.teamGoals1) &&
        Objects.equals(this.teamGoals2, predictionDetails.teamGoals2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, userId, teamGoals1, teamGoals2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PredictionDetails {\n");
    
    sb.append("    matchId: ").append(toIndentedString(matchId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    teamGoals1: ").append(toIndentedString(teamGoals1)).append("\n");
    sb.append("    teamGoals2: ").append(toIndentedString(teamGoals2)).append("\n");
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
