public class Monkey extends RescueAnimal{
    // Instance variable
    //private String breed;
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;


    // Constructor
    public Monkey(String name, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
    String tailLength, String height, String bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        settailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);

    }

    // Accessor Method
    // public String getBreed() {
    //     return breed;
    // }

    public String getTailLength() {
        return tailLength;
    }

    public String height() {
        return height;
    }

    public String bodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }



    // Mutator Method
    // public void setBreed(String breed) {
    //     this.breed = breed;
    // }

    public void settailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    //Only allows specefic species
    public void setSpecies(String species) {
        String[] allowedSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
    boolean isValid = false; //To set to true if species = allowed species
    for(String allowed : allowedSpecies) {
        if (species.equalsIgnoreCase(allowed)) {
            isValid = true;
            break;
        }
    }
    if (isValid) {
        this.species = species;
    } else {
        System.out.println("Invalid species");
    }
    }
}
