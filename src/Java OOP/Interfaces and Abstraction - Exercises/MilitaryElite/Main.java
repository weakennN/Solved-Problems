package InterfacesAndAbstraction.MilitaryElite;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, Private> privates = new TreeMap<>((l, r) -> r.compareTo(l));

        String command = scan.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");

            String com = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            if (com.equals("Private")) {

                double salary = Double.parseDouble(tokens[4]);

                System.out.println(addPrivate(privates, id, firstName, lastName, salary));
            } else if (com.equals("Commando")) {

                double salary = Double.parseDouble(tokens[4]);

                System.out.print(createCommando(id, firstName, lastName, salary, tokens[5], tokens));
            } else if (com.equals("LeutenantGeneral")) {

                double salary = Double.parseDouble(tokens[4]);

                List<Integer> ids = getIds(tokens);

                System.out.print(createLieutenantGeneral(privates, id, firstName, lastName, salary, ids));
            } else if (com.equals("Spy")) {

                System.out.println(createSpy(id, firstName, lastName, tokens[4]));
            } else if (com.equals("Engineer")) {
                double salary = Double.parseDouble(tokens[4]);

                System.out.print(createEngineer(id, firstName, lastName, salary, tokens[5], tokens));
            }

            command = scan.nextLine();
        }
    }

    public static String addPrivate(Map<Integer, Private> privates, int id, String firstName, String lasName, double salary) {

        Private priv = new Private(firstName, lasName, id, salary);
        privates.put(id, priv);

        return priv.toString();
    }

    public static String createCommando(int id, String firstName, String lastName, double salary, String corps, String[] tokens) {

        Commando commando = new Commando(firstName, lastName, id, salary, corps);

        if (Validator.validateCorps(corps)) {
            addMissions(commando, tokens);
        } else {
            commando.setCorps("");
        }


        return commando.toString();
    }

    public static String createLieutenantGeneral(Map<Integer, Private> privates, int id, String firstName, String lastName, double salary, List<Integer> ids) {

        LieutenantGeneral lieutenantGeneral = new LieutenantGeneral(firstName, lastName, id, salary);

        StringBuilder builder = new StringBuilder();

        builder.append(lieutenantGeneral.toString() + "\n");
        builder.append("Privates:" + "\n");

        for (Map.Entry<Integer, Private> entry : privates.entrySet()) {

            if (ids.contains(entry.getKey())) {
                builder.append("    " + entry.getValue().toString() + "\n");
            }
        }

        return builder.toString();
    }

    public static List<Integer> getIds(String[] tokens) {

        List<Integer> ids = new ArrayList<>();

        for (int i = 5; i < tokens.length; i++) {

            ids.add(Integer.parseInt(tokens[i]));
        }

        return ids;
    }

    public static String createSpy(int id, String firstName, String lastName, String codeNumber) {

        Spy spy = new Spy(firstName, lastName, id, codeNumber);

        return spy.toString();
    }

    public static String createEngineer(int id, String firstName, String lastName, double salary, String corps, String[] tokens) {
        StringBuilder builder = new StringBuilder();

        Engineer engineer = new Engineer(firstName, lastName, id, salary, corps);

        if (Validator.validateCorps(corps)) {
            addRepairs(engineer, tokens);
        } else {
            engineer.setCorps("");
        }

        builder.append(engineer.toString());
        return builder.toString();
    }

    public static void addRepairs(Engineer engineer, String[] tokens) {

        for (int i = 6; i < tokens.length; i += 2) {

            String repairName = tokens[i];
            int workedHours = Integer.parseInt(tokens[i + 1]);

            Repair repair = new Repair(repairName, workedHours);
            engineer.addRepair(repair);

        }
    }

    public static void addMissions(Commando commando, String[] tokens) {

        for (int i = 6; i < tokens.length; i += 2) {

            String missionName = tokens[i];
            String missionState = tokens[i + 1];

            if (!Validator.isMissionValid(missionState)) {
                continue;
            }

            Mission mission = new Mission(missionName, missionState);
            commando.addMission(mission);
        }
    }
}
