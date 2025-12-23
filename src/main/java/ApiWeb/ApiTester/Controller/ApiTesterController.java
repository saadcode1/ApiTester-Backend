package ApiWeb.ApiTester.Controller;


import ApiWeb.ApiTester.Dto.ApiRequestDto;
import ApiWeb.ApiTester.Service.ApiTesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "https://api-tes-8sc7p43y8-saadcode1s-projects.vercel.app")
public class ApiTesterController {

    @Autowired
    private ApiTesterService apiTesterService;

    @PostMapping("/send")
    public ResponseEntity<String> sendRequest(@RequestBody ApiRequestDto apiRequestDto) {
        return apiTesterService.executeRequest(apiRequestDto);
    }

}
