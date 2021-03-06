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
import io.swagger.model.GridInfo;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Whiteboard
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-05-10T09:36:40.808Z")
public class Whiteboard   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("gridList")
  private List<GridInfo> gridList = null;

  public Whiteboard id(Long id) {
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

  public Whiteboard name(String name) {
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

  public Whiteboard gridList(List<GridInfo> gridList) {
    this.gridList = gridList;
    return this;
  }

  public Whiteboard addGridListItem(GridInfo gridListItem) {
    if (this.gridList == null) {
      this.gridList = new ArrayList<GridInfo>();
    }
    this.gridList.add(gridListItem);
    return this;
  }

  /**
   * Get gridList
   * @return gridList
   **/
  @JsonProperty("gridList")
  @ApiModelProperty(value = "")
  public List<GridInfo> getGridList() {
    return gridList;
  }

  public void setGridList(List<GridInfo> gridList) {
    this.gridList = gridList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Whiteboard whiteboard = (Whiteboard) o;
    return Objects.equals(this.id, whiteboard.id) &&
        Objects.equals(this.name, whiteboard.name) &&
        Objects.equals(this.gridList, whiteboard.gridList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, gridList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Whiteboard {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gridList: ").append(toIndentedString(gridList)).append("\n");
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

