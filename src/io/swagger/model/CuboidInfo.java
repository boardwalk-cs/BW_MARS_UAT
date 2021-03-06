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
 * CuboidInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-18T15:20:05.137Z")
public class CuboidInfo   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("importTid")
  private Integer importTid = null;

  @JsonProperty("exportTid")
  private Integer exportTid = null;

  @JsonProperty("criteriaTableId")
  private Integer criteriaTableId = null;

  @JsonProperty("acessTableId")
  private Integer acessTableId = null;

  @JsonProperty("filter")
  private String filter = null;

  @JsonProperty("asOfTid")
  private Integer asOfTid = null;

  @JsonProperty("baselineId")
  private Integer baselineId = null;

  public CuboidInfo id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CuboidInfo name(String name) {
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

  public CuboidInfo importTid(Integer importTid) {
    this.importTid = importTid;
    return this;
  }

  /**
   * Get importTid
   * @return importTid
   **/
  @JsonProperty("importTid")
  @ApiModelProperty(value = "")
  public Integer getImportTid() {
    return importTid;
  }

  public void setImportTid(Integer importTid) {
    this.importTid = importTid;
  }

  public CuboidInfo exportTid(Integer exportTid) {
    this.exportTid = exportTid;
    return this;
  }

  /**
   * Get exportTid
   * @return exportTid
   **/
  @JsonProperty("exportTid")
  @ApiModelProperty(value = "")
  public Integer getExportTid() {
    return exportTid;
  }

  public void setExportTid(Integer exportTid) {
    this.exportTid = exportTid;
  }

  public CuboidInfo criteriaTableId(Integer criteriaTableId) {
    this.criteriaTableId = criteriaTableId;
    return this;
  }

  /**
   * The criteria table assigns filters to users for row access. 
   * @return criteriaTableId
   **/
  @JsonProperty("criteriaTableId")
  @ApiModelProperty(value = "The criteria table assigns filters to users for row access. ")
  public Integer getCriteriaTableId() {
    return criteriaTableId;
  }

  public void setCriteriaTableId(Integer criteriaTableId) {
    this.criteriaTableId = criteriaTableId;
  }

  public CuboidInfo acessTableId(Integer acessTableId) {
    this.acessTableId = acessTableId;
    return this;
  }

  /**
   * The access table defines read/write access to cells using filters
   * @return acessTableId
   **/
  @JsonProperty("acessTableId")
  @ApiModelProperty(value = "The access table defines read/write access to cells using filters")
  public Integer getAcessTableId() {
    return acessTableId;
  }

  public void setAcessTableId(Integer acessTableId) {
    this.acessTableId = acessTableId;
  }

  public CuboidInfo filter(String filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
   **/
  @JsonProperty("filter")
  @ApiModelProperty(value = "")
  public String getFilter() {
    return filter;
  }

  public void setFilter(String filter) {
    this.filter = filter;
  }

  public CuboidInfo asOfTid(Integer asOfTid) {
    this.asOfTid = asOfTid;
    return this;
  }

  /**
   * Get asOfTid
   * @return asOfTid
   **/
  @JsonProperty("asOfTid")
  @ApiModelProperty(value = "")
  public Integer getAsOfTid() {
    return asOfTid;
  }

  public void setAsOfTid(Integer asOfTid) {
    this.asOfTid = asOfTid;
  }

  public CuboidInfo baselineId(Integer baselineId) {
    this.baselineId = baselineId;
    return this;
  }

  /**
   * Get baselineId
   * @return baselineId
   **/
  @JsonProperty("baselineId")
  @ApiModelProperty(value = "")
  public Integer getBaselineId() {
    return baselineId;
  }

  public void setBaselineId(Integer baselineId) {
    this.baselineId = baselineId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CuboidInfo cuboidInfo = (CuboidInfo) o;
    return Objects.equals(this.id, cuboidInfo.id) &&
        Objects.equals(this.name, cuboidInfo.name) &&
        Objects.equals(this.importTid, cuboidInfo.importTid) &&
        Objects.equals(this.exportTid, cuboidInfo.exportTid) &&
        Objects.equals(this.criteriaTableId, cuboidInfo.criteriaTableId) &&
        Objects.equals(this.acessTableId, cuboidInfo.acessTableId) &&
        Objects.equals(this.filter, cuboidInfo.filter) &&
        Objects.equals(this.asOfTid, cuboidInfo.asOfTid) &&
        Objects.equals(this.baselineId, cuboidInfo.baselineId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, importTid, exportTid, criteriaTableId, acessTableId, filter, asOfTid, baselineId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CuboidInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    importTid: ").append(toIndentedString(importTid)).append("\n");
    sb.append("    exportTid: ").append(toIndentedString(exportTid)).append("\n");
    sb.append("    criteriaTableId: ").append(toIndentedString(criteriaTableId)).append("\n");
    sb.append("    acessTableId: ").append(toIndentedString(acessTableId)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    asOfTid: ").append(toIndentedString(asOfTid)).append("\n");
    sb.append("    baselineId: ").append(toIndentedString(baselineId)).append("\n");
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

