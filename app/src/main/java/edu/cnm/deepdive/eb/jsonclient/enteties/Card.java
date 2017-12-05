package edu.cnm.deepdive.eb.jsonclient.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class Card {

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

  public static class DeckCollection {

    @JsonProperty("_embedded")
    private EmbeddedDecks embedded;

    @JsonIgnore
    private String _links;

    public EmbeddedDecks getEmbedded() {
      return embedded;
    }

    public void setEmbedded(EmbeddedDecks embedded) {
      this.embedded = embedded;
    }

    public String get_links() {
      return _links;
    }

    public void set_links(String _links) {
      this._links = _links;
    }

    public static class EmbeddedDecks {

      @JsonProperty("decks")
      private List<Card> decks;

      public List<Card> getDecks() {
        return decks;
      }

      public void setDecks(List<Card> decks) {
        this.decks = decks;
      }

    }
  }

}

