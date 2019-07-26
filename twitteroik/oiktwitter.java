import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class oiktwitter {
    private final static String CONSUMER_KEY = "qAgugFq9nrxlQjWMZnuBxxCif";
    private final static String CONSUMER_KEY_SECRET = "1MUCZr1hTw2ugnRvt0QCyXVgUxdInGIG8xZy1J4XAqdpUGXOwg";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Test");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "HeXuXt5LPvkUbDUhzwIS7FuHQYuYxQxwoHoUfBrlmLmJg";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1120548589913067520-jwU4RK4VmPa2tjN1dTpmUtg7vxP3ms";
    }

    public static void main(String[] args) throws Exception {
	new oiktwitter().start();
    }
}