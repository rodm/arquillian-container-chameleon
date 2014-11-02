package org.arquillian.container.proxy;

import org.arquillian.container.proxy.spi.Profile;
import org.arquillian.container.proxy.spi.Target;
import org.jboss.arquillian.container.spi.ConfigurationException;
import org.jboss.arquillian.container.spi.client.container.ContainerConfiguration;

public class ProxyDeployableContainerConfiguration implements ContainerConfiguration {

    private String target = null;

    @Override
    public void validate() throws ConfigurationException {
        if(target == null) {
            throw new ConfigurationException("target must be provided in format server:version:type");
        }
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Profile getProfile() {
        return Profile.from(Target.from(this.target));
    }
}
