package rsf2s1g2.client;

import java.util.Scanner;
import java.text.DecimalFormat;

import rsf2s1g2.utility.*;
import rsf2s1g2.adt.*;
import rsf2s1g2.entity.*;

public class facilities {
    public static void facilitiess(ListInterface<Facility> facilitySizeList, ListInterface<Facility> facilityColorList, ListInterface<Facility> facilityOccasionList,
                                   ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect, ListInterface<Accessories> facilityAccessoriesList, BagInterface<Accessories> facilityAccessoriesSelect) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner input = new Scanner(System.in);
        int choice, action, position = 1, quantity = 0;
        final int num4Bag = 10;

        do {
            Screen.clear();
            displayFacilities(sizeselect, colorselect, occasionselect);
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
                                    facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity);
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
                                        facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity);
                                    }
                                }
                                break;
                            case 3:
                               System.out.print("\t\tAll the facilities size will be removed! Ya sure? ");
                               System.out.println("1. YES");
                               System.out.println("2. NO");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !sizeselect.isEmpty()) {
                                   facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity);
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
                                       facilitiesChosenModify(sizeselect, facilitySizeList, action, position, quantity);
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
                                    facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity);
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
                                        facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity);
                                    }
                                }
                                break;
                            case 3:
                               System.out.print("\t\tAll the facilities color will be removed! Ya sure? (Y/N)");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !colorselect.isEmpty()) {
                                   facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity);
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
                                       facilitiesChosenModify(colorselect, facilityColorList, action, position, quantity);
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
                                    facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity);
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
                                        facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity);
                                    }
                                }
                                break;
                           case 3:
                               System.out.print("\t\tAll the facilities occasion will be removed! (1 == Yes) (2 == No)");
                               int confirm = input.nextInt();
                               if (confirm == 1 && !occasionselect.isEmpty()) {
                                   facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity);
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
                                       facilitiesChosenModify(occasionselect, facilityOccasionList, action, position, quantity);
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
                    // Accessories
                    do{
                        displayFacilitiesAccessoriesSelect(facilityAccessoriesSelect);
                        Accessories.displayAccesorries();
                        action = Screen.numInputValid(1,3,"\t\t\tSelect your Choice: ", "\t\t\tInvalid input. Please try again");
                        Screen.clear();
                        switch(action){
                            case 1: //add
                                displayAccesorriesList(facilityAccessoriesList);
                                position = Screen.numInputValid(1,4,"  Select Accesorries to Add (1-4): ", " Invalid input. Please try again");
                                if (facilityAccessoriesList.size() < position || position < 1) {
                                    Font.print(Font.RED_BOLD_BRIGHT,"\t\tInvalid choice!");
                                    cont();
                                } else {
                                    facilityAccessoriesSelect.add(new Accessories(facilityAccessoriesList.get(position).getAccName(), num4Bag));
                                    System.out.println("\tAdd Successful");
                                    cont();
                                }
                                break;
                            case 2: //clear
                                int confirm = Screen.numInputValid(0,1,"\t\tThe accessories cart will be clear. Are you sure? (1 = Yes, 0 = No): ", "\t\tInvalid input. Please try again");
                                if (confirm == 1 && !facilityAccessoriesSelect.isEmpty()){
                                    facilityAccessoriesSelect.clear();
                                    System.out.println("\t\tClear Successful");
                                    cont();
                                }
                                Screen.clear();
                                break; 
                            case 3: 
                                //Exit
                                break;
                        }
                    } while(action != 3);
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }

    public static void displayFacilities(ListInterface<Facility> sizeselect, ListInterface<Facility> colorselect, ListInterface<Facility> occasionselect) {
        String emptySize = "", emptyColor = "", emptyOccasion = "";
        if (sizeselect.isEmpty()) {
            emptySize = "(Empty)";
        }
        if (colorselect.isEmpty()) {
            emptyColor = "(Empty)";
        }
        if (occasionselect.isEmpty()) {
            emptyOccasion = "(Empty)";
        }
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ███████╗ █████╗  ██████╗██╗██╗     ██╗████████╗██╗███████╗███████╗ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██╔════╝██╔══██╗██╔════╝██║██║     ██║╚══██╔══╝██║██╔════╝██╔════╝ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t █████╗  ███████║██║     ██║██║     ██║   ██║   ██║█████╗  ███████╗ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██╔══╝  ██╔══██║██║     ██║██║     ██║   ██║   ██║██╔══╝  ╚════██║ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ██║     ██║  ██║╚██████╗██║███████╗██║   ██║   ██║███████╗███████║ ");
        Font.print(Font.ANSI_YELLOW, "\t\t\t\t\t ╚═╝     ╚═╝  ╚═╝ ╚═════╝╚═╝╚══════╝╚═╝   ╚═╝   ╚═╝╚══════╝╚══════╝ ");
        System.out.println("=================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t1. Size" + emptySize + "\n\t\t\t\t\t\t\t\t2. Color" + emptyColor + "\n\t\t\t\t\t\t\t\t3. Occasion" + emptyOccasion + "\n\t\t\t\t\t\t\t\t4. Accessories\n\t\t\t\t\t\t\t\t5. Exit");
        System.out.println("=================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t\t       Select your Choice: ");
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

    public static void displayAccesorriesList(ListInterface<Accessories> facilityAccessoriesList){
        Accessories.resetNum();
        System.out.println("======================================");
        System.out.println("\tACCESSORIES NAME ");
        System.out.println("======================================");
        System.out.print(facilityAccessoriesList.toString());
        System.out.println("======================================");
        System.out.println("\t10 per add");
        System.out.println("======================================");
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
        Font.print(Font.PURPLE_BOLD_BRIGHT, "\t\t\t\t\t\t\tFACILITIES COLOR CART");
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
            Font.print(Font.RED_BOLD_BRIGHT, "\t\t\t\t   NO FACILITIES COLOR CHOSEN");
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

    public static void displayFacilitiesAccessoriesSelect(BagInterface<Accessories> facilityAccessoriesSelect){
        Font.print(Font.PURPLE_BOLD_BRIGHT,"\t\t\t  ACCESSORIES CART");
        if(!facilityAccessoriesSelect.isEmpty()){
            Accessories.resetNum();
            System.out.println("====================================================================");
            System.out.println("\tACCESSORIES NAME \t\tQUANTITY");
            System.out.println("====================================================================");
            System.out.println(facilityAccessoriesSelect.toString());
            System.out.println("====================================================================");
            System.out.println("TOTAL ITEMS SELECTED = " + facilityAccessoriesSelect.getCurrentSize());
            System.out.println("====================================================================");
        } else {
            System.out.println("====================================================================");
            Font.print(Font.RED_BOLD_BRIGHT,"\t\t\tNO ACCESSORIES SELECTED");
            System.out.println("====================================================================");
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

    public static void facilitiesChosenModify(ListInterface<Facility> facilitiesModi, ListInterface<Facility> facilitiesList, int action, int index, int facilitiesNum) {
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