import java.util.*;


class Appointment {
    int appointmentId;
    int patientId;
    Date appointmentDate;
    String doctor;
    
    public Appointment(int appointmentId, int patientId, Date appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Date: " + appointmentDate + ", Doctor: " + doctor;
    }
}

class Bill {
    int patientId;
    double amountDue;
    boolean isPaid;

    public Bill(int patientId, double amountDue) {
        this.patientId = patientId;
        this.amountDue = amountDue;
        this.isPaid = false;
    }

    public void payBill() {
        isPaid = true;
        System.out.println("Bill paid for patient ID: " + patientId);
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Amount Due: " + amountDue + ", Paid: " + isPaid;
    }
}



class EHR {
    int patientId;
    List<String> medicalHistory;
    
    public EHR(int patientId) {
        this.patientId = patientId;
        this.medicalHistory = new ArrayList<>();
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Medical History: " + medicalHistory;
    }
}

class Inventory {
    Map<String, Integer> supplies;

    public Inventory() {
        this.supplies = new HashMap<>();
    }

    public void addSupply(String itemName, int quantity) {
        supplies.put(itemName, supplies.getOrDefault(itemName, 0) + quantity);
    }

    public void useSupply(String itemName, int quantity) {
        if (supplies.containsKey(itemName)) {
            int currentQuantity = supplies.get(itemName);
            if (currentQuantity >= quantity) {
                supplies.put(itemName, currentQuantity - quantity);
            } else {
                System.out.println("Insufficient stock for: " + itemName);
            }
        } else {
            System.out.println("Item not found: " + itemName);
        }
    }

    @Override
    public String toString() {
        return "Inventory: " + supplies.toString();
    }
}
class Patient {
    String name;
    int patientId;
    String dob;
    String gender;
    String contact;
    
    public Patient(String name, int patientId, String dob, String gender, String contact) {
        this.name = name;
        this.patientId = patientId;
        this.dob = dob;
        this.gender = gender;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name + ", DOB: " + dob + ", Gender: " + gender + ", Contact: " + contact;
    }
}

class Staff {
    String name;
    int staffId;
    String role;
    String department;
    
    public Staff(String name, int staffId, String role, String department) {
        this.name = name;
        this.staffId = staffId;
        this.role = role;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Role: " + role + ", Department: " + department;
    }
}




public class HospitalManagementSystem {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static List<Staff> staffList = new ArrayList<>();
    private static Map<Integer, EHR> patientEHR = new HashMap<>();
    private static Map<Integer, Bill> bills = new HashMap<>();
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //  Adding Paitents
        Patient patient1 = new Patient("Pavan Kumar", 1, "2003-07-05", "Male", "7671004239");
        patients.add(patient1);
        
        Patient patient2 = new Patient("Jhansi", 2, "1981-12-12", "Female", "9878787878");
        patients.add(patient2);

        Patient patient3 = new Patient("Naresh", 3, "2002-03-15", "Male", "999999999");
        patients.add(patient3);

        Patient patient4 = new Patient("Yashaswini", 4, "2002-06-25", "Female", "7777777777");
        patients.add(patient4);

        Patient patient5 = new Patient("Babai", 5, "2003-12-30", "Male", "8989998898");
        patients.add(patient5);

        Patient patient6 = new Patient("Harshitha", 6, "2000-04-10", "Female", "555555555");
        patients.add(patient6);

        Patient patient7 = new Patient("Venky", 7, "1978-08-18", "Male", "556767566");
        patients.add(patient7);
       
        //Adding Appointments
        Appointment appointment1 = new Appointment(1, 1, new Date(), "Dr. Gopal");
        appointments.add(appointment1);
        
        Appointment appointment2 = new Appointment(2, 2, new Date(), "Dr. Rambabu");
        appointments.add(appointment2);

        Appointment appointment3 = new Appointment(3, 3, new Date(), "Dr. Ashok");
        appointments.add(appointment3);

        Appointment appointment4 = new Appointment(4, 4, new Date(), "Dr. Rambabu");
        appointments.add(appointment4);

        //Adding EHR
        EHR ehr1 = new EHR(1);
        ehr1.addRecord("Initial Check-up");
        patientEHR.put(1, ehr1);
        EHR ehr2 = new EHR(2);

        ehr2.addRecord("Diagnosed with seasonal allergies.");
        ehr2.addRecord("Prescribed antihistamines.");
        patientEHR.put(2, ehr2);

        EHR ehr3 = new EHR(3);
        ehr3.addRecord("High blood pressure observed.");
        ehr3.addRecord("Advised low sodium diet.");
        patientEHR.put(3, ehr3);

