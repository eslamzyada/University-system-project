import java.util.*;
public class Main {
    static LinkedList<Student> STD = new LinkedList<>();
    static LinkedList<Professor> PROF = new LinkedList<>();
    static Scanner myObj = new Scanner(System.in);
    public static void main(String[] args) {
        mainPage();
    }
    public static void mainPage(){
        char choose;
        System.out.println("Enter as an: " + '\n' +
                "A. Student" + '\n' +
                "B. Professor" +'\n' +
                "C. Employee" + '\n' +
                "D. Exit");
        choose = myObj.next().charAt(0);
            switch (choose) {
                case 'A':
                    studentPage();
                    break;
                case 'B':
                    professorPage();
                    break;
            /*    case 'C':
                    employeePage();
                    break;  */
                case 'D':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Insertion!, Please try again");
                    studentPage();
                    break;
            }
    }
    public static void studentPage(){
        char choose;
        System.out.println("make your choice: " + '\n' +
                "A. Student login" + '\n' +
                "B. Search Student" + '\n' +
                "C. Update data" + '\n' +
                "D. See all Students" + '\n' +
                "E. Delete a Student" + '\n' +
                "F. Back to main page" + '\n' +
                "G. Exit");
        choose = myObj.next().charAt(0);
            switch (choose) {
                case 'A':
                    studentLogin();
                    break;
                case 'B':
                    searchStudent();
                    break;
                 case 'C':
                    updateStudentData();
                    break;
                case 'D':
                    seeAllStudents();
                    break;
                case 'E':
                    deleteStudent();
                    break;
                case 'F':
                    mainPage();
                    break;
                case 'G':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Insertion!, please try again");
                    studentPage();
                    break;
            }
    }
    public static void professorPage(){
        char choice;
        System.out.println("Make your choice: " + '\n' +
                "A. Register to be a professor" + '\n' +
                "B. Sign in" + '\n' +
                "C. Update data" + '\n' +
                "D. Delete data" + '\n' +
                "E. Search professor" + '\n' +
                "F. Back to main page" + '\n' +
                "G. Exit");
        choice = myObj.next().charAt(0);
        switch (choice){
            case 'A':
                professorSignUp();
                break;
        /*    case 'B':
                professorLogin();
                break;  */
            case 'C':
                updateProfessorData();
                break;
            case 'D':
                deleteProfessor();
                break;
            case 'E':
                searchProfessor();
                break;
            case 'F':
                mainPage();
                break;
            case 'G':
                System.exit(0);
            default:
                System.out.println("Invalid insertion, Please try again.");
                professorPage();
                break;
        }
    }
    public static void professorSignUp(){
        System.out.println("Sign your data down there, If you want to cancel write (q/Q) anytime.");
        System.out.println("Enter your name: ");
        myObj.nextLine();
        String name = myObj.nextLine();
        signCanceling(name);
        String id = checkIDNumber();
        while (id.length() == 0){
            id = checkIDNumber();
        }
        signCanceling(id);
        System.out.println("Enter your address: ");
        String address = myObj.nextLine();
        signCanceling(address);
        System.out.println("Enter your degree (Bachelor, Master, phD): ");
        String degree = myObj.next();
        signCanceling(degree);
        System.out.println("Choose your department (Technology, Medical, Engineering): ");
        String department = myObj.next();
        signCanceling(department);
        List<Subject> subjects = chooseSubjects(department, degree);
        System.out.println("The assigned subjects for you: ");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(subjects.get(i));
        }
        double salary = computeSalary(department, degree, subjects);
        System.out.println("The professor's salary is: " + salary + "$");
        Professor p = new Professor(name, id, address, salary, subjects, department, degree);
        PROF.addFirst(p);
        System.out.println("Operation has done successfully");
        professorPage();
    }
    public static void studentLogin() {
        int totalHours = 0;
        System.out.println("Sign your data down there, If you want to cancel write (q/Q) anytime.");
        System.out.println("Enter your name: ");
        myObj.nextLine();
        String name = myObj.nextLine();
        signCanceling(name);
        String id = checkIDNumber();
        while (id.length() == 0) {
            id = checkIDNumber();
        }
        signCanceling(id);
        System.out.println("Enter your Address: ");
        String address = myObj.nextLine();
        signCanceling(address);
        System.out.println("Enter your GPA: ");
        String GPA = myObj.next();
        signCanceling(GPA);
        double doubleGPA = Double.parseDouble(GPA);
        while (doubleGPA < 0.0 || doubleGPA >= 4.0) {
            System.out.println("Invalid GPA. Please enter a value between 0.0 and 4.0");
            GPA = myObj.next();
            signCanceling(GPA);
            doubleGPA = Double.parseDouble(GPA);
        }
        System.out.println("The operation has been done successfully.");
        double GPADouble = Double.parseDouble(GPA);
        String hours = checkHours();
        int hoursInt = Integer.parseInt(hours);
        while (hoursInt < 9 || hoursInt >= 20) {
            System.out.println("You have not registered enough hours. Please try again.");
            hours = checkHours();
            hoursInt = Integer.parseInt(hours);
        }
        System.out.println("The operation has been done successfully.");
        System.out.println("How many subjects do you want to insert? ");
        String subNumber = myObj.next();
        signCanceling(subNumber);
        int intSubNumber = Integer.parseInt(subNumber);
        String[] subjects = new String[intSubNumber];
        int[] subjectHours = new int[intSubNumber];
        int y = 0;
        while (y < intSubNumber) {
            System.out.println("Enter subject name: ");
            myObj.nextLine();
            String sub = myObj.nextLine();
            subjects[y] = sub;
            System.out.println("Enter subject hours: ");
            int subHours = myObj.nextInt();
            while (subHours <= 0 || subHours >= 4) {
                System.out.println("Subject hours must be more than 0 and less than 4. Please try again.");
                subHours = myObj.nextInt();
            }
            if (totalHours + subHours > hoursInt) {
                System.out.println("Error: Cannot exceed the limit of " + hours + " hours.");
            } else {
                subjectHours[y] = subHours;
                totalHours += subHours;
                System.out.println("Subject '" + subjects[y] + "' added with " + subjectHours[y] + " hours. Total hours: " + totalHours);
                y++;
            }
        }
        String[][] subjectStore = new String[subjects.length][2];
        for (int i = 0; i < subjects.length; i++) {
            subjectStore[i][0] = subjects[i];
            subjectStore[i][1] = Integer.toString(subjectHours[i]);
        }
            System.out.println("your subjects: ");
            for (int i = 0; i < subjectStore.length; i++){
                System.out.println("subject: " + subjectStore[i][0] + ", Hours: " + subjectStore[i][1]);
                }
            System.out.println("Enter your college: ");
            myObj.nextLine();
            String college = myObj.nextLine();
            signCanceling(college);
            System.out.println("Enter your major: ");
            String major = myObj.nextLine();
            signCanceling(major);
            Student s = new Student(name, id, address, GPADouble, subjectStore, college, major, hoursInt);
            STD.addFirst(s);
            studentPage();
        }
    public static List<Subject> chooseSubjects(String degree, String department) {
        List<String> allSubjects = getAllSubjects(degree, department);
        List<Subject> subjects = new ArrayList<Subject>();
        Random random = new Random();
        int numSubjects = random.nextInt(4) + 2; // Random number between 2 and 5
        for (int i = 0; i < numSubjects && !allSubjects.isEmpty(); i++) {
            int index = random.nextInt(allSubjects.size());
            String subjectName = allSubjects.get(index);
            int creditHours = random.nextInt(3) + 2; // Random number between 2 and 4
            Subject subject = new Subject(subjectName, creditHours);
            subjects.add(subject);
            allSubjects.remove(index);
        }
        return subjects;
    }
    public static List<String> getAllSubjects(String department, String degree) {
        List<String> allSubjects = new ArrayList<String>();
        if(department.equalsIgnoreCase("Technology")) {
            if(degree.equalsIgnoreCase("Bachelor")) {
                allSubjects.add("Programming");
                allSubjects.add("Database");
                allSubjects.add("Networks");
                allSubjects.add("Web Development");
                allSubjects.add("Software Engineering");
                allSubjects.add("Data Structures and Algorithms");
                allSubjects.add("Computer Architecture");
                allSubjects.add("Operating Systems");
            }
            else if(degree.equalsIgnoreCase("Master")) {
                allSubjects.add("Advanced Programming");
                allSubjects.add("Data Science");
                allSubjects.add("Artificial Intelligence");
                allSubjects.add("Machine Learning");
                allSubjects.add("Computer Vision");
                allSubjects.add("Natural Language Processing");
                allSubjects.add("Distributed Systems");
                allSubjects.add("Cloud Computing");
            }
            else if(degree.equalsIgnoreCase("PhD")) {
                allSubjects.add("Research Methods");
                allSubjects.add("Scientific Writing");
                allSubjects.add("Thesis Supervision");
                allSubjects.add("Information Retrieval");
                allSubjects.add("Big Data Analytics");
                allSubjects.add("Data Mining");
                allSubjects.add("Computer Networks Security");
                allSubjects.add("Software Testing and Quality Assurance");
            }
        }
        else if(department.equalsIgnoreCase("Medical")) {
            if(degree.equalsIgnoreCase("Bachelor")) {
                allSubjects.add("Anatomy");
                allSubjects.add("Physiology");
                allSubjects.add("Pathology");
                allSubjects.add("Pharmacology");
                allSubjects.add("Microbiology");
                allSubjects.add("Biochemistry");
                allSubjects.add("Immunology");
                allSubjects.add("Medical Ethics");
                allSubjects.add("Clinical Skills");
                allSubjects.add("Internal Medicine");
                allSubjects.add("Surgery");
            }
            else if(degree.equalsIgnoreCase("Master")) {
                allSubjects.add("Public Health");
                allSubjects.add("Epidemiology");
                allSubjects.add("Health Policy");
                allSubjects.add("Health Promotion");
                allSubjects.add("Health Informatics");
                allSubjects.add("Global Health");
                allSubjects.add("Environmental Health");
                allSubjects.add("Occupational Health");
            }
            else if(degree.equalsIgnoreCase("PhD")) {
                allSubjects.add("Research Methodology");
                allSubjects.add("Clinical Research");
                allSubjects.add("Biostatistics");
                allSubjects.add("Health Economics");
                allSubjects.add("Health Services Research");
                allSubjects.add("Qualitative Research Methods");
                allSubjects.add("Systematic Review and Meta-Analysis");
                allSubjects.add("Community Health");
            }
        }
        else if(department.equalsIgnoreCase("Engineering")) {
            if(degree.equalsIgnoreCase("Bachelor")) {
                allSubjects.add("Statics");
                allSubjects.add("Dynamics");
                allSubjects.add("Thermodynamics");
                allSubjects.add("Materials Science");
                allSubjects.add("Fluid Mechanics");
                allSubjects.add("Mechanics of Materials");
                allSubjects.add("Manufacturing Processes");
                allSubjects.add("Mechanical Design");
                allSubjects.add("Electrical Circuits");
                allSubjects.add("Signals and Systems");
                allSubjects.add("Electronics");
                allSubjects.add("Digital Logic");
                allSubjects.add("Data Communications and Networking");
                allSubjects.add("Computer Programming");
                allSubjects.add("Software Engineering");
            }
            else if(degree.equalsIgnoreCase("Master")) {
                allSubjects.add("Advanced Mechanics of Materials");
                allSubjects.add("Robotics");
                allSubjects.add("Control Systems");
                allSubjects.add("Power Electronics");
                allSubjects.add("Digital Signal Processing");
                allSubjects.add("Embedded Systems");
                allSubjects.add("Computer Networks");
                allSubjects.add("Cloud Computing");
                allSubjects.add("CyberSecurity");
            }
            else if(degree.equalsIgnoreCase("PhD")) {
                allSubjects.add("Advanced Materials Science");
                allSubjects.add("Advanced Manufacturing Processes");
                allSubjects.add("Advanced Computational Mechanics");
                allSubjects.add("Advanced Control Systems");
                allSubjects.add("Advanced Power Electronics");
                allSubjects.add("Advanced Digital Signal Processing");
                allSubjects.add("Advanced Computer Networks");
                allSubjects.add("Advanced CyberSecurity");
            }
        }
        return allSubjects;
    }
    public static double computeSalary(String department, String degree, List<Subject> subjects) {
        double salary = 0;

        for (Subject subject : subjects) {
            int creditHours = subject.getCreditHours();
            double hourlyRate = 0;

            if (department.equalsIgnoreCase("Technology")) {
                if (degree.equalsIgnoreCase("Bachelor")) {
                    hourlyRate = 50;
                } else if (degree.equalsIgnoreCase("Master")) {
                    hourlyRate = 75;
                } else if (degree.equalsIgnoreCase("PhD")) {
                    hourlyRate = 100;
                }
            } else if (department.equalsIgnoreCase("Medical")) {
                if (degree.equalsIgnoreCase("Bachelor")) {
                    hourlyRate = 60;
                } else if (degree.equalsIgnoreCase("Master")) {
                    hourlyRate = 80;
                } else if (degree.equalsIgnoreCase("PhD")) {
                    hourlyRate = 110;
                }
            } else if (department.equalsIgnoreCase("Engineering")) {
                if (degree.equalsIgnoreCase("Bachelor")) {
                    hourlyRate = 50;
                } else if (degree.equalsIgnoreCase("Master")) {
                    hourlyRate = 75;
                } else if (degree.equalsIgnoreCase("PhD")) {
                    hourlyRate = 100;
                }
            }
            salary += creditHours * hourlyRate;
        }
        return salary + 1000;
    }
    public static String checkHours() {
        System.out.println("How many hours: ");
        String hours = myObj.next();
        signCanceling(hours);
        return hours;
    }
    public static String checkIDNumber() {
        System.out.print("Enter your ID number: ");
        String idNumber = myObj.nextLine();
        boolean hasCapitalLetter = false;
        boolean hasSymbol = false;
        boolean hasNumber = false;
        // Check if the ID number has at least one capital letter, one symbol, and one number
        for (int i = 0; i < idNumber.length(); i++) {
            char c = idNumber.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSymbol = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (hasCapitalLetter && hasSymbol && hasNumber) {
                break;
            }
        }
        if (idNumber.length() >= 8 && hasCapitalLetter && hasSymbol && hasNumber) {
            System.out.println("ID number accepted");
            return idNumber;
        } else {
            System.out.println("ID number must have at least 8 characters and include one capital letter, one symbol, and one number");
            return checkIDNumber();
        }
    }
    public static void signCanceling(String quit){
        if (quit.equalsIgnoreCase("q")){
            mainPage();
        }
    }
    public static void searchStudent() {
        String sId;
        System.out.println("Enter student id: ");
        sId = myObj.next();
        boolean found = false;
        for (int i = 0; i < STD.size(); i++) {
            if (sId.equalsIgnoreCase(STD.get(i).getId())) {
                System.out.println(STD.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("There is no Student with this id number!");
        }
        studentPage();
    }
    public static void searchProfessor() {
        String pID;
        boolean found = false;
        System.out.println("Enter professor id: ");
        pID = myObj.next();
        for (int i = 0; i < PROF.size(); i++) {
            if (pID.equalsIgnoreCase(PROF.get(i).getId())) {
                System.out.println(PROF.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("There is no professor with this id number!");
        }
        professorPage();
    }
    public static void seeAllStudents(){
        if (STD.size() == 0) {
            System.out.println("There are no students in the system!");
        } else {
            for (int i = 0; i < STD.size(); i++) {
                System.out.println(STD.get(i));
            }
        }
        studentPage();
    }
    public static void deleteStudent() {
        String sId;
        System.out.println("Enter student id: ");
        sId = myObj.next();
        boolean found = false;
        for (int i = 0; i < STD.size(); i++) {
            if (sId.equalsIgnoreCase(STD.get(i).getId())) {
                STD.remove(i);
                found = true;
                System.out.println("The operation has done successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("There is no student with this ID number.");
        }
        studentPage();
    }
    public static void deleteProfessor() {
        String pId;
        System.out.println("Enter professor id: ");
        pId = myObj.next();
        boolean found = false;
        for (int i = 0; i < PROF.size(); i++) {
            if (pId.equalsIgnoreCase(PROF.get(i).getId())) {
                PROF.remove(i);
                found = true;
                System.out.println("The operation has done successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("There is no student with this ID number.");
        }
        professorPage();
    }
    public static void updateStudentData(){
        String sId;
        System.out.println("Enter student id: ");
        sId = myObj.next();
        boolean found = false;
        for (int i = 0; i < STD.size(); i++) {
            if (sId.equalsIgnoreCase(STD.get(i).getId())) {
                found = true;
                char choose;
                System.out.println("What do you want to update: " + '\n' +
                        "A. Student name" + '\n' +
                        "B. Student id" + '\n' +
                        "C. Student address" + '\n' +
                        "D. Back" + '\n' +
                        "E. Exit");
                choose = myObj.next().charAt(0);
                switch (choose){
                    case 'A':
                        System.out.println("Enter your name: ");
                        myObj.nextLine();
                        String name = myObj.nextLine();
                        STD.get(i).setName(name);
                        System.out.println("Name has been updated successfully");
                        break;
                    case 'B':
                        System.out.println("Enter your id: ");
                        String id = myObj.next();
                        STD.get(i).setId(id);
                        System.out.println("ID has been updated successfully");
                        break;
                    case 'C':
                        System.out.println("Enter your address: ");
                        myObj.nextLine();
                        String address = myObj.nextLine();
                        STD.get(i).setAddress(address);
                        System.out.println("Address has been updated successfully");
                        break;
                    case 'D':
                        studentPage();
                        break;
                    case 'E':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid insertion!, Please try again");
                        break;
                }
        } if(!found)
                System.out.println("There is no Student with this id number!");
        }
        studentPage();
    }
    public static void updateProfessorData(){
        String Id;
        System.out.println("Enter professor ID: ");
        Id = myObj.next();
        boolean found = false;
        for (int i = 0; i < PROF.size(); i++) {
            if (Id.equalsIgnoreCase(PROF.get(i).getId())) {
                found = true;
                char choose;
                System.out.println("What do you want to update: " + '\n' +
                        "A. Professor name" + '\n' +
                        "B. Professor id" + '\n' +
                        "C. Professor address" + '\n' +
                        "D. Back" + '\n' +
                        "E. Exit");
                choose = myObj.next().charAt(0);
                switch (choose){
                    case 'A':
                        System.out.println("Enter your name: ");
                        myObj.nextLine();
                        String name = myObj.nextLine();
                        PROF.get(i).setName(name);
                        System.out.println("Name has been updated successfully");
                        break;
                    case 'B':
                        System.out.println("Enter your id: ");
                        String id = myObj.next();
                        PROF.get(i).setId(id);
                        System.out.println("ID has been updated successfully");
                        break;
                    case 'C':
                        System.out.println("Enter your address: ");
                        myObj.nextLine();
                        String address = myObj.nextLine();
                        PROF.get(i).setAddress(address);
                        System.out.println("Address has been updated successfully");
                        break;
                    case 'D':
                        professorPage();
                        break;
                    case 'E':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid insertion!, Please try again");
                        break;
                }
            } if(!found)
                System.out.println("There is no Professors with this ID number!");
        }
        professorPage();
    }
}