import java.util.LinkedList;
import java.util.Scanner;

class Vaccine {
    private String name ;
    private int NumberofDoses;
    private int GapbtwDoses;
    public LinkedList<Hospital> HospitalsthathavethisVaccine = new LinkedList<Hospital>();
    public Vaccine(String _name,int _NumberofDoses, int _GapbtwDoses){
        name = _name;
        NumberofDoses = _NumberofDoses;
        GapbtwDoses = _GapbtwDoses;
    }

    public String getName(){
        return name;
    }

    public int getNumberofDoses(){
        return NumberofDoses;
    }
    public int getGapbtwDoses(){
        return GapbtwDoses;
    }

}
class Slot {
    private int DayNumber;
    private int Quantity;
    private Vaccine vaccine;

    public Slot(int _DayNumber, int _Quantity, Vaccine _vaccine){
        DayNumber = _DayNumber;
        Quantity = _Quantity;
        vaccine = _vaccine;
    }
    public int getDayNumber(){
        return DayNumber;
    }
    public int getQuantity(){
        return Quantity;
    }
    public Vaccine getVaccine(){
        return vaccine;
    }
    public void CheckanResetQuantity(){
        if(Quantity<0){
            Quantity = 0;
        }
    }
    public void DecreaseQuantity(int x){

        Quantity = Quantity -x;

    }
}
class Hospital{
    private String name;
    private int pincode;
    private static int idCounter;
    private int id ;
    public LinkedList<Slot> AddedSLots = new LinkedList<Slot>();
    private int ID6Digit;
    public Hospital(String _name,int _pincode){
        name = _name;
        pincode = _pincode;
        ID6Digit = 100000 + idCounter;
        id = idCounter++;


    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPincode(){
        return pincode;
    }
    public void printAddedSlots(){
        System.out.println(AddedSLots);
    }

    public int getID6Digit(){
        return ID6Digit;
    }
}

class Citizen{
    private String name;
    private String ID12Digit;
    private int age ;
    private Vaccine VaccineApplied;
    private int NumberofDosesApplied;
    private int DueDateforNextVaccine;
    private String VaccinationStatus;
    public Citizen(String _name,String _id, int _age){
        name = _name;
        ID12Digit = _id ;
        age = _age;
        NumberofDosesApplied = 0;
        VaccinationStatus = "REGISTERED";
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return ID12Digit;
    }
    public int getAge(){
        return age;
    }
    public Vaccine getVaccineApplied(){
        return VaccineApplied;
    }
    public int getNumberofDosesApplied(){
        return NumberofDosesApplied;
    }
    public int getDueDateforNextVaccine(){
        return DueDateforNextVaccine;
    }
    public void setVaccineApplied(Vaccine vaccine){
        VaccineApplied = vaccine;
    }
    public void setNumberofDosesApplied(int x){
        NumberofDosesApplied = x;
    }
    public void setDueDateforNextVaccine(int x){
        DueDateforNextVaccine = x;
    }
    public String getVaccinationStatus(){
        return VaccinationStatus;
    }
    public void setVaccinationStatus(){
        if(NumberofDosesApplied == 0){
            VaccinationStatus = "REGISTERED";
        }
        else if (0<NumberofDosesApplied && NumberofDosesApplied < VaccineApplied.getNumberofDoses()){
            VaccinationStatus = "PARTIALLY VACCINATED";
        }
        else{
            VaccinationStatus = "FULLY VACCINATED";
        }
    }
    public String getID12Digit(){
        return ID12Digit;
    }
}






public class Portal {
    public static void Menu(){
        System.out.println("-------------------------------");
        System.out.print("1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination\n5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit\n");
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Menu();
        int choice = 0;
        String VaccineName = new String();
        int NumberofDoses = 0;
        int GapbtwDoses = 0;
        LinkedList<Vaccine> VaccineRegistered = new LinkedList<Vaccine>();

        String HospitalName = new String();
        int HospitalPincode;
        LinkedList<Hospital> HospitalRegistered = new LinkedList<Hospital>();

        String CitizenName = new String();
        String CitizenId = new String();
        int CitizenAge;
        LinkedList<Citizen> CitizenRegistered = new LinkedList<Citizen>();

        int HospitalId ;
        int NumberofSlots;
        int DayNumber;
        int Quantity;
        int VaccineChoice;

        String UniqueIdforchoice5 = new String();
        int choiceforbooking;
        int Pincodeforchoice5;
        int HospitalIdforchoice5 = 0;
        int slotchoose;
        LinkedList<Slot> AllPossibleSlots = new LinkedList<Slot>();
        String VaccName = new String();
        int HospitalIdforchoice5again;
        int slotchooseagain;
        int slotchooseagainagain;
        LinkedList<Hospital> AllPossibleHospitals = new LinkedList<Hospital>();

        String PatientIdforchoice7 = new String();


        int HospitalIdforchoice6;




        Scanner sc = new Scanner(System.in);
        while(choice!=8){
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            System.out.println(" ");
            if(choice == 1){
                System.out.println("Vaccine Name : ");
                sc.nextLine();
                VaccineName = sc.nextLine();
                System.out.println(" ");
                System.out.print("Number of Doses : ");
                NumberofDoses = sc.nextInt();
                System.out.println(" ");
                System.out.print("Gap between Doses : ");
                GapbtwDoses = sc.nextInt();
                System.out.println(" ");
                System.out.println("Vaccine Name : "+VaccineName+", Number of Doses : "+NumberofDoses+", Gap between Doses : "+ GapbtwDoses);
                Vaccine vacc = new Vaccine(VaccineName,NumberofDoses,GapbtwDoses);
                VaccineRegistered.add(vacc);
            }
            else if (choice == 2){
                System.out.println("Hospital Name : ");
                sc.nextLine();
                HospitalName = sc.nextLine();
                System.out.println(" ");
                System.out.print("Pincode : ");
                HospitalPincode = sc.nextInt();
                System.out.println(" ");
                Hospital hosp = new Hospital(HospitalName,HospitalPincode);
                HospitalRegistered.add(hosp);
                System.out.println("Allocated Hospital Id is "+ hosp.getID6Digit() );
                System.out.println("Hospital Name : "+ hosp.getName()+", Pincode : "+ hosp.getPincode()+", Unique Id : " + hosp.getID6Digit());

            }
            else if (choice == 3){
                System.out.println("Citizen Name : ");
                sc.nextLine();
                CitizenName = sc.nextLine();
                System.out.println(" ");
                System.out.print("Citizen Age : ");
                CitizenAge = sc.nextInt();
                System.out.println(" ");
                System.out.print("Citizen Unique Id : ");
                sc.nextLine();
                CitizenId = sc.nextLine();
                if (CitizenId.length() == 12){
                    System.out.println(" ");
                    System.out.println("Citizen Name : "+CitizenName+", Citizen Age : "+CitizenAge+", Citizen Id : "+CitizenId);
                    if(CitizenAge>=18){
                        Citizen c = new Citizen(CitizenName,CitizenId,CitizenAge);
                        CitizenRegistered.add(c);
                    }
                    else{
                        System.out.println("Only above 18 are allowed");
                    }

                }
                else{
                    System.out.println("Invalid ID");
                }


            }
            else if (choice == 4){

                System.out.print("Enter Hospital Id : ");
                HospitalId = sc.nextInt();
                System.out.println(" ");
                Hospital h = HospitalRegistered.get(0);
                for(int i = 0; i<HospitalRegistered.size();i++){
                    h = HospitalRegistered.get(i);
                    if (h.getID6Digit() == HospitalId){
                        break;
                    }
                }
                if (h.getID6Digit() == HospitalId){
                    System.out.print("Enter number of slots to be added : ");
                    NumberofSlots = sc.nextInt() ;
                    for (int j = 0;j < NumberofSlots;j++){
                        System.out.print("Enter Day Number : ");
                        DayNumber = sc.nextInt();
                        System.out.println(" ");
                        System.out.print("Enter Quantity : ");
                        Quantity = sc.nextInt();
                        System.out.println(" ");
                        System.out.println("Select Vaccine");
                        for (int k = 0 ; k<VaccineRegistered.size();k++){
                            Vaccine v = VaccineRegistered.get(k);
                            System.out.println(k + ". " + v.getName());
                        }
                        VaccineChoice = sc.nextInt();
                        Vaccine ToAddToSlot = VaccineRegistered.get(VaccineChoice);
                        Slot ToAddToHospital = new Slot(DayNumber,Quantity,ToAddToSlot);
                        h.AddedSLots.add(ToAddToHospital);
                        if(ToAddToSlot.HospitalsthathavethisVaccine.isEmpty()){
                            ToAddToSlot.HospitalsthathavethisVaccine.add(h);
                        }
                        else {
                            if (!ToAddToSlot.HospitalsthathavethisVaccine.contains(h)){
                                ToAddToSlot.HospitalsthathavethisVaccine.add(h);
                            }
                        }
                        System.out.println("Slot Added by Hospital "+h.getID6Digit()+" for Day : "+DayNumber+" , Quantity Available : "+Quantity+" of Vaccine "+ToAddToSlot.getName());



                    }

                }


            }

            else if (choice == 5){

                System.out.print("Enter patient Unique Id : ");
                sc.nextLine();
                UniqueIdforchoice5 = sc.nextLine();
                System.out.println(" ");
                Citizen PersontoBookfor = CitizenRegistered.get(0);
                for (int m = 0; m<CitizenRegistered.size();m++){
                    PersontoBookfor = CitizenRegistered.get(m);
                    if(PersontoBookfor.getID12Digit().equals(UniqueIdforchoice5)){
                        break;
                    }
                }
                if (!PersontoBookfor.getID12Digit().equals(UniqueIdforchoice5)){
                    System.out.println("Invalid ID");
                }
                else {
                    System.out.println("1. Search by area");
                    System.out.println("2. Seach by vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter option : ");
                    choiceforbooking = sc.nextInt();
                    if (choiceforbooking == 1){
                        if (PersontoBookfor.getID12Digit().equals(UniqueIdforchoice5)){
                            System.out.print("Enter pincode : ");
                            Pincodeforchoice5 = sc.nextInt();
                            Hospital H = HospitalRegistered.get(0);
                            for(int x = 0;x<HospitalRegistered.size();x++){
                                H=HospitalRegistered.get(x);
                                if(H.getPincode() == Pincodeforchoice5){
                                    AllPossibleHospitals.add(H);
                                }
                            }
                            if (AllPossibleHospitals.isEmpty()){
                                System.out.println("No hospitals in your area ");
                            }
                            else{

                                for (int o = 0;o<AllPossibleHospitals.size();o++){
                                    System.out.println(AllPossibleHospitals.get(o).getID6Digit()+" "+AllPossibleHospitals.get(o).getName());
                                }
                                System.out.print("Enter hospital Id : ");
                                HospitalIdforchoice5 = sc.nextInt();
                                System.out.println(" ");
                                Hospital ToGet = HospitalRegistered.get(0);
                                for (int y = 0; y<AllPossibleHospitals.size();y++){
                                    ToGet = AllPossibleHospitals.get(y);
                                    if (ToGet.getPincode() == Pincodeforchoice5 && ToGet.getID6Digit()==HospitalIdforchoice5){
                                        break;
                                    }
                                }
                                AllPossibleHospitals.clear();
                                if(ToGet.getID6Digit() != HospitalIdforchoice5){
                                    System.out.println("Invalid Hospital ID");
                                }
                                else {
                                    if (PersontoBookfor.getNumberofDosesApplied()== 0){

                                        Slot s = ToGet.AddedSLots.get(0);

                                        for (int u = 0;u <ToGet.AddedSLots.size(); u++){
                                            s = ToGet.AddedSLots.get(u);
                                            s.CheckanResetQuantity();
                                            System.out.println(u+"->"+"Day :"+s.getDayNumber()+", Available Quantity : "+s.getQuantity()+", Vaccine : "+ s.getVaccine().getName());
                                        }
                                        System.out.print("Choose slot : ");
                                        slotchoose = sc.nextInt();
                                        System.out.println(" ");
                                        Slot ChosenSlot = ToGet.AddedSLots.get(slotchoose);
                                        if(ChosenSlot.getQuantity()>0){
                                            System.out.println("Slot Booked");
                                            ChosenSlot.DecreaseQuantity(1);
                                            PersontoBookfor.setNumberofDosesApplied(PersontoBookfor.getNumberofDosesApplied()+1);
                                            PersontoBookfor.setVaccineApplied(ChosenSlot.getVaccine());
                                            if (PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){
                                                PersontoBookfor.setDueDateforNextVaccine(ChosenSlot.getDayNumber()+ChosenSlot.getVaccine().getGapbtwDoses());
                                            }
                                            PersontoBookfor.setVaccinationStatus();
                                        }
                                        else{
                                            System.out.println("Slot can't be booked");
                                        }


                                    }
                                    else if (0<PersontoBookfor.getNumberofDosesApplied() && PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){

                                        Slot ToCheck = ToGet.AddedSLots.get(0);
                                        System.out.println(AllPossibleSlots);

                                        for (int q = 0 ; q<ToGet.AddedSLots.size();q++){
                                            ToCheck = ToGet.AddedSLots.get(q);
                                            ToCheck.CheckanResetQuantity();
                                            if (ToCheck.getDayNumber()>=PersontoBookfor.getDueDateforNextVaccine() && ToCheck.getVaccine().getName().equals(PersontoBookfor.getVaccineApplied().getName()) && ToCheck.getQuantity()>0){
                                                AllPossibleSlots.add(ToCheck);
                                            }
                                        }
                                        if (!AllPossibleSlots.isEmpty()){
                                            Slot slottoprint =AllPossibleSlots.get(0);
                                            for (int w = 0;w<AllPossibleSlots.size();w++){
                                                 slottoprint = AllPossibleSlots.get(w);
                                                System.out.println(w+"-> Day : "+slottoprint.getDayNumber()+", Available Quantity : "+slottoprint.getQuantity()+", Vaccine Name : "+slottoprint.getVaccine().getName());

                                            }

                                            System.out.print("Enter Slot : ");
                                            slotchoose = sc.nextInt();
                                            System.out.println(" ");
                                            Slot SlotChosen = AllPossibleSlots.get(slotchoose);
                                            System.out.println("Slot Booked");
                                            SlotChosen.DecreaseQuantity(1);
                                            PersontoBookfor.setNumberofDosesApplied(PersontoBookfor.getNumberofDosesApplied()+1);
                                            if (PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){
                                                PersontoBookfor.setDueDateforNextVaccine(SlotChosen.getDayNumber()+PersontoBookfor.getVaccineApplied().getGapbtwDoses());
                                            }
                                            PersontoBookfor.setVaccinationStatus();
                                            AllPossibleSlots.clear();


                                        }
                                        else{
                                            System.out.println("No slots available");
                                        }

                                    }

                                }






                            }
                            }
                        }




                    else if (choiceforbooking == 2){

                        System.out.print("Enter Vaccine Name : ");
                        sc.nextLine();
                        VaccName = sc.nextLine();
                        Vaccine vac = VaccineRegistered.get(0);
                        for (int z = 0;z<VaccineRegistered.size();z++){
                            vac = VaccineRegistered.get(z);
                            if(vac.getName().equals(VaccName)){
                                break;
                            }
                        }
                       if (!vac.getName().equals(VaccName)){

                           System.out.println("Invalid Vaccine Name");

                       }
                       else {
                           for (int y = 0;y<vac.HospitalsthathavethisVaccine.size();y++){
                               System.out.println(vac.HospitalsthathavethisVaccine.get(y).getID6Digit()+" "+vac.HospitalsthathavethisVaccine.get(y).getName());

                           }
                           System.out.print("Enter Hospital Id : ");
                           HospitalIdforchoice5again = sc.nextInt();
                           System.out.println(" ");
                           Hospital ToSearchFor = vac.HospitalsthathavethisVaccine.get(0);
                           for (int h = 0 ; h<vac.HospitalsthathavethisVaccine.size();h++){
                               ToSearchFor = vac.HospitalsthathavethisVaccine.get(h);
                               if(ToSearchFor.getID6Digit() == HospitalIdforchoice5again){
                                   break;
                               }
                           }
                           if(ToSearchFor.getID6Digit() != HospitalIdforchoice5again){
                               System.out.println("Invalid ID");
                           }
                           else{
                               if (PersontoBookfor.getNumberofDosesApplied() == 0){

                                   for(int t =0;t<ToSearchFor.AddedSLots.size();t++){
                                       ToSearchFor.AddedSLots.get(t).CheckanResetQuantity();
                                       if (ToSearchFor.AddedSLots.get(t).getQuantity()>0 && ToSearchFor.AddedSLots.get(t).getVaccine().getName().equals(vac.getName())){
                                           System.out.println(t+ "->"+"Day : "+ ToSearchFor.AddedSLots.get(t).getDayNumber()+", Available Quantity : "+ ToSearchFor.AddedSLots.get(t).getQuantity()+ ", Vaccine : "+ vac.getName());
                                       }

                                   }
                                   System.out.print("Enter slot : ");
                                   slotchooseagain = sc.nextInt();
                                   System.out.println(" ");
                                   Slot chosen = ToSearchFor.AddedSLots.get(slotchooseagain);
                                   if (chosen.getQuantity()>0 ){
                                       System.out.println("Slot Booked");
                                       chosen.DecreaseQuantity(1);
                                       PersontoBookfor.setNumberofDosesApplied(PersontoBookfor.getNumberofDosesApplied()+1);
                                       PersontoBookfor.setVaccineApplied(chosen.getVaccine());
                                       if (PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){
                                           PersontoBookfor.setDueDateforNextVaccine(chosen.getDayNumber()+chosen.getVaccine().getGapbtwDoses());
                                       }
                                       PersontoBookfor.setVaccinationStatus();


                                   }
                                   else{
                                       System.out.println("Sorry no slot can be booked");
                                   }

                               }
                               else if (0<PersontoBookfor.getNumberofDosesApplied() && PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){
                                   Slot tocheck = ToSearchFor.AddedSLots.get(0);
                                   for (int f = 0; f<ToSearchFor.AddedSLots.size();f++){
                                       tocheck = ToSearchFor.AddedSLots.get(f);
                                       tocheck.CheckanResetQuantity();
                                       if (tocheck.getDayNumber()>=PersontoBookfor.getDueDateforNextVaccine() && tocheck.getVaccine().getName().equals(PersontoBookfor.getVaccineApplied().getName()) && tocheck.getQuantity()>0){
                                           AllPossibleSlots.add(tocheck);
                                       }


                                   }

                                   if (!AllPossibleSlots.isEmpty()){
                                       Slot S = AllPossibleSlots.get(0);
                                       for (int d = 0;d<AllPossibleSlots.size();d++){
                                           S = AllPossibleSlots.get(d);
                                           S.CheckanResetQuantity();
                                           System.out.println(d+"->"+", Day : "+S.getDayNumber()+", Available Quantity"+S.getQuantity()+", Vaccine :"+S.getVaccine().getName());

                                       }
                                       System.out.print("Enter Slot : ");
                                       slotchooseagainagain = sc.nextInt();
                                       Slot ChosenOne = AllPossibleSlots.get(slotchooseagainagain);
                                       ChosenOne.DecreaseQuantity(1);
                                       PersontoBookfor.setNumberofDosesApplied(PersontoBookfor.getNumberofDosesApplied()+1);
                                       if (PersontoBookfor.getNumberofDosesApplied()<PersontoBookfor.getVaccineApplied().getNumberofDoses()){
                                           PersontoBookfor.setDueDateforNextVaccine(ChosenOne.getDayNumber()+PersontoBookfor.getVaccineApplied().getGapbtwDoses());
                                       }
                                       PersontoBookfor.setVaccinationStatus();
                                       AllPossibleSlots.clear();
                                       System.out.println("Slot Booked");

                                   }
                                   else {
                                       System.out.println("Slot can't be booked");
                                   }
                               }
                           }




                       }

                       }
                    else if (choiceforbooking == 3){

                    }
                    }
                }








            else if (choice == 6){

                System.out.print("Enter Hospital Id : ");
                HospitalIdforchoice6 = sc.nextInt();
                Hospital hosp = HospitalRegistered.get(0);
                for (int p = 0; p<HospitalRegistered.size();p++){
                    hosp = HospitalRegistered.get(p);
                    if (hosp.getID6Digit() == HospitalIdforchoice6){
                        break;
                    }
                }
                if (hosp.getID6Digit() == HospitalIdforchoice6){
                    for (int q = 0;q<hosp.AddedSLots.size();q++){
                        Slot x = hosp.AddedSLots.get(q);
                        x.CheckanResetQuantity();
                        System.out.println("Day : "+x.getDayNumber()+", Vaccine : "+x.getVaccine().getName()+", Available Quantity : "+ x.getQuantity());
                    }

                }
                else{
                    System.out.println("Invalid ID");
                }

            }
            else if(choice == 7){
                System.out.print("Enter Patient Id: ");
                sc.nextLine();
                PatientIdforchoice7 = sc.nextLine();
                Citizen CitizenToCheck = CitizenRegistered.get(0);
                for (int t1 = 0;t1<CitizenRegistered.size();t1++){
                    CitizenToCheck = CitizenRegistered.get(t1);
                    if (CitizenToCheck.getID12Digit().equals(PatientIdforchoice7)){
                        break;
                    }
                }
                if(!CitizenToCheck.getID12Digit().equals(PatientIdforchoice7)){
                    System.out.println("Invalid ID");
                }
                else{
                    if(CitizenToCheck.getID12Digit().equals(PatientIdforchoice7)){
                        if(CitizenToCheck.getVaccinationStatus().equals("FULLY VACCINATED")){
                            System.out.println(CitizenToCheck.getVaccinationStatus());
                            System.out.println("Vaccine given : "+ CitizenToCheck.getVaccineApplied().getName());
                            System.out.println("Number of doses applied : "+ CitizenToCheck.getNumberofDosesApplied());
                        }

                        else if(CitizenToCheck.getVaccinationStatus().equals("PARTIALLY VACCINATED")){
                            System.out.println(CitizenToCheck.getVaccinationStatus());
                            System.out.println("Vaccine given : "+ CitizenToCheck.getVaccineApplied().getName());
                            System.out.println("Number of doses applied : "+CitizenToCheck.getNumberofDosesApplied());
                            System.out.println("Due date for next dose : "+ CitizenToCheck.getDueDateforNextVaccine());

                        }
                        else{
                            System.out.println(CitizenToCheck.getVaccinationStatus());
                        }

                    }
                    else{
                        System.out.println("Invalid Id");
                    }
                }
            }
            else if (choice == 8){
                break;
            }

            AllPossibleSlots.clear();
            AllPossibleHospitals.clear();

            System.out.println("-------------------------------");
            Menu();



        }

    }

}

