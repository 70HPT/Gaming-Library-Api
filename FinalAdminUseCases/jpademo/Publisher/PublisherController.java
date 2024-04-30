
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
        @Autowired
        private PublisherService publisherService;

        @GetMapping({"/all", "/", ""})
        public String getAllgames(Model model) {
            List<Publisher> publisherList = publisherService.getAllGames();
            model.addAttribute("gameList", publisherList);
            return "publisher/game-list";
        }

        @GetMapping("/id={gameId}")
        public String getGameById(@PathVariable Long gameId, Model model) {
            Publisher game = publisherService.getGameById(gameId);
            model.addAttribute("game", game);
            return "publisher/game-details";
        }

        @PostMapping("/create")
        public String createGame(@PathVariable Long gameId,String name) throws UnirestException {
            publisherService.createGame(gameId,name);
            return "redirect:/publisher/all";

        }

        @GetMapping("/delete/id={gameId}")
        public String deleteGame(@PathVariable("gameId")Long gameId,Model model) {
            publisherService.deleteGame(gameId);
            return "redirect:/publisher/all";
        }
}
