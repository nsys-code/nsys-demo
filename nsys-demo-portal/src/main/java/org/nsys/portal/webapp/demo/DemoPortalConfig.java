/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.portal.webapp.demo;

import org.nsys.system.ComponentProvider;
import org.nsys.daemon.user.DefaultUser;
import org.nsys.daemon.user.UserManager;
import org.nsys.portal.AbstractPortalConfig;
import org.nsys.portal.NavigationItem;
import org.nsys.portal.NavigationSection;
import org.nsys.portal.PortalNavigationSystem;
import org.nsys.portal.conditions.UserIsLoggedInCondition;

/**
 * Nsys Demo Portal Configuration class
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoPortalConfig extends AbstractPortalConfig {

	public static final String PORTAL_NAME = "Nsys Demo Portal";
	public static final String PORTAL_LOGO_TEXT = "NSYS DEMO";
	
	@Override
	public void configure() {
		setPortalName(PORTAL_NAME);
		setPortalLogoText(PORTAL_LOGO_TEXT);
		setPortalCopyright(getCopyrightHtml());
		setPortalVersion(NsysDemoConfig.getVersion());
		setPortalBuildNumber(NsysDemoConfig.getBuildNumber());
		
		createNavigation();
		createBuildinUsers();
	}
	
	protected String getCopyrightHtml() {
		String html = "Copyright &copy; 2015 <a href=\"http://tomas.hrdlicka.co.uk\" title=\"Tomas Xboot Hrdlicka\">Tomas Hrdlicka</a>";
		return html;
	}
	
	protected void createNavigation() {
		log.debug("Creating default portal navigation...");
		
		// Application Switcher Navigation
		NavigationItem niJira = new NavigationItem();
		niJira.setKey("nsys-portal_appswitcher_jira");
		niJira.setLabel("JIRA");
		niJira.setLink("https://jira.nsys.org");
		niJira.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_APPSWITCHER, niJira);
		
		NavigationItem niConfluence = new NavigationItem();
		niConfluence.setKey("nsys-portal_appswitcher_confluence");
		niConfluence.setLabel("Confluence");
		niConfluence.setLink("http://confluence.nsys.org");
		niConfluence.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_APPSWITCHER, niConfluence);
		
		NavigationItem niTeamCity = new NavigationItem();
		niTeamCity.setKey("nsys-portal_appswitcher_teamcity");
		niTeamCity.setLabel("TeamCity");
		niTeamCity.setLink("https://teamcity.nsys.org");
		niTeamCity.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_APPSWITCHER, niTeamCity);


		// Main navigation
		NavigationSection nsGetStarted = NavigationSection.createSection("system.top.navigation.bar/getstarted", "getstarted", "Get Started");
		getPortalNavigation().addSection(nsGetStarted);
				
		NavigationItem niOverview = new NavigationItem();
		niOverview.setKey("nsys-portal_nav-main_getstarted_overview");
		niOverview.setLabel("Nsys Overview");
		niOverview.setLink("http://www.nsys.org");
		niOverview.setWeight(0);
		getPortalNavigation().addItem(nsGetStarted, niOverview);

		NavigationSection nsDasboards = NavigationSection.createSection("system.top.navigation.bar/dashboards", "dashboards", "Dashboards");
		nsDasboards.setDescription("View and manage your dashboards");
		getPortalNavigation().addSection(nsDasboards);
				
		NavigationItem niDashboardView = new NavigationItem();
		niDashboardView.setKey("nsys-portal_nav-main_dashboards_view");
		niDashboardView.setLabel("View System Dashboard");
		niDashboardView.setLink("/dashboard");
		niDashboardView.setWeight(0);
		getPortalNavigation().addItem(nsDasboards, niDashboardView);
		
		NavigationItem niDashboardManage = new NavigationItem();
		niDashboardManage.setKey("nsys-portal_nav-main_dashboards_manage");
		niDashboardManage.setLabel("Manage Dashboards");
		niDashboardManage.setLink("/dashboard/manage");
		niDashboardManage.setWeight(0);
		niDashboardManage.addCondition(new UserIsLoggedInCondition());
		getPortalNavigation().addItem(nsDasboards, niDashboardManage);


		// Footer navigation
		NavigationItem niIssues = new NavigationItem();
		niIssues.setKey("nsys-portal_footer-links_issues");
		niIssues.setLabel("Issues");
		niIssues.setLink("https://jira.nsys.org/browse/NSYS");
		niIssues.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_FOOTER_LINKS, niIssues);

		NavigationItem niBuilds = new NavigationItem();
		niBuilds.setKey("nsys-portal_footer-links_builds");
		niBuilds.setLabel("Builds");
		niBuilds.setLink("https://teamcity.nsys.org");
		niBuilds.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_FOOTER_LINKS, niBuilds);
		
		NavigationItem niDocumentation = new NavigationItem();
		niDocumentation.setKey("nsys-portal_footer-links_doc");
		niDocumentation.setLabel("Documentation");
		niDocumentation.setLink("http://doc.nsys.org/display/NSYS");
		niDocumentation.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_FOOTER_LINKS, niDocumentation);
		
		
		// Help navigation
		NavigationItem niNsysPlatform = new NavigationItem();
		niNsysPlatform.setKey("nsys-portal_header-links_help_nsys-platform");
		niNsysPlatform.setLabel("Nsys Platform");
		niNsysPlatform.setLink("http://doc.nsys.org/display/NSYS/Home");
		niNsysPlatform.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_HELP_LINKS, niNsysPlatform);
		
		NavigationItem niNsysDaemon = new NavigationItem();
		niNsysDaemon.setKey("nsys-portal_header-links_help_nsys-daemon");
		niNsysDaemon.setLabel("Nsys Daemon");
		niNsysDaemon.setLink("http://doc.nsys.org/display/NSYS/Nsys+Daemon");
		niNsysDaemon.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_HELP_LINKS, niNsysDaemon);
		
		NavigationItem niNsysPortal = new NavigationItem();
		niNsysPortal.setKey("nsys-portal_header-links_help_nsys-portal");
		niNsysPortal.setLabel("Nsys Portal");
		niNsysPortal.setLink("http://doc.nsys.org/display/NSYS/Nsys+Portal");
		niNsysPortal.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_HELP_LINKS, niNsysPortal);
		
		NavigationItem niNsysTerminal = new NavigationItem();
		niNsysTerminal.setKey("nsys-portal_header-links_help_nsys-terminal");
		niNsysTerminal.setLabel("Nsys Terminal");
		niNsysTerminal.setLink("http://doc.nsys.org/display/NSYS/Nsys+Terminal");
		niNsysTerminal.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_HELP_LINKS, niNsysTerminal);
		
		NavigationItem niNsysApi = new NavigationItem();
		niNsysApi.setKey("nsys-portal_header-links_help_nsys-api");
		niNsysApi.setLabel("Nsys Remote API Reference");
		niNsysApi.setLink("http://doc.nsys.org/display/NSYS/Nsys+Remote+API+Reference");
		niNsysApi.setWeight(0);
		getPortalNavigation().addItem(PortalNavigationSystem.NAVIGATION_HELP_LINKS, niNsysApi);
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