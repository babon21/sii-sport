package sii.model;

public class Sport implements Comparable<Sport> {
    private String name;
    private Double proximityMeasure;
    private long competitionYear;
    private String country;
    private boolean isOlympic;
    private long popularity;
    private long minParticipants;
    private long minAge;

    public void setName(String name) {
        this.name = name;
    }

    public void setProximityMeasure(Double proximityMeasure) {
        this.proximityMeasure = proximityMeasure;
    }

    public long getCompetitionYear() {
        return competitionYear;
    }

    public void setCompetitionYear(long competitionYear) {
        this.competitionYear = competitionYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isOlympic() {
        return isOlympic;
    }

    public void setOlympic(boolean olympic) {
        isOlympic = olympic;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public long getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(long minParticipants) {
        this.minParticipants = minParticipants;
    }

    public long getMinAge() {
        return minAge;
    }

    public void setMinAge(long minAge) {
        this.minAge = minAge;
    }

    public Sport() {

    }

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
