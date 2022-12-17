package PartFour;

public class TaskThree {

    private String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder stringBuilder = new StringBuilder();

        for (String role : roles) {
            stringBuilder.append(role + ":\n");

            for (int i = 0; i < textLines.length; i++) {
                String line = textLines[i];
                String pattern = role + ": ";

                if (line.startsWith(pattern)) {
                    stringBuilder.append(i + 1 + ") " + line.replaceFirst(pattern, "") + "\n");
                }
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
