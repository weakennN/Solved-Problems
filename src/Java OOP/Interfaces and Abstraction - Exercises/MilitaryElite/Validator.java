package InterfacesAndAbstraction.MilitaryElite;

abstract class Validator {

    public static boolean validateCorps(String corps) {

        if (corps.equals("Airforces") || corps.equals("Marines")) {

            return true;
        }

        return false;
    }

    public static boolean isMissionValid(String missionState) {

        if (missionState.equals("Finished") || missionState.equals("inProgress")) {

            return true;
        }

        return false;
    }
}
