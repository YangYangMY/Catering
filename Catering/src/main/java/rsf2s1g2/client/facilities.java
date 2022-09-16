package rsf2s1g2.client;

import java.util.Scanner;
import java.text.DecimalFormat;
import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class facilities {
    public static void facilitiess(ListInterface<Facility> facilitySizeList, ListInterface<Facility> facilityColorList, ListInterface<Facility> facilityOccasionList,
                                   ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect, Bag<String> remarkBag) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);
        int choice, action, position = 1, quantity = 0;
        initialize(facilitySizeList, facilityColorList, facilityOccasionList);

        do {
            Screen.clear();
            displayFacilities();
            choice = input.nextInt();
            Screen.clear();
            switch (choice) {
                case 1:
                    do {
                        displayFacilitiesSizeChosen(sizeselect, df);
                        displayFacilitiesSizeOption();
                        action = input.nextInt();
                        Screen.clear();
                        switch (action) {
                            case 1:
                                displayFacilitiesSize(facilitySizeList);
                                position = input.nextInt();
                                if (facilitySizeList.size() < position || position < 1) {
                                    System.out.println("\t\tInvalid choice!");
                                    cont();
                                } else {
                                    System.out.println("\t How many do you want to add?");
                                    quantity = input.nextInt();
                                    facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity, remarkBag);
                                }
                                break;
                            case 2:
                                if (sizeselect.isEmpty()) {
                                    System.out.println("\t\tYou have not selected any facilities!");
                                    cont();
                                } else {
                                    displayFacilitiesSizeChosen(sizeselect, df);
                                    System.out.println("\t\tWhich facilities size do you want to remove?");
                                    position = input.nextInt();
                                    if (sizeselect.size() < position || position < 1) {
                                        System.out.println("\t\tInvalid choice!");
                                        cont();
                                    } else {
                                        facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity, remarkBag);
                                    }
                                }
                                break;
                            case 3:
                               System.out.print("\t\tAll the facilities size will be removed! Ya sure? ");
                               System.out.println("1. YES");
                               System.out.println("2. NO");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !sizeselect.isEmpty()) {
                                   facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity, remarkBag);
                               }
                               Screen.clear();
                               break;
                           case 4:
                               if (sizeselect.isEmpty()) {
                                   System.out.println("\t\tYou have not selected any facilities size!");
                                   cont();
                               } else {
                                   displayFacilitiesSizeChosen(sizeselect, df);
                                   System.out.print("\tSelect the item to be modified: ");
                                   position = input.nextInt();
                                   if (sizeselect.size() < position || position < 1) {
                                       System.out.println("\t\tInvalid choice!");
                                       cont();
                                   } else {
                                       System.out.print("\tEnter the new quantity: ");
                                       quantity = input.nextInt();
                                       facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity, remarkBag);
                                   }
                               }
                           case 5:
                               break;
                            default:
                                System.out.println("\t\tInvalid choice!");
                                cont();
                                break;
                        }
                    } while (action != 5);
                    break;
                case 2:
                    do {
                        displayFacilitiesColorChosen(colorselect, df);
                        displayFacilitiesColorOption();
                        action = input.nextInt();
                        Screen.clear();
                        switch (action) {
                            case 1:
                                displayFacilitiesColor(facilityColorList);
                                position = input.nextInt();
                                if (facilityColorList.size() < position || position < 1) {
                                    System.out.println("\t\tInvalid choice!");
                                    cont();
                                } else {
                                    System.out.println("\t How many do you want to add?");
                                    quantity = input.nextInt();
                                    facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity, remarkBag);
                                }
                                break;
                            case 2:
                                if (colorselect.isEmpty()) {
                                    System.out.println("\t\tYou have not selected any facilities color!");
                                    cont();
                                } else {
                                    displayFacilitiesColorChosen(colorselect, df);
                                    System.out.println("\t\tWhich facilities do you want to remove?");
                                    position = input.nextInt();
                                    if (colorselect.size() < position || position < 1) {
                                        System.out.println("\t\tInvalid choice!");
                                        cont();
                                    } else {
                                        facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity, remarkBag);
                                    }
                                }
                                break;
                            case 3:
                               System.out.print("\t\tAll the facilities color will be removed! Ya sure? (Y/N)");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !colorselect.isEmpty()) {
                                   facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity, remarkBag);
                               }
                               Screen.clear();
                               break;
                           case 4:
                               if (colorselect.isEmpty()) {
                                   System.out.println("\t\tYou have not selected any facilities!");
                                   cont();
                               } else {
                                   displayFacilitiesColorChosen(colorselect, df);
                                   System.out.print("\tSelect the item to be modified: ");
                                   position = input.nextInt();
                                   if (colorselect.size() < position || position < 1) {
                                       System.out.println("\t\tInvalid choice!");
                                       cont();
                                   } else {
                                       System.out.print("\tEnter the new quantity: ");
                                       quantity = input.nextInt();
                                       facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity, remarkBag);
                                   }
                               }
                               break;
                           case 5:
                               break;
                            default:
                                System.out.println("\t\tInvalid choice!");
                                cont();
                                break;
                        }
                    } while (action != 5);
                    break;
                case 3:
                    do {
                        displayFacilitiesOccasionChosen(occasionselect, df);
                        displayFacilitiesOccasionOption();
                        action = input.nextInt();
                        Screen.clear();
                        switch (action) {
                            case 1:
                                displayFacilitiesOccasion(facilityOccasionList);
                                position = input.nextInt();
                                if (facilityOccasionList.size() < position || position < 1) {
                                    System.out.println("\t\tInvalid choice!");
                                    cont();
                                } else {
                                    System.out.println("\t How many do you want to add?");
                                    quantity = input.nextInt();
                                    facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity, remarkBag);
                                }
                                break;
                            case 2:
                                if (occasionselect.isEmpty()) {
                                    System.out.println("\t\tYou have not selected any facilities!");
                                    cont();
                                } else {
                                    displayFacilitiesOccasionChosen(occasionselect, df);
                                    System.out.println("\t\tWhich facilities do you want to remove?");
                                    position = input.nextInt();
                                    if (occasionselect.size() < position || position < 1) {
                                        System.out.println("\t\tInvalid choice!");
                                        cont();
                                    } else {
                                        facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity, remarkBag);
                                    }
                                }
                                break;
                           case 3:
                               System.out.print("\t\tAll the facilities occasion will be removed! (1 == Yes) (2 == No)");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !occasionselect.isEmpty()) {
                                   facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity, remarkBag);
                               }
                               Screen.clear();
                               break;
                           case 4:
                               if (occasionselect.isEmpty()) {
                                   System.out.println("\t\tYou have not selected any facilities!");
                                   cont();
                               } else {
                                   displayFacilitiesOccasionChosen(occasionselect, df);
                                   System.out.print("\tSelect the item to be modified: ");
                                   position = input.nextInt();
                                   if (occasionselect.size() < position || position < 1) {
                                       System.out.println("\t\tInvalid choice!");
                                       cont();
                                   } else {
                                       System.out.print("\tEnter the new quantity: ");
                                       quantity = input.nextInt();
                                       facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity, remarkBag);
                                   }
                               }
                               break;
                           case 5:
                               break;
                            default:
                                System.out.println("\t\tInvalid choice!");
                                cont();
                                break;

                        }
                    } while (action != 5);
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }


    public static void displayFacilities() {
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ███████╗ █████╗  ██████╗██╗██╗     ██╗████████╗██╗███████╗███████╗ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██╔════╝██╔══██╗██╔════╝██║██║     ██║╚══██╔══╝██║██╔════╝██╔════╝ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t █████╗  ███████║██║     ██║██║     ██║   ██║   ██║█████╗  ███████╗ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██╔══╝  ██╔══██║██║     ██║██║     ██║   ██║   ██║██╔══╝  ╚════██║ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██║     ██║  ██║╚██████╗██║███████╗██║   ██║   ██║███████╗███████║ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝   ╚═╝   ╚═╝╚══════╝╚══════╝ ");
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Size\n\t\t\t\t\t\t\t\t2. Color\n\t\t\t\t\t\t\t\t3. Occasion\n\t\t\t\t\t\t\t\t4. Exit");
        System.out.println("=================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t\t       Select your Choice: ");
    }

    public static void initialize(ListInterface<Facility> facilitySizeList, ListInterface<Facility> facilityColorList, ListInterface<Facility> facilityOccasionList) {
        // Size lol
        facilitySizeList.add(new Facility("Small", 500.00));
        facilitySizeList.add(new Facility("Medium", 1000.00));
        facilitySizeList.add(new Facility("Large", 1500.00));
        // Color lmao
        facilityColorList.add(new Facility("Red", 50.00));
        facilityColorList.add(new Facility("Blue", 50.00));
        facilityColorList.add(new Facility("Green", 50.00));
        facilityColorList.add(new Facility("Yellow", 50.00));
        facilityColorList.add(new Facility("Orange", 50.00));
        facilityColorList.add(new Facility("Purple", 50.00));
        facilityColorList.add(new Facility("Pink", 50.00));
        facilityColorList.add(new Facility("Black", 50.00));
        facilityColorList.add(new Facility("White", 50.00));
        facilityColorList.add(new Facility("Brown", 50.00));
        //Occasion lmfao
        facilityOccasionList.add(new Facility("Birthday", 100.00));
        facilityOccasionList.add(new Facility("Wedding", 100.00));
        facilityOccasionList.add(new Facility("Graduation", 100.00));
        facilityOccasionList.add(new Facility("Baby Shower", 100.00));
        facilityOccasionList.add(new Facility("Anniversary", 100.00));
        facilityOccasionList.add(new Facility("Retirement", 100.00));
        facilityOccasionList.add(new Facility("Prom", 100.00));
        facilityOccasionList.add(new Facility("Christmas", 100.00));
        facilityOccasionList.add(new Facility("Thanksgiving", 100.00));
        facilityOccasionList.add(new Facility("Halloween", 100.00));
        facilityOccasionList.add(new Facility("Easter", 100.00));
        facilityOccasionList.add(new Facility("Valentine's Day", 100.00));
        facilityOccasionList.add(new Facility("New Year's Eve", 100.00));
    }

    public static void displayFacilitiesSize(ListInterface<Facility> facilitySizeList) {
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tFACILITY SIZE \t\tPRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(facilitySizeList.toString());
        System.out.println("=================================================================================================================================================");
        System.out.println("\tSELECT THE CANOPY SIZE PLSSS(1-3)");
    }

    public static void displayFacilitiesColor(ListInterface<Facility> facilityColorList) {
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tFACILITY COLOR \t\tPRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(facilityColorList.toString());
        System.out.println("=================================================================================================================================================");
        System.out.println("\tSELECT THE THEME COLOR CINCAI(1-10)");
    }

    public static void displayFacilitiesOccasion(ListInterface<Facility> facilityOccasionList) {
        Facility.resetNumber();
        System.out.println("=================================================================================================================================================");
        System.out.println("\tFACILITY OCCASION \t\tPRICE(RM)");
        System.out.println("=================================================================================================================================================");
        System.out.print(facilityOccasionList.toString());
        System.out.println("=================================================================================================================================================");
        System.out.println("\tSELECT THE OCCASION (1-13)");
    }

    public static void displayFacilitiesSizeChosen(ListInterface<Facility> sizeselect, DecimalFormat df) {
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES SIZE CART");
        if (!sizeselect.isEmpty()) {
            Facility.resetNumber();
            System.out.println("=================================================================================================================================================");
            System.out.println("\tSIZE \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
            System.out.println("=================================================================================================================================================");
            System.out.print(sizeselect.toString());
            System.out.println("=================================================================================================================================================");
            Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(sizeselect.get(1).getSizeFinaltotal()));
            System.out.println("=================================================================================================================================================");
        } else {
            System.out.println("=================================================================================================================================================");
            Font.print(Font.RED_BOLD_BRIGHT, "\t\t\t\t   NO FACILITIES SIZE CHOSEN");
        }
    }

    public static void displayFacilitiesColorChosen(ListInterface<Facility> colorselect, DecimalFormat df) {
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES COLOR & CHAIR CART");
        if (!colorselect.isEmpty()) {
            Facility.resetNumber();
            System.out.println("=================================================================================================================================================");
            System.out.println("\tCOLOR \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
            System.out.println("=================================================================================================================================================");
            System.out.print(colorselect.toString());
            System.out.println("=================================================================================================================================================");
            Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(colorselect.get(1).getColorFinaltotal()));
            System.out.println("=================================================================================================================================================");
        } else {
            System.out.println("=================================================================================================================================================");
            Font.print(Font.RED_BOLD_BRIGHT, "\t\t\t\t   NO FACILITIES COLOR & CHAIR CHOSEN");
        }
    }

    public static void displayFacilitiesOccasionChosen(ListInterface<Facility> occasionselect, DecimalFormat df) {
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES OCCASION CART");
        if (!occasionselect.isEmpty()) {
            Facility.resetNumber();
            System.out.println("=================================================================================================================================================");
            System.out.println("\tOCCASION \t\tQUANTITY  \tPRICE(RM)  \tTOTAL PRICE(RM)");
            System.out.println("=================================================================================================================================================");
            System.out.print(occasionselect.toString());
            System.out.println("=================================================================================================================================================");
            Font.print(Font.ANSI_YELLOW, "\t\t\t\t\tFINAL TOTAL \t\t" + df.format(occasionselect.get(1).getOccasionFinaltotal()));
            System.out.println("=================================================================================================================================================");
        } else {
            System.out.println("=================================================================================================================================================");
            Font.print(Font.RED_BOLD_BRIGHT, "\t\t\t\t   NO FACILITIES OCCASION CHOSEN");
        }
    }

    public static void displayFacilitiesSizeOption() {
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Add Size\n\t\t\t\t\t\t\t\t2. Remove Size\n\t\t\t\t\t\t\t\t3. Clear Cart\n\t\t\t\t\t\t\t\t4. Modify Quantity\n\t\t\t\t\t\t\t\t5. Back");
        System.out.println("=================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t\t       Select your Choice: ");

    }

    public static void displayFacilitiesColorOption() {
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Add Color\n\t\t\t\t\t\t\t\t2. Remove Color\n\t\t\t\t\t\t\t\t3. Clear Cart\n\t\t\t\t\t\t\t\t4. Modify Quantity\n\t\t\t\t\t\t\t\t5. Back");
        System.out.println("=================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t\t       Select your Choice: ");
    }

    public static void displayFacilitiesOccasionOption() {
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Add Occasion\n\t\t\t\t\t\t\t\t2. Remove Occasion\n\t\t\t\t\t\t\t\t3. Clear Cart\n\t\t\t\t\t\t\t\t4. Modify Quantity\n\t\t\t\t\t\t\t\t5. Back");
        System.out.println("=================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t\t       Select your Choice: ");
    }

    public static void facilitiesChosenModify(ListInterface<Facility> facilitiesModi, ListInterface<Facility> facilitiesList, int action, int index, int facilitiesNum, Bag<String> remark) {
        Scanner input = new Scanner(System.in);
        if (action == 1) {
            boolean isDuplicate = false;
            if (!facilitiesModi.isEmpty()) {
                for (int i = 1; i < facilitiesModi.size() + 1; i++) {
                    if (facilitiesList.get(index).getFacilityname().equals(facilitiesModi.get(i).getFacilityname())) {
                        System.out.println("\tFacilities already added");
                        cont();
                        isDuplicate = true;
                    }
                }
            }
            if (isDuplicate == false) {
                System.out.println("Any remarks?: ");
                String remarks = input.nextLine();
                remark.add(remarks);
                facilitiesModi.add(new Facility(facilitiesList.get(index).getFacilityname(), facilitiesList.get(index).getFacilityprice(), facilitiesNum));
                setFinalTotal(facilitiesModi, facilitiesList);
                System.out.println("\tFacilities added");
                cont();
            }
        } else if (action == 2) {
            if (index < 1 || index > facilitiesList.size()) {
                System.out.println("\tInvalid index");
                cont();
            } else {
                if(facilitiesModi.size() == 1){
                    if(facilitiesList.get(1).getFacilityname().equals("Small")){
                        facilitiesModi.get(index).setSizeFinaltotal(0);
                    } else if(facilitiesList.get(1).getFacilityname().equals("Red")){
                        facilitiesModi.get(index).setColorFinaltotal(0);
                    } else {
                        facilitiesModi.get(index).setOccasionFinaltotal(0);
                    }
                    facilitiesModi.clear();
                    System.out.println("\tRemove Successful");
                    cont();
                } else {
                    facilitiesModi.remove(index);
                    setFinalTotal(facilitiesModi, facilitiesList);
                    System.out.println("\tFacilities removed");
                    cont();
                }
            }
        } else if (action == 3) {
            if(facilitiesList.get(1).getFacilityname().equals("Small")){
                facilitiesModi.get(index).setSizeFinaltotal(0);
            } else if(facilitiesList.get(1).getFacilityname().equals("Red")){
                facilitiesModi.get(index).setColorFinaltotal(0);
            } else {
                facilitiesModi.get(index).setOccasionFinaltotal(0);
            }
            facilitiesModi.clear();
            System.out.println("\tFacilities cleared");
            cont();
        } else if (action == 4) {
            if (index < 1 || index > facilitiesList.size()) {
                System.out.println("\tInvalid index");
                cont();
            } else {
                facilitiesModi.set(index, new Facility(facilitiesList.get(index).getFacilityname(), facilitiesList.get(index).getFacilityprice(), facilitiesNum));
                setFinalTotal(facilitiesModi, facilitiesList);
                System.out.println("\tModify Successful");
                cont();
            }
        }
    }

    public static void setFinalTotal(ListInterface<Facility> facilitiesModi, ListInterface<Facility> facilitiesList) {
        if(facilitiesList.get(1).getFacilityname().equals("Small")){
            facilitiesModi.get(1).setSizeFinaltotal(0);
            for (int i = 1; i < facilitiesModi.size() + 1; i++) {
                facilitiesModi.get(1).setSizeFinaltotal(facilitiesModi.get(1).getSizeFinaltotal() + (facilitiesModi.get(i).getFacilityprice() * facilitiesModi.get(i).getFacilitynum()));
            }
        } else if(facilitiesList.get(1).getFacilityname().equals("Red")){
            facilitiesModi.get(1).setColorFinaltotal(0);
            for (int i = 1; i < facilitiesModi.size() + 1; i++) {
                facilitiesModi.get(1).setColorFinaltotal(facilitiesModi.get(1).getColorFinaltotal() + (facilitiesModi.get(i).getFacilityprice() * facilitiesModi.get(i).getFacilitynum()));
            }
        } else {
            facilitiesModi.get(1).setOccasionFinaltotal(0);
            for (int i = 1; i < facilitiesModi.size() + 1; i++) {
                facilitiesModi.get(1).setOccasionFinaltotal(facilitiesModi.get(1).getOccasionFinaltotal() + (facilitiesModi.get(i).getFacilityprice() * facilitiesModi.get(i).getFacilitynum()));
            }
        }
    }

    public static void cont() {
        Scanner input = new Scanner(System.in);
        System.out.print("\tPress enter to continue...");
        input.nextLine();
        Screen.clear();
    }
}