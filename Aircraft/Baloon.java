package Aircraft;

import FlyPlane.Flyable;
import FlyPlane.WeatherTower;
import WriteFiles.WriteFiles;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateCondition() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            WriteFiles.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : I a getting wet here , the rain is much ");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            WriteFiles.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : Its snowing here , and freezing here");
        } else if (weather.equals("SUN")) {
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
            WriteFiles.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : The sun is blazing hot!!!!");
        } else if (weather.equals("FOG")) {
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            WriteFiles.WriteToFile("Baloon#" + this.name + "(" + this.id + ") : I cant really seem to see anything ahead!!");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        else if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            WriteFiles.WriteToFile("Baloon#" + this.name + "(" + this.id + ")  landing");
            WriteFiles.WriteToFile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower");


        }
    }

        public void registerTower (WeatherTower weatherTower)
        {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            WriteFiles.WriteToFile("Tower says: " + "Baloon" + this.name + "#" + "(" + this.id + ")" + " registered to weather tower");
        }


}