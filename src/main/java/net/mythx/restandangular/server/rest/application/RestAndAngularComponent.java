/* Author Antoine Moser */

package net.mythx.restandangular.server.rest.application;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class RestAndAngularComponent extends Component {
	public static void main(String[] args) throws Exception {
        new RestAndAngularComponent().start();
    }
	
	public RestAndAngularComponent() {
		Server server = new Server(Protocol.HTTP, 8000);
		getServers().add(server);
		
		getDefaultHost().attachDefault(new RestAndAngularApplication());

        System.out.println("Server started on port 8000.");
        System.out.println("Application is now available on http://localhost:8000/web/index.html");
	}
}
