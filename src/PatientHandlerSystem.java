import java.util.*;

// Class representing a Patient
class Patient {
    int id;
    String name;
    int age;
    String gender;
    String contactDetails;
    String medicalHistory;

    public Patient(int id, String name, int age, String gender, String contactDetails, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
    }

    public void updateDetails(String name, int age, String gender, String contactDetails, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contactDetails + ", Medical History: " + medicalHistory;
    }
}

// Class representing an Appointment
class Appointment {
    int appointmentId;
    int patientId;
    String doctor;
    String date;
    String time;

    public Appointment(int appointmentId, int patientId, String doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public void reschedule(String date, String time) {
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: " + doctor + ", Date: " + date + ", Time: " + time;
    }
}

// Class representing Medical Records
class MedicalRecord {
    int recordId;
    int patientId;
    String diagnosis;
    String prescriptions;
    String testResults;

    public MedicalRecord(int recordId, int patientId, String diagnosis, String prescriptions, String testResults) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescriptions = prescriptions;
        this.testResults = testResults;
    }

    public void updateRecord(String diagnosis, String prescriptions, String testResults) {
        this.diagnosis = diagnosis;
        this.prescriptions = prescriptions;
        this.testResults = testResults;
    }

    @Override
    public String toString() {
        return "Record ID: " + recordId + ", Patient ID: " + patientId + ", Diagnosis: " + diagnosis + ", Prescriptions: " + prescriptions + ", Test Results: " + testResults;
    }
}

