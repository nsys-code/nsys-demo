/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.portal.webapp.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Status;

import org.nsys.portal.controller.PortalAdminController;
import org.nsys.portal.webapp.demo.utils.TwitterHelper;

/**
 * Demo Controller
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends PortalAdminController {

	private static String LOCATION_HEADER_ACTIONS = "demo.header.actions";
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showDemo(
			HttpServletRequest request,
			HttpServletResponse response) {
				
		return new ModelAndView("redirect:/demo/tweets/nsys_org");		
	}
	
	@RequestMapping(value = "/tweets/{user}", method = RequestMethod.GET)
	public ModelAndView showTweets(
			@PathVariable("user") String user,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String imageUri = String.format("%s/resources/images/nsys_logo_avatar.png", request.getContextPath());

		Map<String, Object> context = new HashMap<String, Object>();
		context.put("user", user);
		getUserTimeline(user, context);
		
		setDisplayName(String.format("@%s's timeline", user));
		showHeader(imageUri, LOCATION_HEADER_ACTIONS, null);

		return render("/templates/tweets.vm", context, request, response);		
	}
	
	private void getUserTimeline(String user, Map<String, Object> context) {
		List<Status> tweets = TwitterHelper.getUserTimeline(user, TwitterHelper.getInstance());
		
       	if (tweets != null && tweets.size() > 0) {
       		context.put("tweets", tweets);        		
       	}        	
	}
}