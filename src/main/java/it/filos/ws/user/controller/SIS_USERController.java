package it.filos.ws.user.controller;

import it.filos.ws.user.resources.SIS_USER;
import it.filos.ws.user.repo.SIS_USERRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user")
public class SIS_USERController {

    Logger logger = LoggerFactory.getLogger(SIS_USERController.class);

    @Autowired
    private SIS_USERRepository repo;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addUser(@RequestParam String username, @RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        SIS_USER usr = new SIS_USER();
        usr.setUsername(username);
        usr.setName(name);

        String pwd = "";
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int ascii_char = 48 + rnd.nextInt(43);
            pwd += (char) ascii_char;
        }
        usr.setPassword(pwd);

        repo.save(usr);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<SIS_USER> getAll() {

        logger.info("Count: " + repo.count());

        return repo.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<SIS_USER> getByID(@PathVariable int id) {
        logger.info("/ " + id);
        return repo.findById(id);
    }
}
