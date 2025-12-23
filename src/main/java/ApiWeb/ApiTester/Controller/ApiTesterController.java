package ApiWeb.ApiTester.Controller;


import ApiWeb.ApiTester.Dto.ApiRequestDto;
import ApiWeb.ApiTester.Service.ApiTesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("https://apitester-backend-production.up.railway.app/api/tester")
public class ApiTesterController {

    @Autowired
    private ApiTesterService apiTesterService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendRequest(@RequestBody ApiRequestDto apiRequestDto) {
        return apiTesterService.executeRequest(apiRequestDto);
    }

}
