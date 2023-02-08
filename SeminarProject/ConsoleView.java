
import units.Vector2;

import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(40, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, 10)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position) {

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
                if (Main.whiteSide.get(i).heroHP() == 0)
                    str = "|" + AnsiColors.ANSI_RED + Main.whiteSide.get(i).getRole().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                else {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getRole().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (Main.darkSide.get(i).getPosition().isEquals(position) && !alive) {
                if (Main.darkSide.get(i).heroHP() == 0)
                    str = "|" + AnsiColors.ANSI_RED + Main.darkSide.get(i).getRole().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
                else
                    str = "|" + AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getRole().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex) {
        String str = "";

        if (Main.whiteSide.get(npcIndex).heroHP() == 0)
            str += "     " + AnsiColors.ANSI_RED + Main.whiteSide.get(npcIndex).getInfo() + AnsiColors.ANSI_RESET;
        else str += "     " + AnsiColors.ANSI_BLUE + Main.whiteSide.get(npcIndex).getInfo() + AnsiColors.ANSI_RESET;
        if (Main.darkSide.get(npcIndex).heroHP() == 0)
            str += "     " + AnsiColors.ANSI_RED + Main.darkSide.get(npcIndex).getInfo() + AnsiColors.ANSI_RESET;
        else str += "     " + AnsiColors.ANSI_GREEN + Main.darkSide.get(npcIndex).getInfo() + AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
