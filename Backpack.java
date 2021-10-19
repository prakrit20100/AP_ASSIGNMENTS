import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;


interface Common{

    default void ViewLectureMaterials(Backpack obj){

        System.out.println("ALL SLIDES");
        for(int k = 0;k<obj.getAllLectureSlides().size();k++){
            System.out.println("Title: "+obj.getAllLectureSlides().get(k).getTitle());
            for (int k1=0;k1<obj.getAllLectureSlides().get(k).getContentofEachSLide().size();k1++){
                System.out.println("Slide "+(k1+1)+":"+obj.getAllLectureSlides().get(k).getContentofEachSLide().get(k1));
            }
            System.out.println("Number of slides : "+obj.getAllLectureSlides().get(k).getNumberofslides());
            System.out.println("Uploaded by:"+obj.getAllLectureSlides().get(k).getUploadedBy());
            System.out.println("Uploaded at:"+obj.getAllLectureSlides().get(k).getDateUploaded());
            System.out.println("\n\n");
        }
        System.out.println("ALL VIDEOS");
        for(int h=0;h<obj.getAllLectureVideos().size();h++){
            System.out.println("Title : "+obj.getAllLectureVideos().get(h).getTitle());
            System.out.println("Video File:"+obj.getAllLectureVideos().get(h).getFilename());
            System.out.println("Uploaded by:"+obj.getAllLectureVideos().get(h).getUploadedBy());
            System.out.println("Uploaded at:"+obj.getAllLectureVideos().get(h).getDateUploaded());
            System.out.println("\n\n\n");
        }

    }

    default void ViewAssessments(Backpack obj){
        for(int y=0;y<obj.getAllAssessments().size();y++){
            System.out.println("ID:"+obj.getAllAssessments().get(y).getId()+" "+obj.getAllAssessments().get(y).getType()+":"+obj.getAllAssessments().get(y).getQuestion()+" "+"Max Marks:"+obj.getAllAssessments().get(y).getMaxMarks());
            System.out.println("/n---------------");
        }

    }
    default void AddComments(Backpack obj,String toAdd,Date date,String AddedBy){

        obj.getAllComments().add(toAdd);
        obj.getCommentEnteredBy().add(AddedBy);
        obj.getCommentEnteredAt().add(date);


    }

    default void ViewComments(Backpack obj){
        for (int j=0;j<obj.getAllComments().size();j++){
            System.out.println(obj.getAllComments().get(j)+"-"+obj.getCommentEnteredBy().get(j));
            System.out.println(obj.getCommentEnteredAt().get(j));
            System.out.println("\n\n");
        }

    }

}

class Instructor implements Common{
    private String name;
    private int id;
    public Instructor(int _ID,String _name){
        id = _ID;
        name = _name;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int _id){
        id = _id;
    }
    public void displayInstructorMenu(){
        System.out.println("1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout\n");
    }


}

class Student implements Common{
    private int id;
    private String name;
    private LinkedList<Assessment> PendingAssessments = new LinkedList<Assessment>();
    private LinkedList<Assessment> UngradedAssessments = new LinkedList<Assessment>();
    private LinkedList<Assessment> GradedAssessments = new LinkedList<Assessment>();
    private LinkedList<String> answersSubmitted = new LinkedList<String>();
    private LinkedList<Integer> MarksofAssessments = new LinkedList<Integer>();
    private LinkedList<String> AssessmentCheckedby = new LinkedList<String>();

