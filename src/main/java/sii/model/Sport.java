package sii.model;

public class Sport implements Comparable<Sport> {
    private String name;
    private Double proximityMeasure;

    public Sport(String name, Double proximityMeasure) {
        this.name = name;
        this.proximityMeasure = proximityMeasure;
    }

    @Override
    public int compareTo(Sport o) {
        return -proximityMeasure.compareTo(o.proximityMeasure);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + proximityMeasure.hashCode();
    }

    public Double getProximityMeasure() {
        return proximityMeasure;
    }
}
