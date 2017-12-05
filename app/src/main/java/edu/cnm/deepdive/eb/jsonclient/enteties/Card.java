package edu.cnm.deepdive.eb.jsonclient.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class Card {

  private String front;
  private String back;
  private String reviewStatus;
  private String images;
  private String created;

  @JsonIgnore
  private String _links;


  public String getFront() {
    return front;
  }

  public void setFront(String front) {
    this.front = front;
  }

  public String getBack() {
    return back;
  }

  public void setBack(String back) {
    this.back = back;
  }

  public String getReviewStatus() {
    return reviewStatus;
  }

  public void setReviewStatus(String reviewStatus) {
    this.reviewStatus = reviewStatus;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getCreated() {
    return created;
  }

  public String get_links() {
    return _links;
  }

  public static class CardCollection {

    @JsonProperty("_embedded")
    private EmbeddedCards embedded;

    @JsonIgnore
    private String _links;

    public EmbeddedCards getEmbedded() {
      return embedded;
    }

    public void setEmbedded(EmbeddedCards embedded) {
      this.embedded = embedded;
    }

    public String get_links() {
      return _links;
    }

    public void set_links(String _links) {
      this._links = _links;
    }

    public static class EmbeddedCards {

      @JsonProperty("cards")
      private List<Card> cards;

      public List<Card> getCards() {
        return cards;
      }

      public void setCards(List<Card> cards) {
        this.cards = cards;
      }

    }
  }

}

