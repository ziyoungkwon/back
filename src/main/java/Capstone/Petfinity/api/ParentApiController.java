package Capstone.Petfinity.api;

import Capstone.Petfinity.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParentApiController {

    private final ParentService parentService;

}
