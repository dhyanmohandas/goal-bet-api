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
 * ApiResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-13T18:30:24.818981300+05:30[Asia/Calcutta]")
public class ApiResult   {
  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("data")
  @Valid
  private List<Object> data = null;

  public ApiResult status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ApiResult data(List<Object> data) {
    this.data = data;
    return this;
  }

  public ApiResult addDataItem(Object dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Object>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  
    public List<Object> getData() {
    return data;
  }

  public void setData(List<Object> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiResult apiResult = (ApiResult) o;
    return Objects.equals(this.status, apiResult.status) &&
        Objects.equals(this.data, apiResult.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiResult {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