// Main system class
public class PatientHandlerSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<MedicalRecord> medicalRecords = new ArrayList<>();
    private static int nextPatientId = 1;
    private static int nextAppointmentId = 1;
    private static int nextRecordId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===============Patient Handler System==============");
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Booking");
            System.out.println("3. Medical Records");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handlePatientRegistration();
                    break;
                case 2:
                    handleAppointmentBooking();
                    break;
                case 3:
                    handleMedicalRecords();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    // --- Patient Registration ---
    private static void handlePatientRegistration() {
        while (true) {
            System.out.println("\n========== Patient Registration ==========");
            System.out.println("1. Add new patient");
            System.out.println("2. Update patient details");
            System.out.println("3. Delete patient record");
            System.out.println("4. Search for patient");
            System.out.println("5. View all patients");
            System.out.println("6. Back to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    updatePatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    searchPatient();
                    break;
                case 5:
                    viewPatients();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }










    private static boolean isValidPateintname(String pateintname) {
        return !pateintname.isEmpty() && !pateintname.matches("\\d+");
    }


    private static boolean isValidPatientId(int patientId) {
        return patientId > 0; // Patient ID must be a positive integer
    }
    private static boolean isValidGender(char gender) {
        return gender == 'M' || gender == 'F' || gender == 'O'; // Case-insensitive check is now simpler
    }



    public static void registerPatient() {
        Scanner input = new Scanner(System.in);

        String pateintname;
        while (true) {
            System.out.print("Pateint Name: ");
            pateintname = input.nextLine().trim();
            if (isValidPateintname(pateintname)) break;
            System.out.println("Invalid pateintname! It cannot be empty. Please enter a valid pateintname.");
        }

        int patientId;
        while (true) {
            System.out.print("Patient ID: ");
            if (input.hasNextInt()) { // Check if the input is an integer
                patientId = input.nextInt();
                if (isValidPatientId(patientId)) {
                    break; // Exit the loop if the ID is valid
                } else {
                    System.out.println("Invalid Patient ID! It must be a positive integer.");
                }

                input.nextLine(); // Consume the newline character (important!)
            }
        }

        char gender;  // Use 'gender' instead of 'sex' for clarity
        while (true) {
            System.out.print("Patient Gender (M/F/O): ");
            if (input.hasNext()) {
                String inputStr = input.next().toUpperCase(); // Convert to uppercase for easy validation
                if (inputStr.length() == 1) {
                    gender = inputStr.charAt(0);
                    if (isValidGender(gender)) {
                        break; // Valid gender entered, exit the loop
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single character.");
                }
            }
            input.nextLine(); // Clear the input buffer (crucial!)
        }



      }












    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }













    private static void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter New Contact Details: ");
                String contactDetails = scanner.nextLine();
                System.out.print("Enter New Medical History: ");
                String medicalHistory = scanner.nextLine();

                p.updateDetails(name, age, gender, contactDetails, medicalHistory);
                System.out.println("Patient details updated successfully!");
                return;
            }
        }
        System.out.println("Patient ID not found.");
    }



    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.id == id) {
                iterator.remove();
                System.out.println("Patient record deleted successfully!");
                return;
            }
        }
        System.out.println("Patient ID not found.");
    }

    private static void searchPatient() {
        System.out.print("Enter Patient ID or Name to search: ");
        String input = scanner.nextLine();

        for (Patient p : patients) {
            if (String.valueOf(p.id).equals(input) || p.name.equalsIgnoreCase(input)) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    // --- Appointment Booking ---
    private static void handleAppointmentBooking() {
        while (true) {
            System.out.println("\n=========== Appointment Booking ==========");
            System.out.println("1. Schedule appointment");
            System.out.println("2. View appointments");
            System.out.println("3. Reschedule appointment");
            System.out.println("4. Cancel appointment");
            System.out.println("5. Back to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    rescheduleAppointment();
                    break;
                case 4:
                    cancelAppointment();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void scheduleAppointment() {
        int appointmentId = nextAppointmentId++;
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Time (HH:MM): ");
        String time = scanner.nextLine();

        appointments.add(new Appointment(appointmentId, patientId, doctor, date, time));
        System.out.println("Appointment scheduled successfully! ID: " + appointmentId);
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }

    private static void rescheduleAppointment() {
        System.out.print("Enter Appointment ID to reschedule: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine();

        for (Appointment a : appointments) {
            if (a.appointmentId == appointmentId) {
                System.out.print("Enter New Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter New Time (HH:MM): ");
                String time = scanner.nextLine();

                a.reschedule(date, time);
                System.out.println("Appointment rescheduled successfully!");
                return;
            }
        }
        System.out.println("Appointment ID not found.");
    }

    private static void cancelAppointment() {
        System.out.print("Enter Appointment ID to cancel: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine();

        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment a = iterator.next();
            if (a.appointmentId == appointmentId) {
                iterator.remove();
                System.out.println("Appointment canceled successfully!");
                return;
            }
        }
        System.out.println("Appointment ID not found.");
    }


    // --- Medical Records ---
    private static void handleMedicalRecords() {
        while (true) {
            System.out.println("\n============= Medical Records ============");
            System.out.println("1. Add medical record");
            System.out.println("2. View medical records");
            System.out.println("3. Update medical record");
            System.out.println("4. Delete medical record");
            System.out.println("5. Back to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMedicalRecord();
                    break;
                case 2:
                    viewMedicalRecords();
                    break;
                case 3:
                    updateMedicalRecord();
                    break;
                case 4:
                    deleteMedicalRecord();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addMedicalRecord() {
        int recordId = nextRecordId++;
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Prescriptions: ");
        String prescriptions = scanner.nextLine();
        System.out.print("Enter Test Results: ");
        String testResults = scanner.nextLine();

        medicalRecords.add(new MedicalRecord(recordId, patientId, diagnosis, prescriptions, testResults));
        System.out.println("Medical record added successfully! ID: " + recordId);
    }

    private static void viewMedicalRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records available.");
        } else {
            for (MedicalRecord m : medicalRecords) {
                System.out.println(m);
            }
        }
    }

    private static void updateMedicalRecord() {
        System.out.print("Enter Record ID to update: ");
        int recordId = scanner.nextInt();
        scanner.nextLine();

        for (MedicalRecord m : medicalRecords) {
            if (m.recordId == recordId) {
                System.out.print("Enter New Diagnosis: ");
                String diagnosis = scanner.nextLine();
                System.out.print("Enter New Prescriptions: ");
                String prescriptions = scanner.nextLine();
                System.out.print("Enter New Test Results: ");
                String testResults = scanner.nextLine();

                m.updateRecord(diagnosis, prescriptions, testResults);
                System.out.println("Medical record updated successfully!");
                return;
            }
        }
        System.out.println("Record ID not found.");
    }

    private static void deleteMedicalRecord() {
        System.out.print("Enter Record ID to delete: ");
        int recordId = scanner.nextInt();
        scanner.nextLine();

        Iterator<MedicalRecord> iterator = medicalRecords.iterator();
        while (iterator.hasNext()) {
            MedicalRecord m = iterator.next();
            if (m.recordId == recordId) {
                iterator.remove();
                System.out.println("Medical record deleted successfully!");
                return;
            }
        }
        System.out.println("Record ID not found.");
    }
}