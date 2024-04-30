
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllGames() {
        return publisherRepository.findAll();
    }
    public  Publisher getGameById(Long gameId){
        return publisherRepository.findById(gameId).orElse(null);
    }

    public void createGame(Long gameId,String name) throws UnirestException {
        Unirest Unirest = new Unirest();
        HttpResponse<JsonNode> jsonResponse = com.mashape.unirest.http.Unirest.post("https://api.igdb.com/v4/games")
                .header("Client-ID", "t9w2gzfb6jlin2fjpogijgdu9obxzu")
                .header("Authorization", "Bearer ddokcmni292c3px0wivso5ja133mx6")
                .header("Accept", "application/json")
                .body("fields name,where id = "+ gameId)
                .asJson();

    }

    public void deleteGame(Long gameId) {
        publisherRepository.deleteById(gameId);
    }

}