    public Student(int _ID,String _name){
        id = _ID;
        name = _name;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Assessment> getPendingAssessments() {
        return PendingAssessments;
    }

    public LinkedList<Assessment> getUngradedAssessments() {
        return UngradedAssessments;
    }

    public LinkedList<Assessment> getGradedAssessments() {
        return GradedAssessments;
    }

    public LinkedList<String> getAnswersSubmitted() {
        return answersSubmitted;
    }
    public LinkedList<Integer> getMarksofAssessments(){
        return MarksofAssessments;
    }
    public LinkedList<String> getAssessmentCheckedby(){
        return AssessmentCheckedby;
    }


    public void setId(int _id){
        id = _id;
    }
    public void displayStudentMenu(){
        System.out.println("1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout\n");
    }



}

class LectureSlide{
    private String title;
    private int numberofslides;
    private LinkedList<String> ContentofEachSLide = new LinkedList<String>();
    private String UploadedBy = new String();
    private Date DateUploaded = new Date();
    public String getTitle(){
        return title;
    }
    public int getNumberofslides(){
        return numberofslides;
    }
    public LinkedList<String> getContentofEachSLide(){
        return ContentofEachSLide;
    }

    public String getUploadedBy() {
        return UploadedBy;
    }

    public Date getDateUploaded() {
        return DateUploaded;
    }

    public void setDateUploaded(Date _dateUploaded) {
        DateUploaded = _dateUploaded;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public void setNumberofslides(int _numberofslides) {
        numberofslides = _numberofslides;
    }

    public void setUploadedBy(String _uploadedBy) {
        UploadedBy = _uploadedBy;
    }
}

class LectureVideo{
    private String title;
    private String filename;
    private String UploadedBy;
    private Date DateUploaded = new Date();

    public String getTitle() {
        return title;
    }

    public String getFilename() {
        return filename;
    }

    public String getUploadedBy() {
        return UploadedBy;
    }
    public Date getDateUploaded() {
        return DateUploaded;
    }

    public void setDateUploaded(Date _dateUploaded) {
        DateUploaded = _dateUploaded;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public void setFilename(String _filename) {
        filename = _filename;
    }

    public void setUploadedBy(String _uploadedBy) {
        UploadedBy = _uploadedBy;
    }
}

class Course{

}

class Assessment{
    private String type;
    private String question;
    private int MaxMarks;
    private static int idcounter;
    private int id;
    private boolean ClosedorNot;


    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public int getMaxMarks() {
        return MaxMarks;
    }

    public int getId() {
        return id;
    }

    public boolean isClosedorNot() {
        return ClosedorNot;
    }

    public void setClosedorNot(boolean _closedorNot) {
        ClosedorNot = _closedorNot;
    }

    public void setType(String _type) {
        type = _type;
    }

    public void setQuestion(String _question) {
        question = _question;
    }

    public void setMaxMarks(int _maxMarks) {
        MaxMarks = _maxMarks;
    }

    public void setId() {
        id=idcounter++;
    }
}





public class Backpack {
    private LinkedList<LectureSlide> AllLectureSlides = new LinkedList<LectureSlide>();
    private LinkedList<LectureVideo> AllLectureVideos = new LinkedList<LectureVideo>();
    private LinkedList<Assessment> AllAssessments = new LinkedList<Assessment>();
    private LinkedList<String> AllComments = new LinkedList<String>();
    private LinkedList<String> CommentEnteredBy = new LinkedList<String>();
    private LinkedList<Date> CommentEnteredAt = new LinkedList<Date>();

    public LinkedList<LectureSlide> getAllLectureSlides() {
        return AllLectureSlides;
    }

    public LinkedList<LectureVideo> getAllLectureVideos() {
        return AllLectureVideos;
    }

    public LinkedList<Assessment> getAllAssessments() {
        return AllAssessments;
    }

    public LinkedList<String> getAllComments() {
        return AllComments;
    }

    public LinkedList<String> getCommentEnteredBy() {
        return CommentEnteredBy;
    }

    public LinkedList<Date> getCommentEnteredAt() {
        return CommentEnteredAt;
    }


    public static void MainMenu(){
        System.out.println("1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit\n");
    }

