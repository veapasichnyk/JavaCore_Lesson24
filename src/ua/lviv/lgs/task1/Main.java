package ua.lviv.lgs.task1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){
        Supplier<Integer> menu = ( ) -> {
            System.out.println("\n Введіть 1 щоб додати фракцію\n" +
                               " Введіть 2 щоб видалити конкретну фракцію\n" +
                               " Введіть 3 щоб вивести усі  фракції\n" +
                               " Введіть 4 щоб очистити конкретну фракцію\n" +
                               " Введіть 5 щоб вивести конкретну фракцію\n" +
                               " Введіть 6 щоб додати депутата в фракцію\n" +
                               " Введіть 7 щоб видалити депутата з фракції\n" +
                               " Введіть 8 щоб вивести список хабарників\n" +
                               " Введіть 9 щоб вивести найбільшого хабарника\n"

                              );
            Scanner scanner    = new Scanner(System.in);
            int     menuChoise = scanner.nextInt();

            return menuChoise;

        };

        while ( true ) {

            switch (menu.get()) {

                case 1: {
                    VerkhovnaRada.getInstance().addDelegateGroup();
                    break;
                }

                case 2: {
                    VerkhovnaRada.getInstance().removeDelegateGroup();
                    break;
                }

                case 3: {
                    VerkhovnaRada.getInstance().getAllDelegateGroups();
                    break;
                }

                case 4: {
                    VerkhovnaRada.getInstance().clearDelegateGroup();
                    break;
                }

                case 5: {
                    VerkhovnaRada.getInstance().getDelegateGroup();
                    break;
                }

                case 6: {
                    VerkhovnaRada.getInstance().addDelegateToDelegateGroup();
                    break;
                }

                case 7: {
                    VerkhovnaRada.getInstance().removeDelegateFromDelegateGroup();
                    break;
                }

                case 8: {
                    VerkhovnaRada.getInstance().getBribeTakersFromDelegateGroup();
                    break;
                }

                case 9: {
                    VerkhovnaRada.getInstance().getLargestBribeTakerFromDelegateGroup();
                    break;
                }

                default: {
                    System.out.println("Введіть число від 1 до 9!");
                    break;
                }
            }
        }
    }
}
