package org.sagi.cowfarm;

import org.sagi.cowfarm.modulus.Cow;
import org.sagi.cowfarm.modulus.FarmList;

import java.util.Scanner;

public class FarmManagerApp {
    FarmList farmList = new FarmList();

    public static void main(String[] args) {

        FarmManagerApp fma = new FarmManagerApp();
        fma.addCow(0, 0, "RootCow");
        fma.addCow(0, 1, "cowA");
        fma.addCow(0, 2, "cowB");
        fma.addCow(1, 11, "cowAA-1");
        fma.addCow(1, 12, "cowAA-2");
        fma.addCow(11, 111, "cowAA-11");
        fma.printFarmInfo();
        fma.removeCow(1);
        fma.printFarmInfo();
        fma.addCow(2, 21, "cowBB-1");
        fma.addCow(21, 211, "cowBBB-1");
        fma.printFarmInfo();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select action: ");
            System.out.println("Add calf [1]: ");
            System.out.println("Remove cow [2]: ");
            System.out.println("Print info [3]: ");
            System.out.println("Exit [q]: ");

            String input = scanner.nextLine();
            input = input.toLowerCase();
            try {
                switch (input) {
                    case "q":
                        scanner.close();
                        System.exit(0);
                        break;
                    case "1":
                        System.out.print("Please specify Cow mother id: ");
                        int motherId = scanner.nextInt();
                        System.out.print("Please specify Calf id: ");
                        int calfId = scanner.nextInt();
                        System.out.print("Please specify Calf nickName: ");
                        String nickName = scanner.nextLine();

                        fma.addCow(motherId,calfId, nickName);

                        break;
                    case "2":
                        System.out.print("Please specify Cow id: ");
                        int cowId = scanner.nextInt();
                        fma.removeCow(cowId);
                        break;
                    case "3":
                        fma.printFarmInfo();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Oops, it's look like we have a problem. Please verify you input correct values!");
            }
        }
    }

    public void addCow(int motherId, int cowId, String nickName) {

        Cow calf = new Cow();
        calf.setId(cowId);
        calf.setNickName(nickName);
        farmList.addCow(motherId, calf);
    }

    public void removeCow(int cowId) {
        farmList.removeCow(cowId);
    }

    public void printFarmInfo() {
        System.out.println("Generation-0\t|Generation-1\t|Generation-2\t|Generation-3");
        farmList.printFarmReport();
        System.out.println("-------------------------------------------------------------------------------");
    }
}