        EHR ehr4 = new EHR(4);
        ehr4.addRecord("Knee pain reported. X-ray ordered.");
        ehr4.addRecord("Referred to orthopedic specialist.");
        patientEHR.put(4, ehr4);

        EHR ehr5 = new EHR(5);
        ehr5.addRecord("Physical exam conducted. No issues found.");
        ehr5.addRecord("Recommended regular exercise.");
        patientEHR.put(5, ehr5);

        EHR ehr6 = new EHR(6);
        ehr6.addRecord("Reported symptoms of flu.");
        ehr6.addRecord("Flu shot administered.");
        patientEHR.put(6, ehr6);

        EHR ehr7 = new EHR(7);
        ehr7.addRecord("Chronic back pain complaint.");
        ehr7.addRecord("Prescribed physiotherapy sessions.");
        patientEHR.put(7, ehr7);

        //Adding bills
        Bill bill1 = new Bill(1, 200);
        bills.put(1, bill1);

        Bill bill2 = new Bill(2, 150);
        bills.put(2, bill2);

        Bill bill3 = new Bill(3, 300);
        bills.put(3, bill3);

        Bill bill4 = new Bill(4, 450);
        bills.put(4, bill4);

        Bill bill5 = new Bill(5, 120);
        bills.put(5, bill5);

        Bill bill6 = new Bill(6, 250);
        bills.put(6, bill6);

        Bill bill7 = new Bill(7, 310);
        bills.put(7, bill7);

        //Adding Staff
        Staff doctor1 = new Staff("Dr. Gopal", 1, "Doctor", "Cardiology");
        staffList.add(doctor1);

        Staff staff2 = new Staff("Nurse Nikitha", 3, "Nurse", "General Ward");
        staffList.add(staff2);

        Staff staff3 = new Staff("Dr. Ashok", 4, "Doctor", "Orthopedics");
        staffList.add(staff3);

        Staff staff4 = new Staff("Technician Mahesh", 5, "Technician", "Radiology");
        staffList.add(staff4);

        Staff staff5 = new Staff("Receptionist Sarah", 6, "Receptionist", "Front Desk");
        staffList.add(staff5);

        Staff staff6 = new Staff("Dr. Rambabu", 7, "Doctor", "General Medicine");
        staffList.add(staff6);
        

        //Adding Inventory
        
        inventory.addSupply("Bandages", 100);
        inventory.addSupply("Syringes", 500);
        inventory.addSupply("Gloves", 1000);
        inventory.addSupply("Face Masks", 750);
        inventory.addSupply("IV Bags", 300);
        inventory.addSupply("Antibiotic Ointment", 200);
        inventory.addSupply("Thermometers", 100);

        // Main loop to interact with the system
        while (true) {
            System.out.println("\n------7 Hospital Management System ------");
            System.out.println("1. View Patient Information");
            System.out.println("2. View Appointment Details");
            System.out.println("3. View Electronic Health Records of Patient");
            System.out.println("4. View Bill and Payment Status");
            System.out.println("5. View Staff Information");
            System.out.println("6. View Inventory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    viewPatientInfo();
                    break;
                case 2:
                    viewAppointmentDetails();
                    break;
                case 3:
                    viewEHR();
                    break;
                case 4:
                    viewBillAndPaymentStatus();
                    break;
                case 5:
                    viewStaffInfo();
                    break;
                case 6:
                    viewInventory();
                    break;
                case 7:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewPatientInfo() {
        System.out.print("Enter Patient ID to view information: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        boolean found = false;
        for (Patient patient : patients) {
            if (patient.patientId == patientId) {
                System.out.println(patient);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found!");
        }
    }

    private static void viewAppointmentDetails() {
        System.out.print("Enter Appointment ID to view details: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        boolean found = false;
        for (Appointment appointment : appointments) {
            if (appointment.appointmentId == appointmentId) {
                System.out.println(appointment);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment not found!");
        }
    }

    private static void viewEHR() {
        System.out.print("Enter Patient ID to view EHR: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        EHR ehr = patientEHR.get(patientId);
        if (ehr != null) {
            System.out.println(ehr);
        } else {
            System.out.println("EHR not found for this patient!");
        }
    }

    private static void viewBillAndPaymentStatus() {
        System.out.print("Enter Patient ID to view Bill: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        Bill bill = bills.get(patientId);
        if (bill != null) {
            System.out.println(bill);
        } else {
            System.out.println("No bill found for this patient!");
        }
    }

    private static void viewStaffInfo() {
        System.out.print("Enter Staff ID to view information: ");
        int staffId = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        boolean found = false;
        for (Staff staff : staffList) {
            if (staff.staffId == staffId) {
                System.out.println(staff);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Staff not found!");
        }
    }

    private static void viewInventory() {
        System.out.println(inventory);
    }
}
