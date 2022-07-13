import authentication.Authentication;
import authentication.CredentialsService;
import authentication.PermissionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerificarCredenciales {

    //private Object Mockito;
   // CredentialsService credentialsService= Mockito.mock(CredentialsService.class);
   // PermissionService permissionService=Mockito.mock(PermissionService.class);
    Authentication authentication;
    public  VerificarCredenciales(){
        authentication=new Authentication();
    };

    //Verificaion de Pruebas unitarias sin Mock
    @Test
    public void verificarLogin(){
        String expectedResult="user or password incorrect1";//
        String actualResult=authentication.login("enzoaranibar@gmail.com","**38019@s");
        Assertions.assertEquals(expectedResult,actualResult,"Error Autentifica");

    }
}
