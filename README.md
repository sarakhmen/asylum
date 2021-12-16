# Hospital system
<div align="justify">
The system is designed to process data about doctors, patients, patient admission and treatment.
The system should issue reports at the request of a doctor or administration.

Before admission to the hospital, a meeting between the doctor and the patient is held. The doctor informs the department
admission of patients, about the expected admission of the patient. Each new patient is assigned registration number. The patient must be registered in the system before admission to the hospital
(his data is recorded: full name, address, date of birth, etc.).

After a while, the doctor draws up an appointment with the patient. In this case, he is assigned an ordinal
number and the reception data is recorded. After that, the patient reception department sends the doctor
confirmation of admission. This message includes the patient's registration number, full name,
sequential number of admission, start date of healing, department, room number. If the patient is not
remembers its registration number, the request is executed.

After registration, the patient receives a registration card containing information about him.

While in the hospital, the patient can be treated by several doctors, each of them prescribes
one or more treatments. The data on the courses of treatment are transmitted to the Secretariat, which
coordinates the treatment of patients. The cards are stored there. Data includes number
doctor, patient number, sequential number of the patient's appointment, name of the course of treatment, date
appointment, time and notes (medical history). If necessary, the doctor can invite the story
illness.

After completing the courses of treatment, the doctor decides on the patient's discharge. Forms discharge
epicrisis. When the patient is discharged, the data goes to the reception department, where data on
discharge and the patient is issued a sick note.

The hospital administration can request a patient report for a certain period of time, a report of diseases
over a period of time.
</div>

## How to run
* Install mysql database 

* Build and deploy the project with maven mvn spring-boot:run

* Go to url localhost:8080/