package Aircraft;

public  abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCounter;
        this.idCounter = nextid();
    }
    private long nextid()
    {
        return (++idCounter);
    }

}
