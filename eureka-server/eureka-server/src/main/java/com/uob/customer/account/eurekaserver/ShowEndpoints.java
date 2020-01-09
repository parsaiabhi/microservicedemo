/*
 * package com.uob.customer.account.eurekaserver;
 * 
 * import java.util.List;
 * 
 * import org.springframework.boot.actuate.endpoint.A import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.actuate.endpoint.annotation.Endpoint; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class ShowEndpoints extends
 * AbstractEndpoint<List<Endpoint>>{
 * 
 * private List<Endpoint> endpoints;
 * 
 * @Autowired public ShowEndpoints(List<Endpoint> endpoints) {
 * super("showEndpoints"); this.endpoints = endpoints; }
 * 
 * public List<Endpoint> invoke() { return this.endpoints; } }
 */