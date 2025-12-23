package ApiWeb.ApiTester.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestDto {
    private String url;
    private String method;  //Request methods receiver
    private String body;
    private Map<String, String> headers; // {key : value} "content-type" : "application/json"
}
