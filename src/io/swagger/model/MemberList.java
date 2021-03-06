/*
 * Boardwalk Collaboration Platform API
 * API for Boardwalk Collaboration Platform APIs
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rahul_var@yahoo.com
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
import io.swagger.model.Memberships;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * MemberList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-23T07:19:11.481Z")
public class MemberList   {
  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("memberships")
  private List<Memberships> memberships = new ArrayList<Memberships>();

  public MemberList userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @JsonProperty("userId")
  @ApiModelProperty(example = "2003", required = true, value = "")
  @NotNull
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public MemberList userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
   **/
  @JsonProperty("userName")
  @ApiModelProperty(example = "srinivas", required = true, value = "")
  @NotNull
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public MemberList memberships(List<Memberships> memberships) {
    this.memberships = memberships;
    return this;
  }

  public MemberList addMembershipsItem(Memberships membershipsItem) {
    this.memberships.add(membershipsItem);
    return this;
  }

  /**
   * Get memberships
   * @return memberships
   **/
  @JsonProperty("memberships")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<Memberships> getMemberships() {
    return memberships;
  }

  public void setMemberships(List<Memberships> memberships) {
    this.memberships = memberships;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberList memberList = (MemberList) o;
    return Objects.equals(this.userId, memberList.userId) &&
        Objects.equals(this.userName, memberList.userName) &&
        Objects.equals(this.memberships, memberList.memberships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userName, memberships);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberList {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    memberships: ").append(toIndentedString(memberships)).append("\n");
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

