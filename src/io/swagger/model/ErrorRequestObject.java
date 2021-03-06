/*
 * Boardwalk Cuboid Services
 * Boardwalk Rest API
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@boardwalltech.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * ErrorRequestObject
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-05-10T09:36:40.808Z")
public class ErrorRequestObject   {
  @JsonProperty("error")
  private String error = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("proposedSolution")
  private String proposedSolution = null;

  public ErrorRequestObject error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   **/
  @JsonProperty("error")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorRequestObject path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Get path
   * @return path
   **/
  @JsonProperty("path")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ErrorRequestObject proposedSolution(String proposedSolution) {
    this.proposedSolution = proposedSolution;
    return this;
  }

  /**
   * Get proposedSolution
   * @return proposedSolution
   **/
  @JsonProperty("proposedSolution")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getProposedSolution() {
    return proposedSolution;
  }

  public void setProposedSolution(String proposedSolution) {
    this.proposedSolution = proposedSolution;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorRequestObject errorRequestObject = (ErrorRequestObject) o;
    return Objects.equals(this.error, errorRequestObject.error) &&
        Objects.equals(this.path, errorRequestObject.path) &&
        Objects.equals(this.proposedSolution, errorRequestObject.proposedSolution);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, path, proposedSolution);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorRequestObject {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    proposedSolution: ").append(toIndentedString(proposedSolution)).append("\n");
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

