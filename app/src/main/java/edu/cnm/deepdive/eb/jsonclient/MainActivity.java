package edu.cnm.deepdive.eb.jsonclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import edu.cnm.deepdive.eb.jsonclient.enteties.Card;
import edu.cnm.deepdive.eb.jsonclient.enteties.User;
import java.util.List;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    new UserHttpTask().execute(); // gets the user
    new CardHttpTask().execute(); // get decks that is associated with a user
  }

  private class UserHttpTask extends AsyncTask<Void, Void, User> {

    @Override
    protected User doInBackground(Void... voids) {
      try {
        // final String url = "http://10.0.2.2:8080/classrooms/1"; Use 10.0.2.2 instead of local host
        final String url = "http://10.0.2.2:8080/users/1";
        //Retrieves JSON and transforms them into java objects
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        User user = restTemplate.getForObject(url, User.class);
        return user;

      } catch (Exception e) {
        Log.e("MainActivity", e.getMessage(), e);
      }
      return null;
    }

    @Override
    protected void onPostExecute(User user) {
//      TextView greetingId = (TextView) findViewById(R.id.greeting_id);
//      TextView greetingContent = (TextView) findViewById(R.id.greeting_content);
//      greetingId.setText(user.getEmailAddress());
//      greetingContent.setText(user.getUserName());
    }
  }

//  private class DeckHttpTask extends AsyncTask<Void, Void, Deck> {
//    @Override
//    protected Deck doInBackground(Void... voids) {
//      try {
//        // final String url = "http://10.0.2.2:8080/classrooms/1"; Use 10.0.2.2 instead of local host
//        final String url = "http://10.0.2.2:8080/users/1/decks/1";
//
//        //Retrieves JSON and transforms them into java objects
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        Deck deck = restTemplate.getForObject(url, Deck.class);
//        return deck;
//
//      } catch (Exception e) {
//        Log.e("MainActivity", e.getMessage(), e);
//      }
//      return null;
//    }
//
//    @Override
//    protected void onPostExecute(Deck deck) {
////      TextView greetingId = (TextView) findViewById(R.id.card_name);
//      TextView greetingContent = (TextView) findViewById(R.id.greeting_content);
////      greetingId.setText(deck.getDeckName());
//      greetingContent.setText(deck.getDeckName());
//    }
//  }


//  private class DeckHttpTask extends AsyncTask<Void, Void, List<Deck>> {
//    @Override
//    protected List<Deck> doInBackground(Void... voids) {
//      try {
//        // final String url = "http://10.0.2.2:8080/classrooms/1"; Use 10.0.2.2 instead of local host
//        final String url = "http://10.0.2.2:8080/users/1/decks";
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        Deck.DeckCollection collection = restTemplate.getForObject(url, Deck.DeckCollection.class);
//        return collection.getEmbedded().getDecks();
//      } catch (Exception e) {
//        Log.e("MainActivity", e.getMessage(), e);
//      }
//      return null;
//    }
//
//    @Override
//    protected void onPostExecute(List<Deck> decks) {
////      TextView greetingId = (TextView) findViewById(R.id.card_name);
//      TextView greetingContent = (TextView) findViewById(R.id.greeting_content);
////      greetingId.setText(deck.getDeckName());
//      greetingContent.setText(decks.get(0).getDeckName());
//    }
//  }

  private class CardHttpTask extends AsyncTask<Void, Void, List<Card>> {
    @Override
    protected List<Card> doInBackground(Void... voids) {
      try {
        // final String url = "http://10.0.2.2:8080/classrooms/1"; Use 10.0.2.2 instead of local host
        final String url = "http://10.0.2.2:8080/decks/1/cards";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Card.CardCollection collection = restTemplate.getForObject(url, Card.CardCollection.class);
        return collection.getEmbedded().getCards();
      } catch (Exception e) {
        Log.e("MainActivity", e.getMessage(), e);
      }
      return null;
    }

    @Override
    protected void onPostExecute(List<Card> cards) {
//      TextView greetingId = (TextView) findViewById(R.id.card_name);
      TextView greetingContent = (TextView) findViewById(R.id.greeting_content);
//      greetingId.setText(deck.getDeckName());
      greetingContent.setText(cards.get(0).getFront());
    }
  }





  // TODO this is how I post to a specific deck with a specific user.

//  {
//    "deckName" : "Yes for android",
//      "user" : "http://localhost:8080/users/1"
//  }


}
