package hello;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    private static final String template = "Your name is: %s!";
    private final AtomicLong counter = new AtomicLong();
    private final String[] names = {"Carlos", "Pedro", "Luis", "Fabi", "Naila", "Joyce", "Rita"};

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/showmyname")
    public Name showMyName(@RequestParam(value="name", defaultValue="") String name) {
    	int rnd = new Random().nextInt(names.length);
    	if (name == null || name.equals("")){
    		name = names[rnd];
    	}
        return new Name(counter.incrementAndGet(),
                            String.format(template, name));
    }
}