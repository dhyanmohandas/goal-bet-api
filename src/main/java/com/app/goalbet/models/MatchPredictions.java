package com.app.goalbet.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchPredictions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-13T23:25:56.326263500+05:30[Asia/Calcutta]")
public class MatchPredictions   {
  @JsonProperty("match")
  private Object match = null;

  @JsonProperty("predictions")
  @Valid
  private List<Object> predictions = null;

  public MatchPredictions match(Object match) {
    this.match = match;
    return this;
  }

  /**
   * Get match
   * @return match
  **/
  @ApiModelProperty(value = "")
  
    public Object getMatch() {
    return match;
  }

  public void setMatch(Object match) {
    this.match = match;
  }

  public MatchPredictions predictions(List<Object> predictions) {
    this.predictions = predictions;
    return this;
  }

  public MatchPredictions addPredictionsItem(Object predictionsItem) {
    if (this.predictions == null) {
      this.predictions = new ArrayList<Object>();
    }
    this.predictions.add(predictionsItem);
    return this;
  }

  /**
   * Get predictions
   * @return predictions
  **/
  @ApiModelProperty(value = "")
  
    public List<Object> getPredictions() {
    return predictions;
  }

  public void setPredictions(List<Object> predictions) {
    this.predictions = predictions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchPredictions matchPredictions = (MatchPredictions) o;
    return Objects.equals(this.match, matchPredictions.match) &&
        Objects.equals(this.predictions, matchPredictions.predictions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(match, predictions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchPredictions {\n");
    
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    predictions: ").append(toIndentedString(predictions)).append("\n");
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
