package Aircraft;

import FlyPlane.Flyable;
import FlyPlane.WeatherTower;
import WriteFiles.WriteFiles;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates Coordinates)
    {
        super(name, Coordinates);
    }

    public void updateCondition()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
            WriteFiles.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : It is Rainy ");
        }
        else if (weather.equals("SNOW"))
        {
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            WriteFiles.WriteToFile("Helicopter#" + this.name + "(" + this.id + ") : There is Snow ahead");
        }
        else if(weather.equals("SUN"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            WriteFiles.WriteToFile("Helicopter#"+ this.name + "(" + this.id + ") : Its too sunny ahead");
        }
        else if (weather.equals("FOG"))
        {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
            WriteFiles.WriteToFile("Helicopter#" + this.name  + "(" + this.id + ") : The way too Foggy");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0)
        {
            this.weatherTower.unregister(this);
            WriteFiles.WriteToFile("Helicopter#" + this.name + "(" + this.id + ")  landing");
            WriteFiles.WriteToFile("Tower says: " + "Helicopter#" + this.name  +"("+this.id+")" + " Not registered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        WriteFiles.WriteToFile("Tower says: " + "Helicopter"+ this.name +"#" + "("+ this.id +")" + " registered to weather tower");
    }

}
