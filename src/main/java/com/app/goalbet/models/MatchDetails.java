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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-06T12:05:41.300588700+05:30[Asia/Calcutta]")
public class MatchDetails   {
  @JsonProperty("matchId")
  private Integer matchId = null;

  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("goalDetails")
  private String goalDetails = null;

  public MatchDetails matchId(Integer matchId) {
    this.matchId = matchId;
    return this;
  }

  /**
   * Get matchId
   * @return matchId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMatchId() {
    return matchId;
  }

  public void setMatchId(Integer matchId) {
    this.matchId = matchId;
  }

  public MatchDetails userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public MatchDetails goalDetails(String goalDetails) {
    this.goalDetails = goalDetails;
    return this;
  }

  /**
   * Get goalDetails
   * @return goalDetails
  **/
  @ApiModelProperty(value = "")
  
    public String getGoalDetails() {
    return goalDetails;
  }

  public void setGoalDetails(String goalDetails) {
    this.goalDetails = goalDetails;
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
        Objects.equals(this.userId, matchDetails.userId) &&
        Objects.equals(this.goalDetails, matchDetails.goalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, userId, goalDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchDetails {\n");
    
    sb.append("    matchId: ").append(toIndentedString(matchId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    goalDetails: ").append(toIndentedString(goalDetails)).append("\n");
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
