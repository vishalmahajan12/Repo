package apache.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App 
{
	static ConnectionFactory connectionFactory =
			  new ActiveMQConnectionFactory("tcp://172.18.0.171:61616");//vm://localhost

	public static void main(String args[]) throws Exception {
	    CamelContext context = new DefaultCamelContext();
	   /* context.addRoutes(new RouteBuilder() {
	        public void configure() {
	                                                      
	            from("file:export/mail/inbox?delay=500").to("file:export/mail/outbox");//noop=true
	        }
	    });*/
	    context.addComponent("jms",
	        JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
	    context.addRoutes(new RouteBuilder() {
		
			@Override
			public void configure() throws Exception {
				from("file:export/mail/inbox?delay=500").to("jms:queue:incomingOrders");
			}
		});
	    context.start();
	    Thread.sleep(100000);
	    context.stop();
	}

}
