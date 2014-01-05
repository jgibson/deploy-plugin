package hudson.plugins.deploy.tomcat;

import hudson.EnvVars;
import hudson.Extension;
import hudson.plugins.deploy.ContainerAdapterDescriptor;

import org.codehaus.cargo.container.property.RemotePropertySet;
import org.codehaus.cargo.container.configuration.Configuration;
import org.kohsuke.stapler.DataBoundConstructor;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Tomcat 7.x
 */
public class Tomcat7xAdapter extends TomcatAdapter {

	/**
	 * Tomcat 7 support
	 * 
	 * @param url
	 *            Tomcat server location (for example: http://localhost:8080)
	 * @param password
	 *            tomcat manager password
	 * @param userName
	 *            tomcat manager username
	 */
	@DataBoundConstructor
	public Tomcat7xAdapter(String url, String password, String userName) {
		super(url, password, userName);
	}

	@Override
	protected String getTomcatManagerSuffix() {
		return "/manager/text";
	}

	/**
	 * Tomcat Cargo containerId
	 * 
	 * @return tomcat7x
	 */
	public String getContainerId() {
		return "tomcat7x";
	}

	@Extension
	public static final class DescriptorImpl extends ContainerAdapterDescriptor {
		public String getDisplayName() {
			return "Tomcat 7.x";
		}
	}
}
