class Student {

    // Data members
    private final String name;
    private final int age;
    private final String course;

    // Constructor
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method
    public void displayDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }

    // Method
    public void study() {
        System.out.println(name + " is studying " + course + ".");
    }

    public static void main(String[] args) {

        // Creating an object
        Student student = new Student(
                "Sachin",
                21,
                "B.Tech Computer Science"
        );

        // Calling methods
        student.displayDetails();
        student.study();
    }
}