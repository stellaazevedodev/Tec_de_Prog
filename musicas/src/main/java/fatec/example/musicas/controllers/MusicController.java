package fatec.example.musicas.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//use a classe Product para criar os objetos que serao retornados pela API
import fatec.example.musicas.models.Music;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/musicas")

public class MusicController {

    private ArrayList<Music> musics = new ArrayList<>();

    public MusicController() {
        //usando metodo construtor completo
        Music m1 = new Music(1L, "Until I Found You", "Stephen Sanchez", "Easy on My Eyes", 2021);
        Music m2 = new Music(2L, "As It Was", "Harry Styles", "Harry's House", 2022);
        Music m3 = new Music(3L, "Bad Habit", "Steve Lacy", "Gemini Rights", 2022);
        Music m4 = new Music(4L, "Easy on My Eyes", "Stephen Sanchez", "Easy on My Eyes", 2021);
        Music m5 = new Music(5L, "Shivers", "Ed Sheeran", "=", 2021);

        //usando metodo construtor vazio
        Music m6 = new Music();
        m6.setName("Sinais");
        m6.setArtist("Luan Santana");

        // usando metodo construtor parcial
        Music m7 = new Music("Golden Hour", "JVKE");

        musics.add(m1);
        musics.add(m2);
        musics.add(m3);
        musics.add(m4);
        musics.add(m5);
        musics.add(m6);
        musics.add(m7);
    }

    // pesquisa por ID
    @GetMapping("/{id}")
    public Music getMusicById(@PathVariable long id) {
        return musics.stream() // olha item por item da lista de musicas
                .filter(m -> m.getId() == id)
                .findFirst() // Devolve o primeiro que encontrar
                .orElse(null);// se não encontrar nenhum produto com o id fornecido, retorna null
    }

    @GetMapping
    public ArrayList<Music> getMusics() {
        return musics;
    }
}
