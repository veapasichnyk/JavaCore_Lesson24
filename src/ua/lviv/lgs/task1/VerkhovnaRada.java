package ua.lviv.lgs.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerkhovnaRada {

    private static VerkhovnaRada instance = new VerkhovnaRada();

    private VerkhovnaRada( ){
    }

    public static VerkhovnaRada getInstance( ){
        if ( instance == null ) {
            instance = new VerkhovnaRada();
        }

        return instance;
    }


    ArrayList <DelegateGroup> verkhovnaRadaArray = new ArrayList <DelegateGroup>();

    Supplier <DelegateGroup> getDelegateGroup = ( ) -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        return new DelegateGroup(delegateGroupName);
    };

    public void addDelegateGroup( ){
        DelegateGroup delegateGroup = getDelegateGroup.get();

        verkhovnaRadaArray.add(delegateGroup);
        System.out.println(delegateGroup.toString() + " успішно додана у Верховну Раду!");
    }

    public Optional <DelegateGroup> findDelegateGroup( ){
        DelegateGroup DelegateGroupTyped = getDelegateGroup.get();

        Predicate <DelegateGroup> isEqualDelegateGroupName = deputyGroup -> deputyGroup.getDelegateGroupName()
                .equalsIgnoreCase(DelegateGroupTyped.getDelegateGroupName());
        Optional <DelegateGroup> delegateGroupFound = verkhovnaRadaArray.stream().filter(isEqualDelegateGroupName).findFirst();

        return delegateGroupFound;
    }

    public void removeDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            verkhovnaRadaArray.remove(delegateGroupFound.get());
            System.out.println(delegateGroupFound.get().toString() + " успішно видалена із Верховної Ради!");
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getAllDelegateGroups( ){
        System.out.println("Фракції зареєстровані у Верховній Раді: ");
        verkhovnaRadaArray.forEach(System.out::println);
    }

    public void clearDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().clearDelegatesGroup();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            System.out.println(delegateGroupFound.get().toString());
            delegateGroupFound.get().getAllDelegates();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void addDelegateToDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().addDelegate();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void removeDelegateFromDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().removeDelegate();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getBribeTakersFromDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().getBribeTakers();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getLargestBribeTakerFromDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().getLargestBribeTaker();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getAllDelegatesFromDelegateGroup( ){
        Optional <DelegateGroup> delegateGroupFound = findDelegateGroup();

        if ( delegateGroupFound.isPresent() ) {
            delegateGroupFound.get().getAllDelegates();
        }else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

}
