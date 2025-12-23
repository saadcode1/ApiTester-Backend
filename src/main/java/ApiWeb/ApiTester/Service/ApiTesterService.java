package ApiWeb.ApiTester.Service;

import ApiWeb.ApiTester.Dto.ApiRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiTesterService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> executeRequest(ApiRequestDto req){

        HttpHeaders headers = new HttpHeaders();
        if(req.getHeaders() != null){
            req.getHeaders().forEach(headers::set);
        }

        HttpMethod method = HttpMethod.valueOf(req.getMethod().toUpperCase());

        HttpEntity<String> entity;

        // ******** MOST IMPORTANT FIX ********
        if(method == HttpMethod.GET || method == HttpMethod.DELETE){
            entity = new HttpEntity<>(headers);   // NO BODY
        } else {
            entity = new HttpEntity<>(req.getBody(), headers);
        }

        try {
            return restTemplate.exchange(
                    req.getUrl(),
                    method,
                    entity,
                    String.class
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(500)
                    .body("Server Error: " + e.getMessage());
        }
    }
}
