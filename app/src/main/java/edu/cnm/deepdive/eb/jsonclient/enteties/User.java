package edu.cnm.deepdive.eb.jsonclient.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {


  private String userName;
  private String emailAddress;
  private String created;

  @JsonIgnore
  private String _links;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String get_links() {
    return _links;
  }

  public void set_links(String _links) {
    this._links = _links;
  }
}
