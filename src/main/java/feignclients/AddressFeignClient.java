package feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import response.AddressResponse;
/*
*WebClient  has more features rather than RestTemplate
* WebClient is non-blocking reactive client,it makes HTTP requests
* Feign Client is library which helps us to create declarative REST clients easily
*  with pre-defind annotations,so it will provide better abstraction level,when we need to call an external service in micro service

 * architecture.
 *
 * */
@FeignClient(value = "address-service") // using Eureka Server along with feign client
//@FeignClient(url="${address.service.url}",value = "address-feign-client") // using only feign client
//@FeignClient(url="${address.service.url}",value = "address=feign-client",path="/api/address") // using only feign client with path
public interface AddressFeignClient {

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id);

}
