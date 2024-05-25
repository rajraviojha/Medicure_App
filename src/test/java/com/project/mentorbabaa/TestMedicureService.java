import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.mentorbabaa.Doctor;
import com.project.mentorbabaa.MedicureService;
import com.project.mentorbabaa.MedicureApplication; // Make sure to import MedicureApplication

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MedicureApplication.class)
public class TestMedicureService {

    @Autowired
    MedicureService doctorService;

    @Test
    public void testRegisterDoctor() {
        Doctor doctor = new Doctor("MP1110","Shubham","Neurologist","15 Years");
        Doctor registeredDoctor = doctorService.registerDoctor(doctor);
        assertNotNull(registeredDoctor); // Assertions is statically imported, so no need for Assertions.
        assertEquals(doctor.getDoctorRegistrationId(), registeredDoctor.getDoctorRegistrationId());
    }
}
