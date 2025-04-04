//package com.certificate.certificate;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.certificate.model.Certificate;
//import com.certificate.repo.CerRepository;
//import com.certificate.service.CerService;
//
//@SpringBootTest
//public class CertificateApplicationTests {
//
//    @InjectMocks
//    private CerService cerService;
//
//    @Mock
//    private CerRepository cerRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAllcert() {
//        // Mock the behavior of cerRepository.findAll()
//        List<Certificate> certificates = new ArrayList<>();
//        certificates.add(new Certificate("Certificate1", 4, 5, 5, "javaTpoint", 4));
//        certificates.add(new Certificate("Certificate2", 3, 4, 5, "certificate", 3));
//        when(cerRepository.findAll()).thenReturn(certificates);
//
//        List<Certificate> result = cerService.getAllcert();
//
//       
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    public void testGetByName() {
//        String certificateName = "python";
//        Certificate certificate = new Certificate("python", 2, 4, 5, "eureka", 4);
//        when(cerRepository.findById(certificateName)).thenReturn(Optional.of(certificate));
//
//        Certificate result = cerService.getByName(certificateName);
//
//      
//        assertEquals(certificateName, result.getCerName());
//    }
//
//    @Test
//    public void testAddCer() {
//        Certificate certificate = new Certificate("Certificate1", 3, 5, 4, "javapoint", 4);
//        when(cerRepository.save(certificate)).thenReturn(certificate);
//
//        Certificate result = cerService.addCer(certificate);
//
//       
//        assertEquals("Certificate1", result.getCerName());
//    }
//
//    @Test
//    public void testDeleteByName() {
//        String certificateName = "Certificate1";
//        doNothing().when(cerRepository).deleteById(certificateName);
//
//        String result = cerService.deleteByName(certificateName);
//
//        assertEquals("deleted", result);
//    }
//
//    @Test
//    public void testUpdateCert() {
//        Certificate certificate = new Certificate("Certificate1", 5, 4, 3, "linkedIn", 3);
//        when(cerRepository.save(certificate)).thenReturn(certificate);
//
//        Certificate result = cerService.updateCert(certificate);
//
//        assertNotNull(result);
//        assertEquals("Certificate1", result.getCerName());
//    }
//}
//
