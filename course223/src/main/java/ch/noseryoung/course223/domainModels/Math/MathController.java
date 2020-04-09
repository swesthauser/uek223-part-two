package ch.noseryoung.course223.domainModels.Math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maths")
public class MathController {

    private MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("multiplication/{a}/{b}")
    public @ResponseBody
    ResponseEntity<Integer> multiply(@PathVariable int a, @PathVariable int b){
        return new ResponseEntity<>(mathService.multiplicate(a, b), HttpStatus.OK);
    }
}
