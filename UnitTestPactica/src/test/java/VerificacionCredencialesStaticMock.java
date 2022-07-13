import authenticationStatic.Authentication;
import authenticationStatic.CredentialsStaticService;
import authenticationStatic.PermissionStaticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class VerificacionCredencialesStaticMock {
    //Valores Correctos
    @Test
    public void VerificarLoginStatic(){
        String permission="CR";
        MockedStatic <CredentialsStaticService> CredentialsMock= Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> PermissionMock=Mockito.mockStatic(PermissionStaticService.class);

        CredentialsMock.when(()->CredentialsStaticService.isValidCredential("Enzo","Aranibar")).thenReturn(true);
        PermissionMock.when(()->PermissionStaticService.getPermission("Enzo")).thenReturn("CR");

        Authentication authenticationStatic=new Authentication();

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authenticationStatic.login("Enzo","Aranibar");
        Assertions.assertEquals(expectedResult,actualResult,"Error en la Autentificacion");

        CredentialsMock.close();
        PermissionMock.close();
    }
    //Valores inCorrectos
    @Test
    public void VerificarLoginStaticMock_CRD(){
        String permission="CRD";
        MockedStatic <CredentialsStaticService> CredentialsMock= Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> PermissionMock=Mockito.mockStatic(PermissionStaticService.class);

        CredentialsMock.when(()->CredentialsStaticService.isValidCredential("Enzo","Aranibarr")).thenReturn(true);
        PermissionMock.when(()->PermissionStaticService.getPermission("Enzo")).thenReturn("CRD");

        Authentication authenticationStatic=new Authentication();

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authenticationStatic.login("Enzo","Aranibarr");
        Assertions.assertEquals(expectedResult,actualResult,"Error en la Autentificacion");

        CredentialsMock.close();
        PermissionMock.close();
    }
    //
    @Test
    public void VerificarLoginStaticMock_CUD(){
        String permission="CUD";
        MockedStatic <CredentialsStaticService> CredentialsMock= Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> PermissionMock=Mockito.mockStatic(PermissionStaticService.class);

        CredentialsMock.when(()->CredentialsStaticService.isValidCredential("patma_lm@gmail.com","Juma")).thenReturn(true);
        PermissionMock.when(()->PermissionStaticService.getPermission("patma_lm@gmail.com")).thenReturn("CUD");

        Authentication authenticationStatic=new Authentication();

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authenticationStatic.login("patma_lm@gmail.com","Juma");
        Assertions.assertEquals(expectedResult,actualResult,"Error en la Autentificacion");

        CredentialsMock.close();
        PermissionMock.close();
    }
    //Prueba para un usuario que tiene privilegios de Lectura=R
    @Test
    public void VerificarLoginStaticMock_R(){
        String permission="R";
        MockedStatic <CredentialsStaticService> CredentialsMock= Mockito.mockStatic(CredentialsStaticService.class);
        MockedStatic<PermissionStaticService> PermissionMock=Mockito.mockStatic(PermissionStaticService.class);

        CredentialsMock.when(()->CredentialsStaticService.isValidCredential("samuelZ","Joselin")).thenReturn(true);
        PermissionMock.when(()->PermissionStaticService.getPermission("samuelZ")).thenReturn("R");

        Authentication authenticationStatic=new Authentication();

        String expectedResult="user authenticated successfully with permission: ["+permission+"]";
        String actualResult=authenticationStatic.login("samuelZ","Joselin");
        Assertions.assertEquals(expectedResult,actualResult,"Error en la Autentificacion");

        CredentialsMock.close();
        PermissionMock.close();
    }

}
