package common;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:dev.properties"})
public interface Enviroment extends Config {
	@Key("app.url")
	String appUrl();
	
	@Key("app.username")
	String username();
	
	@Key("app.password")
	String password();
}
