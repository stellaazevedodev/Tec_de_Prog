package fatec.example.musicas.models;

public class Music {
    // atributos
    private Long id;
    private String name;
    private String artist;
    private String album;
    private int year;

    //expondo em metodos publicos
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // construtor vazio
    public Music() {
    }

    //construtor parcial
    public Music(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    //construtor completo
    public Music(Long id, String name, String artist, String album, int year) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }
}
