import de.ukoeln.idh.teaching.jml.ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Boolean on = true;
        // atm.run(); // Läuft bm nicht ;(
        do {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter [exit] to exit the program or a number to withdraw money");
            try {
                String cmd = reader.readLine();
                if (cmd.toLowerCase().equals("exit")){
                    on = false;
                } else {
                    int amount = Integer.parseInt(cmd);
                    int[] bills = atm.withdraw(amount);
                    System.out.println("Sank ju for wissdrawing wiss se deutsche bänk...");
                    System.out.println(atm.toNotes(bills));



                }
            } catch (IOException e) {
                e.printStackTrace();
                on = false;
            } catch (NumberFormatException e) {
                System.out.println("Not a number, please enter a number or exit the program.");
            } catch (RuntimeException e) {
                System.out.println("The number is invalid. Please enter an amount that is dividable by 5.");
            }
        }
        while (on);
        atm.withdraw(250);

    }
}
