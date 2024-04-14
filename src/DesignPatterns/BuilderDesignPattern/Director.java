package DesignPatterns.BuilderDesignPattern;
// this class direct what to create in builder pattern.
public class Director {
    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof  EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof  MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(1).setAge(20).setName("sj").setSubjects().build();
    }
    // it should return the student object not builder.
    private Student createMBAStudent() {
        return  studentBuilder.setRollNumber(2).setAge(24).setName("sj").setSubjects().build();
    }
}
