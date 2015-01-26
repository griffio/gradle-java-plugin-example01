package griffio;

@QueryEntity
public class Example {

    private Long id;

    public Example(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
