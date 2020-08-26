package Aircraft;

import FlyPlane.Flyable;
import FlyPlane.WeatherTower;
import WriteFiles.WriteFiles;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            WriteFiles.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : The Jet will be soaked");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            WriteFiles.WriteToFile("JetPlane#" + this.name  + "(" + this.id + ") : Wow snow in the Jet !!!!");
        }
        else if (weather.equals("SUN"))
        {
            this.coordinates.setLatitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            WriteFiles.WriteToFile("JetPlane#" + this.name  + "(" + this.id + ") : This Jet is melting hot!!!");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            WriteFiles.WriteToFile("JetPlane#" + this.name + "(" + this.id + ") : I cant see anything damn!!!");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            WriteFiles.WriteToFile("JetPlane#" + this.name + "(" + this.id + ")  landing");
            WriteFiles.WriteToFile("Tower says: " + "JetPlane#" + this.name + "("+this.id+")" + " Not registered from weather tower");
        }


    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFiles.WriteToFile("Tower says: " + "JetPlane#"+ this.name + "(" + this.id + ")" + " Registered to weather tower");
    }

}
