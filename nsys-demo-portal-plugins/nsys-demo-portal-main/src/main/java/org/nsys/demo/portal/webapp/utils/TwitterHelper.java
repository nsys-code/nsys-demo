/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.utils;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import org.nsys.logging.Log;
import org.nsys.demo.portal.webapp.NsysDemoConfig;

/**
 * Twitter Helper
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class TwitterHelper {
	private static final Log log = new Log(TwitterHelper.class);

	private static Twitter twitterInstance;

	public static Twitter getInstance() {
		if (twitterInstance != null) {
			return twitterInstance;
		}

        try {
    		ConfigurationBuilder cb = new ConfigurationBuilder();
    		cb.setDebugEnabled(NsysDemoConfig.getTwitterDebugEnabled());
    		cb.setApplicationOnlyAuthEnabled(true);
    	    cb.setOAuthConsumerKey(NsysDemoConfig.getTwitterConsumerKey());
    	    cb.setOAuthConsumerSecret(NsysDemoConfig.getTwitterConsumerSecret());

            TwitterFactory tf = new TwitterFactory(cb.build());
            twitterInstance = tf.getInstance();
            OAuth2Token token = twitterInstance.getOAuth2Token();

            if (log.isDebugEnabled() && token != null) {
            	log.debugFormat("Token Type: %s", token.getTokenType());
            	log.debugFormat("Access Token: %s", token.getAccessToken());
            }

        } catch (TwitterException te) {
        	log.error("Unable to get Twitter Instance!", te);
        }

        return twitterInstance;
	}

	public static List<Status> getUserTimeline(String user, Twitter twitter) {
		List<Status> tweets = null;

		if (user == null || user.isEmpty() || twitter == null) {
			return null;
		}

        try {
        	tweets = twitter.getUserTimeline(user);

        } catch (TwitterException te) {
        	log.error(String.format("Unable to get timeline for user %s!", user), te);
        }

        return tweets;
	}
}