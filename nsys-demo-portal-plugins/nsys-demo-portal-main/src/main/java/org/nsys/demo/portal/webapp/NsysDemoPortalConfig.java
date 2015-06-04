/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp;

import org.nsys.system.ComponentProvider;
import org.nsys.daemon.user.DefaultUser;
import org.nsys.daemon.user.UserManager;
import org.nsys.portal.AbstractPortalConfig;

/**
 * Nsys Demo Portal Configuration class
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class NsysDemoPortalConfig extends AbstractPortalConfig {

	public static final String PORTAL_NAME = "Nsys Demo Portal";
	public static final String PORTAL_LOGO_TEXT = "NSYS DEMO";

	@Override
	public void configure() {
		setPortalName(PORTAL_NAME);
		setPortalLogoText(PORTAL_LOGO_TEXT);
		setPortalCopyright(getCopyrightHtml());
		setPortalVersion(NsysDemoConfig.getVersion());
		setPortalBuildNumber(NsysDemoConfig.getBuildNumber());

		createBuildinUsers();
	}

	protected String getCopyrightHtml() {
		String html = "Copyright &copy; 2015 <a href=\"http://tomas.hrdlicka.co.uk\" title=\"Tomas Xboot Hrdlicka\">Tomas Hrdlicka</a>";
		return html;
	}

	protected void createBuildinUsers() {
		log.debug("Creating default portal build-in users...");

		UserManager userManager = ComponentProvider.getInstance().getComponent(UserManager.class);

        addUser(userManager, "admin", "A. D. Ministrator (Sysadmin)", "admin@nsys.org", "admin");
        addUser(userManager, "fred", "Fred Sysadmin", "fred@nsys.org", "fred");
        addUser(userManager, "barney", "Barney User", "barney@nsys.org", "barney");
        addUser(userManager, "betty", "Betty Admin", "betty@nsys.org", "betty");
    }

	protected void addUser(UserManager userManager, String login, String fullname, String email, String password) {
		DefaultUser user = (DefaultUser) userManager.createUser(login);
		user.setFullname(fullname);
		user.setEmail(email);
        userManager.alterPassword(user, password); 
        userManager.saveUser(user);
	}
}