    public static void main(String[] args) {
        Backpack obj = new Backpack();
        Scanner sc = new Scanner(System.in);
        Instructor I0 = new Instructor(0,"I0");
        Instructor I1 = new Instructor(1,"I1");
        LinkedList<Instructor> ListofAllInstructors = new LinkedList<Instructor>();
        ListofAllInstructors.add(I0);
        ListofAllInstructors.add(I1);
        Student S0 = new Student(0,"S0");
        Student S1 = new Student(1,"S1");
        Student S2 = new Student(2,"S2");
        LinkedList<Student> ListofAllStudents = new LinkedList<Student>();
        ListofAllStudents.add(S0);
        ListofAllStudents.add(S1);
        ListofAllStudents.add(S2);

        int choice = 0;
        int choiceforInstructor;
        int choiceforInstructortoPick;
        int choiceforStudent;
        int choiceforStudenttoPick;

        int choicetoaddlecturematerial;
        String titleoflecslide = new String();
        int numberofslides;
        String contentofeachslide = new String();
        String titleforvideo= new String();
        String videofilename = new String();
        Date toSet = new Date();

        int choicetoaddAssessment;
        String AssignmentProblem = new String();
        int AssignmentMaxMarks;
        String QuizQuestion = new String();

        int idforAssessment;
        Assessment toSubmit;
        String filenametosubmit = new String();
        String QuizAnswer = new String();
        LinkedList<Assessment> PossibleAssessmentstoSubmit = new LinkedList<Assessment>();

        int idtoevaluate;
        int idofstudent;
        int markstogive;

        int idtoclose;

        int indextofind=0;

        String CommentbyInstructor = new String();
        Date date = new Date();

        String CommentbyStudent = new String();
        Date date2 = new Date();






        while (choice!=3){
            MainMenu();
            System.out.println("\n");
            System.out.print("Choose your choice: ");
            choice = sc.nextInt();
            if(choice==1){
                System.out.println("Instructors:");
                for (int i=0;i<ListofAllInstructors.size();i++){
                    System.out.println(i+"-"+ListofAllInstructors.get(i).getName());
                }
                System.out.print("Choose id:");
                choiceforInstructor = sc.nextInt();
                System.out.println("");
                Instructor chosenInstructor = ListofAllInstructors.get(choiceforInstructor);
                System.out.println("Welcome "+chosenInstructor.getName());
                chosenInstructor.displayInstructorMenu();
                System.out.print("Choose choice :");
                choiceforInstructortoPick = sc.nextInt();
                System.out.println("");
                while (choiceforInstructortoPick!=9){
                    if (choiceforInstructortoPick==1){

                        System.out.println("1. Add Lecture Slides");
                        System.out.println("2. Add Lecture Videos");
                        System.out.print("Enter choice:");
                        choicetoaddlecturematerial=sc.nextInt();
                        if (choicetoaddlecturematerial==1){
                            LectureSlide lectureSlide = new LectureSlide();
                            System.out.print("Enter topic of lecture slides:");
                            sc.nextLine();
                            titleoflecslide= sc.nextLine();
                            lectureSlide.setTitle(titleoflecslide);
                            System.out.println(" ");
                            System.out.print("Enter number of slides: ");
                            numberofslides=sc.nextInt();
                            lectureSlide.setNumberofslides(numberofslides);
                            System.out.println(" ");
                            System.out.println("Enter content of slides: ");
                            sc.nextLine();
                            for(int j=0;j<numberofslides;j++) {
                                System.out.print("Enter content for slide " + (j + 1) + ":");

                                contentofeachslide = sc.nextLine();
                                lectureSlide.getContentofEachSLide().add(contentofeachslide);
                                System.out.println(" ");
                            }
                            toSet = java.util.Calendar.getInstance().getTime();
                            lectureSlide.setDateUploaded(toSet);
                            lectureSlide.setUploadedBy(chosenInstructor.getName());
                            obj.getAllLectureSlides().add(lectureSlide);




                        }
                        else if(choicetoaddlecturematerial==2){
                            LectureVideo lectureVideo = new LectureVideo();
                            System.out.print("Enter topic of video: ");
                            sc.nextLine();
                            titleforvideo=sc.nextLine();
                            lectureVideo.setTitle(titleforvideo);
                            System.out.println(" ");
                            System.out.print("Enter video filename: ");
                            videofilename = sc.nextLine();
                            if(videofilename.endsWith(".mp4")){
                                lectureVideo.setFilename(videofilename);
                                lectureVideo.setUploadedBy(chosenInstructor.getName());
                                toSet = java.util.Calendar.getInstance().getTime();
                                lectureVideo.setDateUploaded(toSet);
                                obj.getAllLectureVideos().add(lectureVideo);
                            }
                            else{
                                System.out.println("Invalid filename");
                            }




                        }



                    }
                    else if(choiceforInstructortoPick==2){
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        System.out.print("Enter choice:");
                        choicetoaddAssessment = sc.nextInt();
                        Assessment toAdd = new Assessment();
                        if(choicetoaddAssessment==1){
                            toAdd.setType("Assignment");
                            System.out.print("Enter problem statement:");
                            sc.nextLine();
                            AssignmentProblem= sc.nextLine();
                            toAdd.setQuestion(AssignmentProblem);
                            System.out.println(" ");
                            System.out.print("Enter max marks:");
                            AssignmentMaxMarks = sc.nextInt();
                            System.out.println(" ");
                            toAdd.setMaxMarks(AssignmentMaxMarks);
                            toAdd.setId();
                            toAdd.setClosedorNot(false);
                            obj.getAllAssessments().add(toAdd);

                        }
                        else {
                            toAdd.setType("Quiz");
                            System.out.print("Enter question:");
                            sc.nextLine();
                            QuizQuestion= sc.nextLine();
                            toAdd.setQuestion(QuizQuestion);
                            System.out.println(" ");
                            toAdd.setMaxMarks(1);
                            toAdd.setId();
                            toAdd.setClosedorNot(false);
                            obj.getAllAssessments().add(toAdd);
                        }
                        for(int t =0;t<ListofAllStudents.size();t++){
                            ListofAllStudents.get(t).getPendingAssessments().add(toAdd);
                            ListofAllStudents.get(t).getAnswersSubmitted().add("None");
                            ListofAllStudents.get(t).getMarksofAssessments().add(0);
                            ListofAllStudents.get(t).getAssessmentCheckedby().add("None");
                        }



                    }








                    else if (choiceforInstructortoPick==3){

                        chosenInstructor.ViewLectureMaterials(obj);

                    }
                    else if(choiceforInstructortoPick==4){
                        chosenInstructor.ViewAssessments(obj);
                    }
                    else if(choiceforInstructortoPick==5){
                        for(int m =0;m<obj.getAllAssessments().size();m++){
                            System.out.println("ID:"+obj.getAllAssessments().get(m).getId()+" "+obj.getAllAssessments().get(m).getType()+":"+obj.getAllAssessments().get(m).getQuestion()+" Max Marks:"+obj.getAllAssessments().get(m).getMaxMarks());
                        }
                        System.out.print("Enter ID of assignment to view submissions:");
                        idtoevaluate=sc.nextInt();
                        System.out.println(" ");
                        Assessment toEvaluate = new Assessment();
                        for(int b=0;b<obj.getAllAssessments().size();b++){
                            toEvaluate = obj.getAllAssessments().get(b);
                            if (toEvaluate.getId()==idtoevaluate){
                                break;
                            }
                        }


                        System.out.println("Submissions:");
                        Student s;
                        for (int d=0;d<ListofAllStudents.size();d++){
                            s = ListofAllStudents.get(d);
                            for (int f=0;f<s.getUngradedAssessments().size();f++){
                                if (s.getUngradedAssessments().get(f).getId()==toEvaluate.getId()){
                                    System.out.println(s.getId()+"-"+s.getName());
                                }
                            }

                        }
                        System.out.print("Enter ID:");
                        idofstudent= sc.nextInt();
                        System.out.println(" ");
                        Student toCheckFor = ListofAllStudents.get(0);
                        for (int c=0;c<ListofAllStudents.size();c++){
                            toCheckFor=ListofAllStudents.get(c);
                            if (toCheckFor.getId()==idofstudent){
                                break;
                            }
                        }
                        System.out.println("Submission:");
                        System.out.print("Submission:");
                        System.out.println(toCheckFor.getAnswersSubmitted().get(toEvaluate.getId()));
                        System.out.println("Max Marks:"+obj.getAllAssessments().get(toEvaluate.getId()).getMaxMarks());
                        System.out.print("Marks scored:");
                        markstogive=sc.nextInt();
                        System.out.println(" ");
                        toCheckFor.getMarksofAssessments().set(toEvaluate.getId(),markstogive);
                        toCheckFor.getGradedAssessments().add(toEvaluate);
                        toCheckFor.getUngradedAssessments().remove(toEvaluate);
                        toCheckFor.getAssessmentCheckedby().set(toEvaluate.getId(),chosenInstructor.getName());






                    }
                    else if(choiceforInstructortoPick==6){
                        System.out.println("List of open assignments:");
                        for (int q=0;q<obj.getAllAssessments().size();q++){
                            Assessment a = obj.getAllAssessments().get(q);
                            if(!a.isClosedorNot()){
                                System.out.println("ID:"+a.getId()+" "+a.getType()+":"+a.getQuestion()+" Max Marks:"+a.getMaxMarks());

                            }
                        }
                        System.out.print("Enter the id of assignment to close:");
                        idtoclose=sc.nextInt();
                        System.out.println(" ");
                        Assessment toClose = obj.getAllAssessments().get(idtoclose);
                        toClose.setClosedorNot(true);

                    }
                    else if (choiceforInstructortoPick==8){
                        System.out.print("Enter comment:");
                        sc.nextLine();
                        CommentbyInstructor = sc.nextLine();
                        date = java.util.Calendar.getInstance().getTime();
                        chosenInstructor.AddComments(obj,CommentbyInstructor,date,chosenInstructor.getName());

                    }
                    else if (choiceforInstructortoPick==7){
                        chosenInstructor.ViewComments(obj);
                    }
                    chosenInstructor.displayInstructorMenu();
                    System.out.print("Choose choice :");
                    choiceforInstructortoPick = sc.nextInt();
                    System.out.println("");

                }





            }

            else if(choice ==2){
                for (int u=0;u<ListofAllStudents.size();u++){
                    System.out.println(u+"-"+ListofAllStudents.get(u).getName());
                }
                System.out.print("Enter choice :");
                choiceforStudent=sc.nextInt();
                Student chosenStudent = ListofAllStudents.get(choiceforStudent);
                System.out.println(" ");
                System.out.println("Welcome "+chosenStudent.getName());
                chosenStudent.displayStudentMenu();
                System.out.println(" ");
                System.out.print("Enter choice : ");
                choiceforStudenttoPick=sc.nextInt();
                System.out.println(" ");
                while (choiceforStudenttoPick!=7){
                    if (choiceforStudenttoPick==1){
                        chosenStudent.ViewLectureMaterials(obj);
                    }
                    else if(choiceforStudenttoPick==2){
                        chosenStudent.ViewAssessments(obj);
                    }
                    else if(choiceforStudenttoPick==3){
                        if(chosenStudent.getPendingAssessments().isEmpty()){
                            System.out.println("No pending assignments");
                        }
                        else{

                            Assessment A = new Assessment();
                            for(int o = 0;o<chosenStudent.getPendingAssessments().size();o++){
                                A = chosenStudent.getPendingAssessments().get(o);
                                if (!A.isClosedorNot()){
                                    PossibleAssessmentstoSubmit.add(A);
                                }
                            }
                            if (PossibleAssessmentstoSubmit.isEmpty()){
                                System.out.println("No pending assessments");

                            }
                            else {
                                for (int r=0;r<PossibleAssessmentstoSubmit.size();r++){
                                    System.out.println("ID:"+PossibleAssessmentstoSubmit.get(r).getId()+" "+PossibleAssessmentstoSubmit.get(r).getType()+":"+PossibleAssessmentstoSubmit.get(r).getQuestion()+"Max Marks:"+PossibleAssessmentstoSubmit.get(r).getMaxMarks());
                                }
                                System.out.print("Enter ID:");
                                idforAssessment= sc.nextInt();
                                toSubmit = chosenStudent.getPendingAssessments().get(0);
                                for (int w=0;w<chosenStudent.getPendingAssessments().size();w++){
                                    toSubmit = chosenStudent.getPendingAssessments().get(w);
                                    if(toSubmit.getId()==idforAssessment){
                                        break;
                                    }

                                }
                                System.out.println(" ");
                                if(toSubmit.getType().equals("Assignment")){
                                    System.out.print("Enter filename to submit:");
                                    sc.nextLine();
                                    filenametosubmit= sc.nextLine();
                                    if(filenametosubmit.endsWith(".zip")){
                                        chosenStudent.getAnswersSubmitted().set(toSubmit.getId(),filenametosubmit);
                                        chosenStudent.getUngradedAssessments().add(toSubmit);
                                        chosenStudent.getPendingAssessments().remove(toSubmit);

                                    }
                                    else {
                                        System.out.println("Invalid filename");
                                    }
                                }
                                else if(toSubmit.getType().equals("Quiz")){
                                    System.out.print(toSubmit.getQuestion());
                                    sc.nextLine();
                                    QuizAnswer = sc.nextLine();
                                    chosenStudent.getAnswersSubmitted().set(toSubmit.getId(),QuizAnswer);
                                    chosenStudent.getUngradedAssessments().add(toSubmit);
                                    chosenStudent.getPendingAssessments().remove(toSubmit);
                                }
                                PossibleAssessmentstoSubmit.clear();

                            }
                            PossibleAssessmentstoSubmit.clear();

                        }


                    }
                    else if(choiceforStudenttoPick==4){

                        System.out.println("Graded Submissions:");
                        if(!chosenStudent.getGradedAssessments().isEmpty()){
                            System.out.println("Checking");
                            for(int z = 0;z<chosenStudent.getGradedAssessments().size();z++){
                                Assessment assessment = chosenStudent.getGradedAssessments().get(z);
                                for (int g=0;g<obj.getAllAssessments().size();g++){
                                    if (assessment.getId()==obj.getAllAssessments().get(g).getId()){
                                        indextofind=g;
                                        break;
                                    }
                                }
                                if (indextofind==assessment.getId()){
                                    System.out.println("Submission:"+chosenStudent.getAnswersSubmitted().get(indextofind));
                                    System.out.println("Marks scored:"+chosenStudent.getMarksofAssessments().get(indextofind));
                                    System.out.println("Graded by"+chosenStudent.getAssessmentCheckedby().get(indextofind));
                                }
                            }
                        }
                        System.out.println("Ungraded Submissions:");
                        if (!chosenStudent.getUngradedAssessments().isEmpty()){
                            for (int s=0;s<chosenStudent.getUngradedAssessments().size();s++){
                                System.out.println("ID:"+chosenStudent.getUngradedAssessments().get(s).getId()+" "+chosenStudent.getUngradedAssessments().get(s).getType()+":"+chosenStudent.getUngradedAssessments().get(s).getQuestion()+" Max Marks: "+chosenStudent.getUngradedAssessments().get(s).getMaxMarks());
                            }
                        }



                    }
                    else if(choiceforStudenttoPick==6){
                        System.out.print("Enter Comment:");
                        sc.nextLine();
                        CommentbyStudent=sc.nextLine();
                        date2 = java.util.Calendar.getInstance().getTime();
                        chosenStudent.AddComments(obj,CommentbyStudent,date2,chosenStudent.getName());

                    }
                    else if(choiceforStudenttoPick==5){
                        chosenStudent.ViewComments(obj);
                    }
                    chosenStudent.displayStudentMenu();
                    System.out.println(" ");
                    System.out.print("Enter choice : ");
                    choiceforStudenttoPick=sc.nextInt();
                    System.out.println(" ");
                }

            }
            else if(choice==3){
                break;
            }


        }


    }
}
