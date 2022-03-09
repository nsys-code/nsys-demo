/* Copyright 2012, 2022 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp;

import org.nsys.portal.AbstractPortalConfig;

/**
 * Nsys Demo Portal Configuration class
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class NsysDemoPortalMainConfig extends AbstractPortalConfig {

	public static final String PORTAL_NAME = "Nsys Demo Portal";
	public static final String PORTAL_LOGO_TEXT = "NSYS DEMO";

	@Override
	public void configure() {
		setPortalName(PORTAL_NAME);
		setPortalLogoText(PORTAL_LOGO_TEXT);
		setPortalCopyright(getCopyrightHtml());
		setPortalVersion(PortalConfig.getVersion());
		setPortalBuildNumber(PortalConfig.getBuildNumber());
	}

	protected String getCopyrightHtml() {
		String html = "Copyright &copy; 2022 <a href=\"http://tomas.hrdlicka.co.uk\" title=\"Tomas Xboot Hrdlicka\">Tomas Hrdlicka</a>";
		return html;
	}
}