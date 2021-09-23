package IteratorsAndComparators.PetClinics;

public class Clinic {

    private String name;
    private Pet[] pets;
    private int counter = 0;
    private int countOfPets;

    public Clinic(int rooms) {
        this.pets = new Pet[rooms];
    }

    public Pet[] getPets() {
        return this.pets;
    }

    public boolean addPet(Pet pet) {

        if (countOfPets >= pets.length) {
            return false;
        }

        int mid = this.pets.length / 2;

        if (this.pets[mid] == null) {
            this.pets[mid] = pet;
            countOfPets++;
        } else {

            int indx = -1;

            if (++counter % 2 == 0) {
                indx = counter / 2;
            } else {
                indx = -(counter + 1) / 2;
            }

            int m = mid + indx;
            if (m < 0 || m >= this.pets.length) {

                return false;
            }
            pets[m] = pet;
            this.countOfPets++;
        }

        return true;

    }

    public String release() {

        if (this.countOfPets == 0) {
            return null;
        }

        int mid = this.pets.length / 2;

        boolean isFound = false;
        int releaseCounter = 0;
        while (!isFound) {

            if (releaseCounter + mid == this.pets.length) {
                mid = 0;
                releaseCounter = 0;
            }

            if (pets[mid + releaseCounter] != null) {
                String petName = pets[mid + releaseCounter].getName();
                pets[mid + releaseCounter] = null;
                this.countOfPets--;
                return petName;
            }
            releaseCounter++;
        }

        return null;
    }

    public boolean hasEmptyRooms() {

        return countOfPets > 0;
    }
}

