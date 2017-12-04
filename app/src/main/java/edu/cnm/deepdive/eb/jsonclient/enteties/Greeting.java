package edu.cnm.deepdive.eb.jsonclient.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Greeting {

  private String reviewPool;
  private String deckName;
  private String deckIcon;
  private String created;

  @JsonIgnore
  private String _links;

  public String getReviewPool() {
    return reviewPool;
  }

  public String getdeckName() {
    return deckName;
  }

  public void setDeckName(String deckName) {
    this.deckName = deckName;
  }

  public String getDeckIcon() {
    return deckIcon;
  }

  public String getCreated() {
    return created;
  }

  public String get_links() {
    return _links;
  }
}
