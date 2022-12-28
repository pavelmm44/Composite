public class Main {
    public static void main(String[] args){

        Registry hr = Registry.getRegistry();

        Manager ceo = null;
        try{
            ceo = new Manager("Mel", "Medarda", 5500, 210, 0);
            ceo.printemployee();
            hr.addWorker(ceo);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee salesHead = null;
        try{
            salesHead = new Employee("Jace", "Tallis", 3000, ceo.id);
            salesHead.printemployee();
            hr.addWorker(salesHead);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee marketingHead = null;
        try{
            marketingHead = new Employee("Victor", "Piltover", 1500, ceo.id);
            marketingHead.printemployee();
            hr.addWorker(marketingHead);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        Employee emp1 = null;
        try{
            emp1 = new Employee("Sabrina", "Spellman", 1000, salesHead.id);
            emp1.printemployee();
            hr.addWorker(emp1);
        } catch (FieldLengthLimitException e){
            System.out.println(e.getMessage());
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeInRegistryException e){
            System.out.println(e.getMessage());
        }

        ceo.add(salesHead);
        ceo.add(marketingHead);

        salesHead.add(emp1);

        System.out.println("\nEmployee List:");
        ceo.printemployee();
        for (Employee headEmployee : ceo.getSubordinates()) {
            System.out.print("  ");
            headEmployee.printemployee();

            for (Employee emp : headEmployee.getSubordinates()){
                System.out.print("       ");
                emp.printemployee();
            }
        }

    }
}