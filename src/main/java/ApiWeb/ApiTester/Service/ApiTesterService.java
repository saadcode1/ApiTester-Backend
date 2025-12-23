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
        HttpEntity<String> entity = new HttpEntity<>(req.getBody(), headers);

        ResponseEntity<String> response = restTemplate.exchange(req.getUrl(),
                HttpMethod.valueOf(req.getMethod()), entity, String.class);

        return response;

    }
}
