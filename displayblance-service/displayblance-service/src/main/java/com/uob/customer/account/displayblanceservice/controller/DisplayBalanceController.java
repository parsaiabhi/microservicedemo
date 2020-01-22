package com.uob.customer.account.displayblanceservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.uob.customer.account.displayblanceservice.service.CreationServiceClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DisplayBalanceController {

	private final CreationServiceClient creationServiceClient;

//	@Autowired
//    private EurekaClient eurekaClient;
//	 InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("netflix-service", false);
//     String serviceBaseUrl = instanceInfo.getHomePageUrl();
	
	@Autowired
    private DiscoveryClient discoveryClient;
 
    @Autowired
    private LoadBalancerClient loadBalancer;
	
	@Autowired
	private Environment environment;

	@Autowired
	public DisplayBalanceController(CreationServiceClient creationServiceClient) {
		this.creationServiceClient = creationServiceClient;
	}

	@PostMapping("/client/customers/accounts/{accountNo}/balance")
	public ResponseEntity<String> displayBalance(@PathVariable("accountNo") String accountNo) {
		/*
		 * String balance = creationServiceClient.getBalance(accountNo) + "from port: "
		 * + environment.getProperty("local.server.port");
		 */
		String balance = creationServiceClient.getBalance(accountNo);
		ServiceInstance instance = loadBalancer.choose("creation");
		String dd = "Host name: " +instance.getHost() +" \n" + " port no.: "+instance.getPort()+" \n " +" balance "+balance;
		URI creationURI = URI.create(String.format("http://%s:%s", instance.getHost(),instance.getPort())); 	
		log.info("Creationuri {}",creationURI);
		return new ResponseEntity<String>(dd, HttpStatus.OK);

	}
	
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + environment.getProperty("local.server.port");
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String home()
	 * {
	 * 
	 * return "<a href='testCallcreationService'>/testCallcreationService</a>"; }
	 */
 
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/testCallcreationService", method =
	 * RequestMethod.GET) public String showFirstService() {
	 * 
	 * String serviceId = "creation".toLowerCase();
	 * 
	 * // (Need!!) eureka.client.fetchRegistry=true List<ServiceInstance> instances
	 * = this.discoveryClient.getInstances(serviceId);
	 * 
	 * if (instances == null || instances.isEmpty()) { return
	 * "No instances for service: " + serviceId; } String html =
	 * "<h2>Instances for Service Id: " + serviceId + "</h2>";
	 * 
	 * for (ServiceInstance serviceInstance : instances) { html += "<h3>Instance :"
	 * + serviceInstance.getUri() + "</h3>"; }
	 * 
	 * // Create a RestTemplate. RestTemplate restTemplate = new RestTemplate();
	 * 
	 * html += "<br><h4>Call /hello of service: " + serviceId + "</h4>";
	 * 
	 * try { // May be throw IllegalStateException (No instances available)
	 * ServiceInstance serviceInstance = this.loadBalancer.choose(serviceId);
	 * 
	 * html += "<br>===> Load Balancer choose: " + serviceInstance.getUri();
	 * 
	 * String url = "http://" + serviceInstance.getHost() + ":" +
	 * serviceInstance.getPort() + "/hello";
	 * 
	 * html += "<br>Make a Call: " + url; html += "<br>";
	 * 
	 * String result = restTemplate.getForObject(url, String.class);
	 * 
	 * html += "<br>Result: " + result; } catch (IllegalStateException e) { html +=
	 * "<br>loadBalancer.choose ERROR: " + e.getMessage(); e.printStackTrace(); }
	 * catch (Exception e) { html += "<br>Other ERROR: " + e.getMessage();
	 * e.printStackTrace(); } return html; }
	 */
	
	
	
	

}
