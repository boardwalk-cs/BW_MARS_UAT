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
import io.swagger.model.MemberList;
import io.swagger.model.NhHierarchy;
import io.swagger.model.NhList;
import io.swagger.model.UserList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * BcpInstanceInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-23T07:19:11.481Z")
public class BcpInstanceInfo   {
  @JsonProperty("serverAlias")
  private String serverAlias = null;

  @JsonProperty("serverUrl")
  private String serverUrl = null;

  @JsonProperty("login_name")
  private String loginName = null;

  @JsonProperty("login_pwd")
  private String loginPwd = null;

  @JsonProperty("userList")
  private List<UserList> userList = new ArrayList<UserList>();

  @JsonProperty("nh0List")
  private List<NhList> nh0List = new ArrayList<NhList>();

  @JsonProperty("membershipList")
  private List<MemberList> membershipList = new ArrayList<MemberList>();

  @JsonProperty("nieghborhoods")
  private List<NhHierarchy> nieghborhoods = new ArrayList<NhHierarchy>();

  public BcpInstanceInfo serverAlias(String serverAlias) {
    this.serverAlias = serverAlias;
    return this;
  }

  /**
   * Get serverAlias
   * @return serverAlias
   **/
  @JsonProperty("serverAlias")
  @ApiModelProperty(example = "accounting", required = true, value = "")
  @NotNull
  public String getServerAlias() {
    return serverAlias;
  }

  public void setServerAlias(String serverAlias) {
    this.serverAlias = serverAlias;
  }

  public BcpInstanceInfo serverUrl(String serverUrl) {
    this.serverUrl = serverUrl;
    return this;
  }

  /**
   * Get serverUrl
   * @return serverUrl
   **/
  @JsonProperty("serverUrl")
  @ApiModelProperty(example = "http://localhost:8080/EPortal", required = true, value = "")
  @NotNull
  public String getServerUrl() {
    return serverUrl;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  public BcpInstanceInfo loginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

  /**
   * Get loginName
   * @return loginName
   **/
  @JsonProperty("login_name")
  @ApiModelProperty(example = "rahulv", required = true, value = "")
  @NotNull
  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public BcpInstanceInfo loginPwd(String loginPwd) {
    this.loginPwd = loginPwd;
    return this;
  }

  /**
   * Get loginPwd
   * @return loginPwd
   **/
  @JsonProperty("login_pwd")
  @ApiModelProperty(example = "0", required = true, value = "")
  @NotNull
  public String getLoginPwd() {
    return loginPwd;
  }

  public void setLoginPwd(String loginPwd) {
    this.loginPwd = loginPwd;
  }

  public BcpInstanceInfo userList(List<UserList> userList) {
    this.userList = userList;
    return this;
  }

  public BcpInstanceInfo addUserListItem(UserList userListItem) {
    this.userList.add(userListItem);
    return this;
  }

  /**
   * Get userList
   * @return userList
   **/
  @JsonProperty("userList")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<UserList> getUserList() {
    return userList;
  }

  public void setUserList(List<UserList> userList) {
    this.userList = userList;
  }

  public BcpInstanceInfo nh0List(List<NhList> nh0List) {
    this.nh0List = nh0List;
    return this;
  }

  public BcpInstanceInfo addNh0ListItem(NhList nh0ListItem) {
    this.nh0List.add(nh0ListItem);
    return this;
  }

  /**
   * Get nh0List
   * @return nh0List
   **/
  @JsonProperty("nh0List")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<NhList> getNh0List() {
    return nh0List;
  }

  public void setNh0List(List<NhList> nh0List) {
    this.nh0List = nh0List;
  }

  public BcpInstanceInfo membershipList(List<MemberList> membershipList) {
    this.membershipList = membershipList;
    return this;
  }

  public BcpInstanceInfo addMembershipListItem(MemberList membershipListItem) {
    this.membershipList.add(membershipListItem);
    return this;
  }

  /**
   * Get membershipList
   * @return membershipList
   **/
  @JsonProperty("membershipList")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<MemberList> getMembershipList() {
    return membershipList;
  }

  public void setMembershipList(List<MemberList> membershipList) {
    this.membershipList = membershipList;
  }

  public BcpInstanceInfo nieghborhoods(List<NhHierarchy> nieghborhoods) {
    this.nieghborhoods = nieghborhoods;
    return this;
  }

  public BcpInstanceInfo addNieghborhoodsItem(NhHierarchy nieghborhoodsItem) {
    this.nieghborhoods.add(nieghborhoodsItem);
    return this;
  }

  /**
   * Get nieghborhoods
   * @return nieghborhoods
   **/
  @JsonProperty("nieghborhoods")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<NhHierarchy> getNieghborhoods() {
    return nieghborhoods;
  }

  public void setNieghborhoods(List<NhHierarchy> nieghborhoods) {
    this.nieghborhoods = nieghborhoods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BcpInstanceInfo bcpInstanceInfo = (BcpInstanceInfo) o;
    return Objects.equals(this.serverAlias, bcpInstanceInfo.serverAlias) &&
        Objects.equals(this.serverUrl, bcpInstanceInfo.serverUrl) &&
        Objects.equals(this.loginName, bcpInstanceInfo.loginName) &&
        Objects.equals(this.loginPwd, bcpInstanceInfo.loginPwd) &&
        Objects.equals(this.userList, bcpInstanceInfo.userList) &&
        Objects.equals(this.nh0List, bcpInstanceInfo.nh0List) &&
        Objects.equals(this.membershipList, bcpInstanceInfo.membershipList) &&
        Objects.equals(this.nieghborhoods, bcpInstanceInfo.nieghborhoods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverAlias, serverUrl, loginName, loginPwd, userList, nh0List, membershipList, nieghborhoods);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BcpInstanceInfo {\n");
    
    sb.append("    serverAlias: ").append(toIndentedString(serverAlias)).append("\n");
    sb.append("    serverUrl: ").append(toIndentedString(serverUrl)).append("\n");
    sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
    sb.append("    loginPwd: ").append(toIndentedString(loginPwd)).append("\n");
    sb.append("    userList: ").append(toIndentedString(userList)).append("\n");
    sb.append("    nh0List: ").append(toIndentedString(nh0List)).append("\n");
    sb.append("    membershipList: ").append(toIndentedString(membershipList)).append("\n");
    sb.append("    nieghborhoods: ").append(toIndentedString(nieghborhoods)).append("\n");
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
