package edu.cnm.deepdive.eb.jsonclient.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;


public class Deck {

  @JsonProperty("_embedded")
  private Embedded embedded;

  public Embedded getEmbedded() {
    return embedded;
  }

  public void setEmbedded(Embedded embedded) {
    this.embedded = embedded;
  }

  class Embedded {
    @JsonProperty("decks")
    List<Deck> decks = new ArrayList<Deck>();

    public Embedded(){

    }

    public List<Deck> getDecks() {
      return decks;
    }

    public void setDecks(List<Deck> decks) {
      this.decks = decks;
    }
  }


  private String id;
  private String reviewPool;
  private String deckName;
  private String deckIcon;
  private String created;

  @JsonIgnore
  private String _links;

  public String getReviewPool() {
    return reviewPool;
  }

  public String getDeckName() {
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
