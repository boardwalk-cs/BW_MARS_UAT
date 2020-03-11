/*
 * Boardwalk Cuboid Services
 * Boardwalk Rest API
 *
 * OpenAPI spec version: 1.0.1
 * Contact: apisupport@boardwalltech.com
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
 * Neighborhood
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-09T07:13:31.207Z")
public class Neighborhood   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("level")
  private Long level = null;

  @JsonProperty("parentId")
  private Long parentId = -1l;

  @JsonProperty("secure")
  private Boolean secure = false;

  public Neighborhood id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Neighborhood name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty("name")
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Neighborhood level(Long level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   **/
  @JsonProperty("level")
  @ApiModelProperty(value = "")
  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }

  public Neighborhood parentId(Long parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Get parentId
   * @return parentId
   **/
  @JsonProperty("parentId")
  @ApiModelProperty(value = "")
  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Neighborhood secure(Boolean secure) {
    this.secure = secure;
    return this;
  }

  /**
   * Get secure
   * @return secure
   **/
  @JsonProperty("secure")
  @ApiModelProperty(value = "")
  public Boolean isSecure() {
    return secure;
  }

  public void setSecure(Boolean secure) {
    this.secure = secure;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Neighborhood neighborhood = (Neighborhood) o;
    return Objects.equals(this.id, neighborhood.id) &&
        Objects.equals(this.name, neighborhood.name) &&
        Objects.equals(this.level, neighborhood.level) &&
        Objects.equals(this.parentId, neighborhood.parentId) &&
        Objects.equals(this.secure, neighborhood.secure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, level, parentId, secure);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Neighborhood {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    secure: ").append(toIndentedString(secure)).append("\n");
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
