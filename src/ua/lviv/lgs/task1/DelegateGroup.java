package ua.lviv.lgs.task1;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DelegateGroup {
    private String delegateGroupName;

    public DelegateGroup ( String delegateGroupName ) {
        this.delegateGroupName = delegateGroupName;
    }

    public String getDelegateGroupName ( ) {
        return delegateGroupName;
    }

    ArrayList<Delegate> delegatesGroupArray = new ArrayList <Delegate> ( );

    public void addDelegate ( ) {
        Scanner scanner = new Scanner (System.in );
        System.out.println ( "Введіть прізвище депутата:" );
        String lastName = scanner.next ( );
        System.out.println ( "Введіть ім'я депутата:" );
        String firstName = scanner.next ( );
        System.out.println ( "Введіть вік депутата:" );
        int age = scanner.nextInt ( );
        System.out.println ( "Введіть вагу депутата:" );
        int weight = scanner.nextInt ( );
        System.out.println ( "Введіть ріст депутата:" );
        int height = scanner.nextInt ( );
        System.out.println ( "Чи бере депутат хабарі (true/false):" );
        boolean bribeTaker = scanner.nextBoolean ( );

        Delegate delegate = new Delegate ( lastName , firstName , age , bribeTaker , weight , height );

        if ( delegate.isBribeTaker ( ) ) {
            delegate.takeBribe ();
        }

        delegatesGroupArray.add ( delegate );
        System.out.println ( "Депутат " + delegate.toString () + " успішно доданий у фракцію");
    }

    Supplier <Delegate> getDelegate = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть прізвище депутата:");
        String lastname = scanner.next();
        System.out.println("Введіть ім'я депутата:");
        String firstname = scanner.next();

        return new Delegate(lastname, firstname);
    };

    public void removeDelegate() {
        Delegate DelegateTyped = getDelegate.get();

        Predicate<Delegate> isEqualSurnameName = delegate -> delegate.getLastName().equalsIgnoreCase(DelegateTyped.getLastName())
                                                             && delegate.getFirstName().equalsIgnoreCase(DelegateTyped.getFirstName());
        Optional<Delegate> delegateFound = delegatesGroupArray.stream().filter(isEqualSurnameName).findFirst();

        if (delegateFound.isPresent()) {
            delegatesGroupArray.remove(delegateFound.get());
            System.out.println("Депутат " + delegateFound.get().toString() + " успішно вилучений із фракції!");

        } else {
            System.out.println("Такого депутата у жодній із фракцій не знайдено!");
        }
    }

    public void getBribeTakers() {
        System.out.println("Депутати хабарники:");
        List<Delegate> bribeTakers = delegatesGroupArray.stream().filter(Delegate::isBribeTaker).collect(Collectors.toList());
        bribeTakers.forEach(System.out::println);
    }

    public void getLargestBribeTaker() {
        Comparator<Delegate> deputyBribeSizeComparator = (delegate1,
                                                        delegate2) -> (delegate1.getBribeSize() > delegate2.getBribeSize()) ? 1
                : (delegate1.getBribeSize() == delegate2.getBribeSize()) ? 0 : -1;
        Optional<Delegate> largestBribeTaker = delegatesGroupArray.stream().filter(Delegate::isBribeTaker)
                .max(deputyBribeSizeComparator);

        if (largestBribeTaker.isPresent()) {
            System.out.println("Найбільший хабарник фракції " + largestBribeTaker.get().toString() + ". Ганьба!");
        } else {
            System.out.println("У цієї фракції хабарників не має!");
        }
    }

    public void getAllDelegates() {
        System.out.println("Депутати даної фракції: ");
        delegatesGroupArray.forEach(System.out::println);
    }

    public void clearDelegatesGroup() {
        delegatesGroupArray.clear();
        System.out.println("Всі депутати успішно видалені із фракції!");
    }

}
